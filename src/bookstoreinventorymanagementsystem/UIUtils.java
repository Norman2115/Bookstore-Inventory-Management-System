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
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a success message dialog using JOptionPane.
     *
     * @param message the success message to display.
     */
    public static void displaySuccessMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Resets the state of a text field by setting the border color of the text
     * field back to its original color.
     *
     * @param field the text field to reset.
     */
    public static void resetFieldState(JTextComponent field) {
        field.setBorder(new LineBorder(ColorManager.MEDIUM_GREY));
    }

    /**
     * Resets the error label to its default state by clearing the error
     * message.
     *
     * @param errorLabel the error label to reset.
     */
    public static void resetErrorLabel(JLabel errorLabel) {
        errorLabel.setText("");
    }

    public static void setErrorLabelMessage(JLabel errorLabel, String errorMessage) {
        errorLabel.setText(errorMessage);
        errorLabel.setForeground(ColorManager.MEDIUM_RED);
        Font font = errorLabel.getFont();
        errorLabel.setFont(new Font(font.getName(), font.getStyle(), 10));
        errorLabel.setMaximumSize(new Dimension(errorLabel.getWidth(), font.getSize()));
    }

    public static void setFieldErrorState(JTextComponent field) {
        field.setBorder(new LineBorder(ColorManager.LIGHT_RED));
    }

    public static void markFieldAsRequired(JTextComponent field, JLabel errorLabel) {
        field.setBorder(new LineBorder(ColorManager.LIGHT_RED));
        setErrorLabelMessage(errorLabel, "Field is required");
    }

    /**
     * Toggles the visibility of the password in a password field and updates
     * the icon. If the password is currently hidden, it will be shown, and the
     * icon will change to represent an open eye. If the password is currently
     * shown, it will be hidden, and the icon will change back to represent a
     * closed eye.
     *
     * @param passwordField the password field to toggle visibility
     * @param toggleIcon the label used to display the eye icon
     */
    public static void togglePasswordVisibility(JPasswordField passwordField, JLabel toggleIcon) {
        if (passwordField.getEchoChar() != '\0') {
            passwordField.setEchoChar('\0');
            toggleIcon.setIcon(new ImageIcon(UIUtils.class.getResource("/icon/showPasswordIcon.png")));
        } else {
            passwordField.setEchoChar('\u2022');
            toggleIcon.setIcon(new ImageIcon(UIUtils.class.getResource("/icon/hidePasswordIcon.png")));
        }
    }
}
