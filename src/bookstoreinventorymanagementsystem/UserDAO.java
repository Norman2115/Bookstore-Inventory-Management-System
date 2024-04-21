package bookstoreinventorymanagementsystem;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Data Access Object (DAO) class for managing user data in the database. This
 * class provides methods to interact with the database for CRUD operations
 * related to user data.
 *
 * @author Teo Chung Henn
 */
public class UserDAO {

    /**
     * Retrieves the next available user ID based on the user role. User IDs are
     * generated using a prefix followed by an incrementing number.
     *
     * @param role the role of the user (ADMIN or SALESPERSON).
     * @return the next available user ID.
     * @throws SQLException if an SQL exception occurs or no user ID found.
     */
    private static String getNextUserID(UserRole role) throws SQLException {
        String prefix = (role == UserRole.ADMIN) ? "A" : "S";

        try (Connection connection = DatabaseManager.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT current_user_id FROM user_id_counter WHERE prefix = ?"
            );

            statement.setString(1, prefix);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return prefix + resultSet.getInt("current_user_id");
            } else {
                throw new SQLException("No user ID found in the database");
            }
        }
    }

    /**
     * Updates the password of a user in the database.
     *
     * @param userData the user data containing the user ID.
     * @param newPassword the new password to set.
     * @throws SQLException if an SQL exception occurs.
     */
    public static void updatePassword(UserData userData, String newPassword) throws SQLException {
        try (Connection connection = DatabaseManager.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE user "
                    + "SET password = ? "
                    + "WHERE user_id = ?"
            );

            statement.setString(1, newPassword);
            statement.setString(2, userData.getUserID());

            statement.executeUpdate();
        }
    }

    /**
     * Reads user data from the database based on the username or email.
     *
     * @param usernameOrEmail the username or email of the user.
     * @return the user data retrieved from the database.
     * @throws SQLException if an SQL exception occurs.
     * @throws IOException if an IO exception occurs.
     */
    public static UserData readUserDataFromDatabase(String usernameOrEmail) throws SQLException, IOException {
        UserData userData = new UserData();

        try (Connection connection = DatabaseManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE username = ? OR email = ?"
            );

            statement.setString(1, usernameOrEmail);
            statement.setString(2, usernameOrEmail);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                userData.setUserID(resultSet.getString("user_id"));
                userData.setFullName(resultSet.getString("full_name"));
                userData.setUsername(resultSet.getString("username"));
                userData.setEmail(resultSet.getString("email"));
                userData.setPassword(resultSet.getString("password"));
                userData.setRole(UserRole.valueOf(resultSet.getString("user_role")));
                Blob pictureBlob = resultSet.getBlob("profile_picture");
                userData.setProfilePicture(ImageUtils.convertBlobToByteArray(pictureBlob));
            }
        }

        return userData;
    }

    /**
     * Saves user data to the database.
     *
     * @param userData the user data to save.
     * @throws SQLException if an SQL exception occurs.
     */
    public static void saveUserDataToDatabase(UserData userData) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseManager.getConnection();
            connection.setAutoCommit(false);

            String nextUserID = getNextUserID(userData.getRole());

            statement = connection.prepareStatement(
                    "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, nextUserID);
            statement.setString(2, userData.getFullName());
            statement.setString(3, userData.getUsername());
            statement.setString(4, userData.getEmail());
            statement.setString(5, userData.getPassword());
            statement.setString(6, userData.getRole().toString());
            InputStream inputStream = new ByteArrayInputStream(userData.getProfilePicture());
            statement.setBlob(7, inputStream);
            statement.executeUpdate();

            statement = connection.prepareStatement(
                    "UPDATE user_id_counter "
                    + "SET current_user_id = ? "
                    + "WHERE prefix = ?"
            );
            statement.setInt(1, Integer.parseInt(nextUserID.substring(1)) + 1);
            statement.setString(2, (userData.getRole() == UserRole.ADMIN) ? "A" : "S");
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            if (connection != null) {
                connection.rollback();
            }
            throw ex;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }

    /**
     * Reads the password from the database based on the username or email.
     *
     * @param usernameOrEmail The username or email of the user.
     * @return The password retrieved from the database.
     * @throws SQLException If an SQL exception occurs.
     */
    public static String readPasswordByUsernameOrEmail(String usernameOrEmail) throws SQLException {
        try (Connection connection = DatabaseManager.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT password FROM user WHERE username = ? OR email = ?"
            );

            statement.setString(1, usernameOrEmail);
            statement.setString(2, usernameOrEmail);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("password");
            }
        }

        return null;
    }

    /**
     * Reads the email from the database based on the username.
     *
     * @param username The username of the user.
     * @return The email retrieved from the database.
     * @throws SQLException If an SQL exception occurs.
     */
    public static String readEmailByUsername(String username) throws SQLException {
        try (Connection connection = DatabaseManager.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT email FROM user WHERE username = ?"
            );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("email");
            }
        }

        return null;
    }
}
