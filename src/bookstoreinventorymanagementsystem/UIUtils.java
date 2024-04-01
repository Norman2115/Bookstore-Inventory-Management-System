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
}
