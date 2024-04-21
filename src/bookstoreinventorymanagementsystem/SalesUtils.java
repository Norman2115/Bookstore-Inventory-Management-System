package bookstoreinventorymanagementsystem;

import java.io.File;

/**
 *
 * @author Liew Wen Yen
 */
public class SalesUtils {
    public static final String BILL_PATH = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Customer Bills" + File.separator;

    static {
        // Create the directory if it doesn't exist
        File directory = new File(BILL_PATH);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Directory created successfully: " + BILL_PATH);
            } else {
                System.err.println("Failed to create directory: " + BILL_PATH);
            }
        }
    }
}
