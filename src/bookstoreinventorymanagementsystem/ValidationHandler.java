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
     * be between 6 and 16 characters long and contain only underscores.
     *
     * @param username the username to validate.
     * @return a ValidationResult indicating whether the username is valid.
     */
    public static ValidationResult validateUsername(String username) {
        if (username.length() < 6 || username.length() > 16) {
            return new ValidationResult(false, "Must be between 6 and 16 characters long");
        }

        if (!containsOnlyUnderscores(username)) {
            return new ValidationResult(false, "Must contain only letters, digits, or underscores");
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
        try (Connection connection = DatabaseManager.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE username = ?"
            );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new ValidationResult(false, "Already exists in the database.");
            }

            return new ValidationResult(true, null);
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
        try (Connection connection = DatabaseManager.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE username = ?"
            );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                return new ValidationResult(false, "Username does not exist");
            }

            return new ValidationResult(true, null);
        }
    }

    /**
     * Validates email address to ensure it has a valid format. The provided
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
            return new ValidationResult(false, "Invalid email format. Must be in format 'user@example.com'");
        }

        return new ValidationResult(true, null);
    }

    /**
     *
     * @param email
     * @return
     * @throws SQLException
     */
    public static ValidationResult checkUniqueEmail(String email) throws SQLException {
        try (Connection connection = DatabaseManager.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE email = ?"
            );

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new ValidationResult(false, "Already exists in the database.");
            }

            return new ValidationResult(true, null);
        }
    }

    /**
     *
     * @param email
     * @return
     * @throws SQLException
     */
    public static ValidationResult checkEmailExistence(String email) throws SQLException {
        try (Connection connection = DatabaseManager.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE email = ?"
            );

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                return new ValidationResult(false, "Email does not exist");
            }

            return new ValidationResult(true, null);
        }
    }

    /**
     *
     * @param usernameOrEmail
     * @return
     * @throws SQLException
     */
    public static ValidationResult validateUsernameOrEmail(String usernameOrEmail)
            throws SQLException {
        boolean isValidUsername = validateUsername(usernameOrEmail).isValid();
        boolean isValidEmail = validateEmail(usernameOrEmail).isValid();

        if (!isValidUsername && !isValidEmail) {
            return new ValidationResult(false, "Please enter a valid username or email");
        }

        if (isValidUsername) {
            ValidationResult usernameExistenceValidation = ValidationHandler
                    .checkUsernameExistence(usernameOrEmail);
            if (!usernameExistenceValidation.isValid()) {
                return usernameExistenceValidation;
            }
        }

        if (isValidEmail) {
            ValidationResult emailExistenceValidation = ValidationHandler
                    .checkEmailExistence(usernameOrEmail);
            if (!emailExistenceValidation.isValid()) {
                return emailExistenceValidation;
            }
        }

        return new ValidationResult(true, null);
    }

    /**
     * Validates password to ensure it meets length and format requirements. The
     * password must be between 8 and 16 characters long and contain a
     * combination of numbers, letters, and symbols. It must not contain any
     * spaces.
     *
     * @param password the password to validate.
     * @return a ValidationResult indicating whether the password is valid.
     */
    public static ValidationResult validatePassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return new ValidationResult(false, "Must be between 8 and 16 characters long");
        }

        if (password.contains(" ")) {
            return new ValidationResult(false, "Must not contain spaces");
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

    public static ValidationResult checkIfNewPasswordMatchesOld(String newPassword, String oldPassword) {
        if (newPassword.equals(oldPassword)) {
            return new ValidationResult(false, "New password must be different from the old password");
        }

        return new ValidationResult(true, null);
    }

    public static ValidationResult checkPasswordMatches(String entered, String actual) {
        if (!entered.equals(actual)) {
            return new ValidationResult(false, "Incorrect password");
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
     * Validates full name to ensure it contains only letters and at most one
     * blank space between words and the name does not end with a blank space.
     *
     * @param fullName the full name to validate.
     * @return a ValidationResult indicating whether the full name is valid.
     */
    public static ValidationResult validateFullName(String fullName) {
        if (!containsOnlyLetters(fullName)) {
            return new ValidationResult(false, "Must contain only letters");
        }

        if (!containsOnlySingleSpace(fullName)) {
            return new ValidationResult(false, "Must contain at most one space and cannot start or end with space");
        }

        return new ValidationResult(true, null);
    }

    /**
     * Validates a mobile number string.
     *
     * @param mobileNumber The mobile number string to validate.
     * @return A ValidationResult object indicating whether the mobile number is
     * valid or not, along with an error message if it's invalid.
     */
    public static ValidationResult validateMobileNumber(String mobileNumber) {
        if (!containsOnlyNumbers(mobileNumber)) {
            return new ValidationResult(false, "Must contain only numbers");
        }
        if (mobileNumber.contains(" ")) {
            return new ValidationResult(false, "Must not contain spaces");
        }
        if (mobileNumber.length() < 10 || mobileNumber.length() > 11) {
            return new ValidationResult(false, "Must be between 10 or 11 characters long");
        }

        return new ValidationResult(true, null);
    }

    /**
     * Checks if the given character is a symbol.
     *
     * @param c the character to check.
     * @return true if the character is a symbol.
     */
    public static boolean isSymbol(char c) {
        return !Character.isLetterOrDigit(c);
    }

    /**
     * Checks if the given string contains only letters, digits, or underscores.
     * Indirectly, it disallows blank space. If the string contains any blank
     * spaces in between characters, the regular expression will not match.
     *
     * @param str the string to check.
     * @return true if the string contains only letters, digits, or underscores.
     */
    public static boolean containsOnlyUnderscores(String str) {
        return str.matches("^[a-zA-Z0-9_]*$");
    }

    /**
     * Checks if the given string contains only letters/alphabets.
     *
     * @param str the string to check.
     * @return true if the string contains only letters.
     */
    public static boolean containsOnlyLetters(String str) {
        return str.matches("^[a-zA-Z ]*$");
    }

    /**
     * Checks if the given string contains at most one blank space between words
     * and does not end with a blank space.
     *
     * @param str the string to check.
     * @return true if the string contains at most one blank space between words
     * and does not end with a space.
     */
    public static boolean containsOnlySingleSpace(String str) {
        return str.matches("^[a-zA-Z]+( [a-zA-z]+)*$");
    }

    /**
     * Checks if the given string contains only numeric characters (0-9).
     *
     * @param str the string to check.
     * @return true if the string contains only numeric characters (0-9), false
     * otherwise.
     */
    public static boolean containsOnlyNumbers(String str) {
        return str.matches("[0-9]+");
    }
    
    /**
     * Checks if a ISBN already exits in the database.
     * This method queries the database to determine if the provided ISBN is already exist.
     * @param isbn the ISBN code to be check for uniqueness.
     * @return a ValidtationResult indicating whether the ISBN code is unique.
     * @throws java.sql.SQLException if  a database access error occurs.
     */
    public static ValidationResult checkUniqueISBN(String isbn) throws SQLException {
        try (Connection connection = DatabaseManager.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE isbn = ?"
            );

            statement.setString(1, isbn);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new ValidationResult(false, "Already exists in the database.");
            }

            return new ValidationResult(true, null);
        }
    }
    
    /**
     * Checks if the given string contains only digital.
     * 
     * @param str the string to check
     * @return a ValidtationResult indicate whether the string only contains digital.
     */
    public static ValidationResult containsOnlyDigital (String str) {
        if(str.matches("\\d+"))
            return new ValidationResult(true, null);
        
        return new ValidationResult(false, "Only digital are accepted");
    }
    
    /**
     * Checks is the format of the string is valid as a normal format of price which is decimal and not more than two decimal place.
     * 
     * @param str the string to check
     * @return 
     */
    public static ValidationResult isValidPrice (String str){
        String regex1 = "\\d+\\.?";
        String regex2 = "\\d+\\.\\d{1,2}$";
        double price =  Double.parseDouble(str);
        if ((str.matches(regex1)||str.matches(regex2))&&price>0.0)
            return new ValidationResult(true, null);
        
        if(price<=0.0)
            return new ValidationResult(false, "Not accepted zero as a value of price");        
        if (!str.matches(regex1))
            return new ValidationResult(false, "Only accepts decimal");
        
        return new ValidationResult(false, "Only one or two decimal places are accepted");
    }
}
