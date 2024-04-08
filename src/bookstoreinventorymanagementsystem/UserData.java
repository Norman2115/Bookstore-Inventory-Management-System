package bookstoreinventorymanagementsystem;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Norman
 */
public final class UserData {

    private static UserData instance;

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

    public static UserData getInstance() {
        if (instance == null) {
            instance = new UserData();
        }
        return instance;
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

    public void reset() {
        setUserID(null);
        setFullName(null);
        setUsername(null);
        setEmail(null);
        setPassword(null);
        setRole(null);
        setProfilePicture(null);
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

    public void readPasswordByUsernameOrEmail(String usernameOrEmail) 
            throws SQLException {
        try (Connection connection = DatabaseManager.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT email FROM users WHERE username = ? OR email = ?"
            );

            statement.setString(1, usernameOrEmail);
            statement.setString(2, usernameOrEmail);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                password = resultSet.getString("password");
            }
        }
    }

    public void readEmailByUsername(String username) throws SQLException {
        try (Connection connection = DatabaseManager.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT email FROM users WHERE username = ?"
            );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                email = resultSet.getString("email");
            }
        }
    }

    public void readUserDataFromDatabase() throws SQLException {
        // TODO
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
