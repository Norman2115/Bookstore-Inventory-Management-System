package bookstoreinventorymanagementsystem;

import java.sql.Blob;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Norman
 */
public final class UserData {

    private String userID;
    private String fullName;
    private String username;
    private String email;
    private String password;
    private UserRole role;
    private byte[] profilePicture;

    public UserData() {
        setUserID(null);
        setFullName(null);
        setUsername(null);
        setEmail(null);
        setPassword(null);
        setRole(null);
        setProfilePicture(null);
    }

    private String getUserID() {
        return userID;
    }
    
    private void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserRole getRole() {
        return role;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    private String getNextUserID() throws SQLException {
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

    public void updatePassword(String newPassword) throws SQLException {
        try (Connection connection = DatabaseManager.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE user "
                    + "SET password = ? "
                    + "WHERE user_id = ?"
            );

            statement.setString(1, newPassword);
            statement.setString(2, getUserID());

            statement.executeUpdate();
        }
    }

    public void readUserDataFromDatabase(String usernameOrEmail)
            throws SQLException, IOException {
        try (Connection connection = DatabaseManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE username = ? OR email = ?"
            );

            statement.setString(1, usernameOrEmail);
            statement.setString(2, usernameOrEmail);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                userID = resultSet.getString("user_id");
                fullName = resultSet.getString("full_name");
                username = resultSet.getString("username");
                email = resultSet.getString("email");
                password = resultSet.getString("password");
                role = UserRole.valueOf(resultSet.getString("user_role"));
                Blob pictureBlob = resultSet.getBlob("profile_picture");
                profilePicture = ImageUtils.convertBlobToByteArray(pictureBlob);
            }
        }
    }

    public void saveUserDataToDatabase() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseManager.getConnection();
            connection.setAutoCommit(false);

            String nextUserID = getNextUserID();

            statement = connection.prepareStatement(
                    "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, nextUserID);
            statement.setString(2, getFullName());
            statement.setString(3, getUsername());
            statement.setString(4, getEmail());
            statement.setString(5, getPassword());
            statement.setString(6, getRole().toString());
            InputStream inputStream = new ByteArrayInputStream(getProfilePicture());
            statement.setBlob(7, inputStream);
            statement.executeUpdate();

            statement = connection.prepareStatement(
                    "UPDATE user_id_counter "
                    + "SET current_user_id = ? "
                    + "WHERE prefix = ?"
            );
            statement.setInt(1, Integer.parseInt(nextUserID.substring(1)) + 1);
            statement.setString(2, (getRole() == UserRole.ADMIN) ? "A" : "S");
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
}
