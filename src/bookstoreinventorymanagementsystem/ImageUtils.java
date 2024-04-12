package bookstoreinventorymanagementsystem;

import java.io.BufferedInputStream;
import java.sql.Blob;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 *
 * @author coco1
 */
public class ImageUtils {

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
}
