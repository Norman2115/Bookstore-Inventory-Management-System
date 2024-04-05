package bookstoreinventorymanagementsystem;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Teo Chung Henn
 */
public class UIUtils {

    /**
     * Displays an error message dialog using JOptionPane.
     *
     * @param message the error message to display.
     */
    public static void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(
                null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a success message dialog using JOptionPane.
     *
     * @param message the success message to display.
     */
    public static void displaySuccessMessage(String message) {
        JOptionPane.showMessageDialog(
                null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Resets the state of a text field and its associated error label. It sets
     * the border color of the text field back to its original color and clears
     * the error message displayed in that error label.
     *
     * @param field the text field to reset.
     * @param errorLabel the error label associated with the text field.
     */
    public static void resetFieldState(
            JTextComponent field,
            JLabel errorLabel
    ) {
        field.setBorder(new LineBorder(ColorManager.MEDIUM_GREY));
        errorLabel.setText("");
    }

    /**
     * Sets the error state for a text field and its associated error label
     * based on the validation result. It sets the border color of the text
     * field to red and displays error message in the label if the validation
     * result is invalid. If the field is valid or empty, the method resets the
     * border color to its original color and clears the error message.
     *
     * @param field the text field to set the error state.
     * @param errorLabel the error label associated with the text field.
     * @param validation the validation result indicating whether the text from
     * the field is valid.
     */
    public static void setFieldErrorState(
            JTextComponent field,
            JLabel errorLabel,
            ValidationResult validation
    ) {
        if (field.getText().trim().isEmpty()) {
            resetFieldState(field, errorLabel);
            return;
        }

        if (!validation.isValid()) {
            field.setBorder(new LineBorder(ColorManager.LIGHT_RED));
            errorLabel.setText(validation.getErrorMessage());
            errorLabel.setForeground(ColorManager.MEDIUM_RED);
            Font font = errorLabel.getFont();
            errorLabel.setFont(new Font(font.getName(), font.getStyle(), 10));
            errorLabel.setMaximumSize(new Dimension(386, font.getSize()));
        } else {
            resetFieldState(field, errorLabel);
        }
    }

    /**
     * Marks a text field as required. If the field is empty, it sets the border
     * color to red and displays an error message "Field is required" in the
     * label. Otherwise, if the field contains text, it restores the border
     * color back to original and clears the error message.
     *
     * @param field the text field to mark as required.
     * @param errorLabel the error label associated with the text field.
     */
    public static void markFieldAsRequired(
            JTextComponent field,
            JLabel errorLabel
    ) {
        if (field.getText().trim().isEmpty()) {
            field.setBorder(new LineBorder(ColorManager.LIGHT_RED));
            errorLabel.setText("Field is required");
            errorLabel.setForeground(ColorManager.MEDIUM_RED);
            Font font = errorLabel.getFont();
            errorLabel.setFont(new Font(font.getName(), font.getStyle(), 10));
            errorLabel.setMaximumSize(new Dimension(386, font.getSize()));
        }
    }

    /**
     * Toggles the visibility of the password in a password field and updates
     * the icon. If the password is currently hidden, it will be shown, and the
     * icon will change to represent an open eye. If the password is currently
     * shown, it will be hidden, and the icon will change back to represent a
     * closed eye.
     * <p>
     * The icons are expected to be located in the correct destination provided
     * by the resource paths.
     *
     * @param passwordField the password field to toggle visibility
     * @param toggleIcon the label used to display the eye icon
     */
    public static void togglePasswordVisibility(
            JPasswordField passwordField,
            JLabel toggleIcon
    ) {
        if (passwordField.getEchoChar() != '\0') {
            passwordField.setEchoChar('\0');
            toggleIcon.setIcon(new ImageIcon(
                    UIUtils.class.getResource("/icon/showPasswordIcon.png")));
        } else {
            passwordField.setEchoChar('\u2022');
            toggleIcon.setIcon(new ImageIcon(
                    UIUtils.class.getResource("/icon/hidePasswordIcon.png")));
        }
    }
}
