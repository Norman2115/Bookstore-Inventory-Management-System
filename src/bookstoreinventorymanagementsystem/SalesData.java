/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.itextpdf.text.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Liew Wen Yen
 */
public class SalesData {

    private final UserData userData;
    private String salesID;
    private String customerID;
    private String orderDate;
    private double totalPrice;
    private int currentID;

    public SalesData(UserData userData) {
        this.salesID = null;
        this.orderDate = null;
        this.totalPrice = 0.0;
        this.userData = userData;
    }

    // Getters and setters
    public String getSalesID() {
        return salesID;
    }

    public void setSalesID(String salesID) {
        this.salesID = salesID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotal(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCurrentSalesID() throws SQLException {
        try (Connection con = DatabaseManager.getConnection()) {
            String query = "SELECT current_sales_id FROM sales_id_counter";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // Check if there is a result
            if (rs.next()) {
                // Retrieve the value of current_sales_id column and concatenate it with "S"
                int salesId = rs.getInt("current_sales_id");
                return "S" + salesId;
            } else {
                // Handle the case where no row is found
                throw new SQLException("No current sales ID found in the database");
            }
        }
    }

    public void setNextSalesID() throws SQLException {
        try (Connection con = DatabaseManager.getConnection()) {
            String query = "SELECT current_sales_id FROM sales_id_counter";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                currentID = rs.getInt("current_sales_id");

                // Update the current ID in the database
                query = "UPDATE sales_id_counter SET current_sales_id = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, currentID + 1);
                ps.executeUpdate();
            }
        }
    }

    public void saveSalesDataToDatabase() throws SQLException {
        try (Connection con = DatabaseManager.getConnection()) {

            SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
            Calendar cal = Calendar.getInstance();
            setOrderDate(myFormat.format(cal.getTime()));
            PreparedStatement ps = con.prepareStatement("INSERT INTO sales_detail(sales_id,salesperson_id, customer_id,sales_date,total_price) VALUES(?,?,?,?,?)");
            ps.setString(1, getCurrentSalesID());
            ps.setString(2, "S1001");
            //ps.setString(2, userData.getUserID());
            ps.setString(3, getCustomerID());
            ps.setString(4, getOrderDate());
            ps.setDouble(5, getTotalPrice());
            ps.executeUpdate();

        }

    }

    public void generateBill(String salesId) throws FileNotFoundException, DocumentException, IOException, SQLException {
        Double salesTotalPrice = 0.0;
        String fileName = salesId + ".pdf";
        String filePath = SalesUtils.billPath + File.separator + fileName;

        // Check if the file already exists
        File existingFile = new File(filePath);
        int count = 1;
        while (existingFile.exists()) {
            fileName = salesId + "(" + count + ").pdf"; // Append a suffix to make the filename unique
            filePath = SalesUtils.billPath + File.separator + fileName;
            existingFile = new File(filePath);
            count++;
        }

        Document document = new Document(PageSize.A5);
        PdfWriter.getInstance(document, new FileOutputStream(filePath));

        document.open();
        // Add header
        PdfPTable header = new PdfPTable(1);
        // Add blue cell
        PdfPCell blueCell = new PdfPCell(new Phrase(""));
        blueCell.setBackgroundColor(new BaseColor(0, 140, 214));
        blueCell.setBorderWidth(0);
        blueCell.setPadding(10);
        header.addCell(blueCell);

        // Add title cell
        PdfPCell titleCell = new PdfPCell(new Phrase("Family Book Store"));
        titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        titleCell.setBorderWidth(0);
        titleCell.setPadding(6);
        header.addCell(titleCell);

        // Add green cell
        PdfPCell greenCell = new PdfPCell();
        greenCell.setBackgroundColor(new BaseColor(62, 164, 52));
        greenCell.setBorderWidth(0);
        greenCell.setFixedHeight(7);
        header.addCell(greenCell);

        document.add(header);

        // Create table with one column
        PdfPTable salesInfoTable = new PdfPTable(1);
        salesInfoTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        try (Connection con = DatabaseManager.getConnection()) {
            String sql = "SELECT c.name, u.full_name, sd.sales_id, sd.sales_date, sd.total_price "
                    + "FROM sales_detail sd "
                    + "JOIN user u ON sd.salesperson_id = u.user_id "
                    + "JOIN customer c ON sd.customer_id = c.customer_id "
                    + "WHERE sd.sales_id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, salesId);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        salesInfoTable.setSpacingBefore(20);
                        salesInfoTable.addCell(new Phrase("Sales ID     : " + rs.getString("sales_id")));
                        salesInfoTable.addCell(new Phrase("Date           : " + rs.getString("sales_date")));
                        salesInfoTable.addCell(new Phrase("\nBill To        : " + rs.getString("name")));
                        salesInfoTable.addCell(new Phrase("Bill From    : " + rs.getString("full_name")));
                        salesTotalPrice = rs.getDouble("total_price");
                        salesInfoTable.setSpacingAfter(20);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        document.add(salesInfoTable);

        // Add table header
        PdfPTable tb1 = new PdfPTable(4);
        // Add table headers with background color
        // Add table headers with background color
        PdfPCell nameCell = new PdfPCell(new Phrase("Name"));
        PdfPCell priceCell = new PdfPCell(new Phrase("Quantity"));
        PdfPCell quantityCell = new PdfPCell(new Phrase("Price per Unit(RM)"));
        PdfPCell subTotalPriceCell = new PdfPCell(new Phrase("Sub Total(RM)"));

        BaseColor backgroundColor = new BaseColor(255, 204, 51);
        nameCell.setBackgroundColor(backgroundColor);
        priceCell.setBackgroundColor(backgroundColor);
        quantityCell.setBackgroundColor(backgroundColor);
        subTotalPriceCell.setBackgroundColor(backgroundColor);

        tb1.addCell(nameCell);
        tb1.addCell(priceCell);
        tb1.addCell(quantityCell);
        tb1.addCell(subTotalPriceCell);

        // Retrieve data from the database
        try (Connection con = DatabaseManager.getConnection()) {
            String sql = "SELECT p.product_name, sb.quantity, sb.subtotal, p.unit_price, "
                    + "sd.sales_id, sd.sales_date, sd.total_price, "
                    + "c.customer_id, c.name " // Selecting columns from customer and sales_detail tables
                    + "FROM sales_book sb "
                    + "JOIN product p ON sb.product_id = p.product_id "
                    + "JOIN sales_detail sd ON sb.sales_id = sd.sales_id " // Join with sales_detail table
                    + "JOIN customer c ON sd.customer_id = c.customer_id " // Join with customer table
                    + "WHERE sb.sales_id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, salesId);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        tb1.addCell(rs.getString("product_name"));
                        tb1.addCell(rs.getString("quantity"));
                        tb1.addCell(rs.getString("unit_price"));
                        tb1.addCell(rs.getString("subtotal"));
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        document.add(tb1);

        // Create table with one column and no border for total price
        PdfPTable totalPriceTable = new PdfPTable(1);
        totalPriceTable.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        // Add total price as a cell in the table with no border
        PdfPCell totalCell = new PdfPCell(new Phrase("\n\nTotal Price : RM " + salesTotalPrice));
        totalCell.setBorder(PdfPCell.NO_BORDER);
        totalPriceTable.addCell(totalCell);

        // Add the table to the document
        document.add(totalPriceTable);
        document.close();

        // Open the generated PDF
        OpenPdf.OpenByPath(filePath);

    }

}
