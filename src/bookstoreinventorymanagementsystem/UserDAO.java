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
 * User Data Access Object (DAO) for accessing single piece of user data in the
 * database
 *
 * @author coco1
 */
public class UserDAO {

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

    public static void updatePassword(UserData userData, String newPassword) throws SQLException {
        if (userData == null) {
            throw new NullPointerException("UserData cannot be null");
        }

        if (newPassword == null) {
            throw new NullPointerException("New password cannot be null");
        }

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

    public static UserData readUserDataFromDatabase(String usernameOrEmail) throws SQLException, IOException {
        if (usernameOrEmail == null) {
            throw new NullPointerException("Username or email cannot be null");
        }

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

    public static void saveUserDataToDatabase(UserData userData) throws SQLException {
        if (userData == null) {
            throw new NullPointerException("UserData cannot be null");
        }

        if (userData.getFullName() == null) {
            throw new NullPointerException("Full name cannot be null");
        }

        if (userData.getUsername() == null) {
            throw new NullPointerException("Username cannot be null");
        }

        if (userData.getEmail() == null) {
            throw new NullPointerException("Email cannot be null");
        }

        if (userData.getPassword() == null) {
            throw new NullPointerException("Password cannot be null");
        }

        if (userData.getRole() == null) {
            throw new NullPointerException("Role cannot be null");
        }

        if (userData.getProfilePicture() == null) {
            throw new NullPointerException("Profile picture cannot be null");
        }

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

    public static String readPasswordByUsernameOrEmail(String usernameOrEmail) throws SQLException {
        if (usernameOrEmail == null) {
            throw new NullPointerException("Username or email cannot be null");
        }

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

    public static String readEmailByUsername(String username) throws SQLException {
        if (username == null) {
            throw new NullPointerException("Username cannot be null");
        }
        
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
