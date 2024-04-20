package bookstoreinventorymanagementsystem;

import java.sql.Connection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Liew Wen Yen
 */
public class SalesUtils {
    public static String billPath = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Customer Bills";

    static {
        // Create the directory if it doesn't exist
        File directory = new File(billPath);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Directory created successfully: " + billPath);
            } else {
                System.err.println("Failed to create directory: " + billPath);
            }
        }
    }
    public static void savePdfToDatabase(File pdfFile) throws SQLException, IOException {
    FileInputStream fis = null;
    Connection con = null;
    PreparedStatement ps = null;
    
    try {
        // Open input stream for reading the PDF file
        fis = new FileInputStream(pdfFile);

        // Get database connection
        con = DatabaseManager.getConnection();

        // Prepare the SQL insert statement
        String insertQuery = "INSERT INTO pdf_files (file_name, file_data) VALUES (?, ?)";
        ps = con.prepareStatement(insertQuery);
        ps.setString(1, pdfFile.getName()); // Set the file name
        ps.setBinaryStream(2, fis, (int) pdfFile.length()); // Set the file data as binary stream
       
        // Execute the insert statement
        int rowsAffected = ps.executeUpdate();

        // Check if the insertion was successful
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "PDF file successfully saved to the database.");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to save PDF file to the database.");

        }
    } catch (SQLException | IOException e) {

        e.printStackTrace(); 
        throw e; 
    } finally {
        // Close resources in finally block to ensure they are closed even if an exception occurs
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            con.close();
        }
        if (fis != null) {
            fis.close();
        }
    }
}

}
