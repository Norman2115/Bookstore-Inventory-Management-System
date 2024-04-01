/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

/**
 *
 * @author coco1
 */
public class UIUtils {

    public static void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(
                null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void displaySuccessMessage(String message) {
        JOptionPane.showMessageDialog(
                null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void resetFieldState(
            JTextComponent field,
            JLabel errorLabel
    ) {
        field.setBorder(new LineBorder(ColorManager.MEDIUM_GREY));
        errorLabel.setText("");
    }

    public static void updateFieldState(
            JTextComponent field,
            JLabel errorLabel,
            ValidationResult validation
    ) {
        if (!validation.isValid()) {
            field.setBorder(new LineBorder(ColorManager.LIGHT_RED));
            errorLabel.setText(validation.getErrorMessage());
            errorLabel.setForeground(ColorManager.MEDIUM_RED);
            Font font = errorLabel.getFont();
            errorLabel.setFont(new Font(font.getName(), font.getStyle(), 10));
            errorLabel.setMaximumSize(new Dimension(386, font.getSize()));
        } else {
            field.setBorder(new LineBorder(ColorManager.MEDIUM_GREY));
            errorLabel.setText("");
        }
    }

    public static void markFieldAsRequired(
            JTextComponent field,
            JLabel errorLabel
    ) {
        field.setBorder(new LineBorder(ColorManager.LIGHT_RED));
        errorLabel.setText("Field is required");
        errorLabel.setForeground(ColorManager.MEDIUM_RED);
        Font font = errorLabel.getFont();
        errorLabel.setFont(new Font(font.getName(), font.getStyle(), 10));
        errorLabel.setMaximumSize(new Dimension(386, font.getSize()));
    }
}
