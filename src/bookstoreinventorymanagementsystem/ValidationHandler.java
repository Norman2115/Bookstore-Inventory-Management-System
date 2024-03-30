package bookstoreinventorymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Norman
 */
public class ValidationHandler {

    public static ValidationResult isValidUsername(String username) {
        if (username.length() < 6 || username.length() > 16) {
            return new ValidationResult(false, "Username must be between 6 and 16 characters long");
        }

        return new ValidationResult(true, null);
    }

    public static ValidationResult isUsernameUnique(String username) throws SQLException {
        try {
            DatabaseManager.connect();
            Connection connection = DatabaseManager.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?"
            );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new ValidationResult(false, "The username is already exists in the database.");
            }
            
            return new ValidationResult(true, null);
        } finally {
            DatabaseManager.closeConnection();
        }
    }

    public static ValidationResult isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return new ValidationResult(false, "Password must be between 8 and 16 characters long");
        }

        boolean hasDigit = false;
        boolean hasLetter = false;
        boolean hasSymbol = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (isSymbol(c)) {
                hasSymbol = true;
            }
        }

        if (!hasDigit || !hasLetter || !hasSymbol) {
            return new ValidationResult(false, "Password must be a combination of numbers, letters and symbols");
        }

        return new ValidationResult(true, null);
    }

    private static boolean isSymbol(char c) {
        return !Character.isLetterOrDigit(c);
    }
}
