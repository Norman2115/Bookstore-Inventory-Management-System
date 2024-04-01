package bookstoreinventorymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Norman
 */
public class ValidationHandler {

    public static ValidationResult validateUsername(String username) {
        if (username.length() < 6 || username.length() > 16) {
            return new ValidationResult(false, "Must be between 6 and 16 characters long");
        }

        return new ValidationResult(true, null);
    }

    public static ValidationResult checkUniqueUsername(String username) throws SQLException {
        try {
            DatabaseManager.connect();
            Connection connection = DatabaseManager.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?"
            );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new ValidationResult(false, "Already exists in the database.");
            }

            return new ValidationResult(true, null);
        } finally {
            DatabaseManager.closeConnection();
        }
    }

    public static ValidationResult checkUsernameExistence(String username) throws SQLException {
        try {
            DatabaseManager.connect();
            Connection connection = DatabaseManager.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?"
            );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                return new ValidationResult(false, "Username does not exist");
            }

            return new ValidationResult(true, null);
        } finally {
            DatabaseManager.closeConnection();
        }
    }
    
    public static ValidationResult validateEmail(String email) {
        Pattern emailPattern = Pattern.compile("^.+@.+(\\.[^\\.]+)+$");
        Matcher matcher = emailPattern.matcher(email);
        
        if (!matcher.matches()) {
            return new ValidationResult(false, "Invalid email format");
        }
        
        return new ValidationResult(true, null);
    }

    public static ValidationResult validatePassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return new ValidationResult(false, "Must be between 8 and 16 characters long");
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
            return new ValidationResult(false, "Must be a combination of numbers, letters and symbols");
        }

        return new ValidationResult(true, null);
    }

    public static ValidationResult confirmPasswordMatches(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            return new ValidationResult(false, "Password do not match");
        }

        return new ValidationResult(true, null);
    }
    
    public static ValidationResult validateVerificationCode(String entered, String actual) {
        if (!entered.equals(actual)) {
            return new ValidationResult(false, "You have entered a wrong code. Please try again");
        }
        
        return new ValidationResult(true, null);
    }

    private static boolean isSymbol(char c) {
        return !Character.isLetterOrDigit(c);
    }
}
