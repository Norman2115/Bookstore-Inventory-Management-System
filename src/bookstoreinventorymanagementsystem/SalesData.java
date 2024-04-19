/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Liew Wen Yen
 */
public class SalesData {

    private String salesID;
    private String customerID;
    private String orderDate;
    private double totalPrice;
    private int currentID;

    public SalesData() {
        this.salesID = null;
        this.orderDate = null;
        this.totalPrice = 0.0;

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

    private void setNextSalesID() throws SQLException {

        try (Connection con = DatabaseManager.getConnection();) {
            String query = "SELECT current_sales_id FROM sales_id_counter";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                currentID = rs.getInt("current_sales_id");
                String formattedID = "S" + String.format("%04d", currentID + 1);
                setSalesID(formattedID);

                UpdateSalesID();
            }
        }
    }

    private void UpdateSalesID() throws SQLException {
        try (Connection con = DatabaseManager.getConnection();) {
            String query = "SELECT current_customer_id FROM customer_id_counter";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

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
            PreparedStatement ps = con.prepareStatement("INSERT INTO sales_detail(sales_id, customer_id,sales_date,total_paid) VALUES(?,?,?,?)");
            ps.setString(1, getCurrentSalesID());
            ps.setString(2, getCustomerID());
            ps.setString(3, getOrderDate());
            ps.setDouble(4, getTotalPrice());
            ps.executeUpdate();
            //setNextSalesID();
        }

    }
}
