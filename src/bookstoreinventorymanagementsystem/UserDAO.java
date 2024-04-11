package bookstoreinventorymanagementsystem;

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

    public static String readPasswordByUsernameOrEmail(String usernameOrEmail)
            throws SQLException {
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

        return "";
    }

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

        return "";
    }
}
