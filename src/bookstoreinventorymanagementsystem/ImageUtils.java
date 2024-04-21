package bookstoreinventorymanagementsystem;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.sql.Blob;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Utility class for common image-related operations.
 *
 * @author Teo Chung Henn
 */
public class ImageUtils {

    /**
     * Converts a Blob object to a byte array.
     *
     * @param blob the Blob object to convert.
     * @return a byte array representing the data in the Blob.
     * @throws IOException if an I/O error occurs.
     * @throws SQLException if a SQL error occurs.
     */
    public static byte[] convertBlobToByteArray(Blob blob) throws IOException, SQLException {
        byte[] byteArray;
        try (InputStream inputStream = blob.getBinaryStream(); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byteArray = baos.toByteArray();
        }
        return byteArray;
    }

    /**
     * Converts a file to a byte array.
     *
     * @param file the file to convert.
     * @return a byte array representing the data stored in the file.
     * @throws IOException if an I/O error occurs.
     */
    public static byte[] convertFileToByteArray(File file) throws IOException {
        byte[] byteArray;
        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(file)); ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byteArray = baos.toByteArray();
        }
        return byteArray;
    }

    /**
     * Sets the picture to the specified JLabel component.
     *
     * @param pictureLabel the JLabel component to which the picture will be
     * set.
     * @param picture the byte array representing the image data.
     */
    public static void setPicture(JLabel pictureLabel, byte[] picture) {
        ImageIcon icon = new ImageIcon(picture);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(pictureLabel.getWidth(),
                pictureLabel.getHeight(), Image.SCALE_SMOOTH);
        pictureLabel.setIcon(new ImageIcon(scaledImage));
        pictureLabel.revalidate();
        pictureLabel.repaint();
    }
}
