package bookstoreinventorymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provides methods for validating user inputs, such as username,
 * email, password etc.
 *
 * @author Teo Chung Henn
 */
public class ValidationHandler {

    /**
     * Validates username to ensure it meets length requirements. Usernames must
     * be between 6 and 16 characters long.
     *
     * @param username the username to validate.
     * @return a ValidationResult indicating whether the username is valid.
     */
    public static ValidationResult validateUsername(String username) {
        if (username.length() < 6 || username.length() > 16) {
            return new ValidationResult(false, "Must be between 6 and 16 characters long");
        }

        return new ValidationResult(true, null);
    }

    /**
     * Checks if a username already exists in the database. This method queries
     * the database to determine if the provided username is already in use.
     *
     * @param username the username to check for uniqueness.
     * @return a ValidationResult indicating whether the username is unique.
     * @throws java.sql.SQLException if a database access error occurs.
     */
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

    /**
     * Checks if a username exists in the database. This method queries the
     * database to determine if the provided username exists.
     *
     * @param username the username to check for existence.
     * @return A ValidationResult indicating whether the username exists.
     * @throws SQLException if a database access error occurs.
     */
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

    /**
     * Validates an email address to ensure it has a valid format. The provided
     * email address must contains a username, followed by the '@' symbol, and
     * then a domain name with at least one dot, such as "user@example.com".
     *
     * @param email the email address to validate.
     * @return a ValidationResult object indicating whether the email address is
     * valid.
     */
    public static ValidationResult validateEmail(String email) {
        Pattern emailPattern = Pattern.compile("^.+@.+(\\.[^\\.]+)+$");
        Matcher matcher = emailPattern.matcher(email);

        if (!matcher.matches()) {
            return new ValidationResult(false, "Invalid email format");
        }

        return new ValidationResult(true, null);
    }

    /**
     * Validates a password to ensure it meets length and format requirements.
     * The password must be between 8 and 16 characters long and contain a
     * combination of numbers, letters, and symbols.
     *
     * @param password the password to validate.
     * @return a ValidationResult indicating whether the password is valid.
     */
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

    /**
     * Checks if two passwords match.
     *
     * @param password the first password.
     * @param confirmPassword the second password to compare against the first.
     * @return a ValidationResult indicating whether the passwords match.
     */
    public static ValidationResult confirmPasswordMatches(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            return new ValidationResult(false, "Password do not match");
        }

        return new ValidationResult(true, null);
    }

    /**
     * Validates verification code entered by the user against the actual
     * verification code to determine if they match.
     *
     * @param entered the verification code entered by the user.
     * @param actual the actual verification code.
     * @return a ValidationResult indicating whether the codes match.
     */
    public static ValidationResult validateVerificationCode(String entered, String actual) {
        if (!entered.equals(actual)) {
            return new ValidationResult(false, "You have entered a wrong code. Please try again");
        }

        return new ValidationResult(true, null);
    }

    /**
     * Checks if the given character is a symbol.
     *
     * @param c the character to check.
     * @return true if the character is a symbol.
     */
    private static boolean isSymbol(char c) {
        return !Character.isLetterOrDigit(c);
    }
}
