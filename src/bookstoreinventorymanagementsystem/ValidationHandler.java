package bookstoreinventorymanagementsystem;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

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

    public static void handleFieldValidation(
            JTextComponent field,
            JLabel errorLabel,
            ValidationResult validation
    ) {
        if (!field.getText().trim().isEmpty()) {
            if (!validation.isValid()) {
                field.setBorder(new LineBorder(ColorManager.RED));
                errorLabel.setText(validation.getErrorMessage());
                errorLabel.setForeground(ColorManager.RED);
                Font font = errorLabel.getFont();
                errorLabel.setFont(new Font(font.getName(), font.getStyle(), 10));
                errorLabel.setMaximumSize(new Dimension(386, font.getSize()));
            } else {
                field.setBorder(new LineBorder(ColorManager.LIGHT_GREEN));
                errorLabel.setText("");
            }
        } else {
            field.setBorder(new LineBorder(ColorManager.MEDIUM_GREY));
            errorLabel.setText("");
        }
    }

    private static boolean isSymbol(char c) {
        return !Character.isLetterOrDigit(c);
    }
}
