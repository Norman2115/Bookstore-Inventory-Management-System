/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author Liew Wen Yen
 */
public final class CustomerData {

    private String customerID;
    private String fullName;
    private String mobileNumber;
    private String email;

    public CustomerData() {
        setCustomerID(null);
        setFullName(null);
        setMobileNumber(null);
        setEmail(null);
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     private void setNextCustomerID() throws SQLException {
        try (Connection con = DatabaseManager.getConnection();) {
            String query = "SELECT current_customer_id FROM customer_id_counter";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int currentID = rs.getInt("current_customer_id");
                String formattedID = "C" + String.format("%04d", currentID + 1);
                setCustomerID(formattedID);

                // Update the current ID in the database
                query = "UPDATE customer_id_counter SET current_customer_id = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, currentID + 1);
                ps.executeUpdate();
            }
        }
    }

    public void saveCustomerDataToDatabase() throws SQLException {
         try (Connection con = DatabaseManager.getConnection()) {
        String query = "INSERT INTO customer (customer_id, name, mobileNumber, email) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);

        if (getFullName() != null && getMobileNumber() != null && getEmail() != null) {
            setNextCustomerID();

            if (getCustomerID() != null) {
                ps.setString(1, getCustomerID());
                ps.setString(2, getFullName());
                ps.setString(3, getMobileNumber());
                ps.setString(4, getEmail());

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    UIUtils.displaySuccessMessage("Customer saved successfully with ID: " + getCustomerID());
                } else {
                    UIUtils.displayErrorMessage("Failed to save customer record.");
                }
            } else {
                UIUtils.displayErrorMessage("Failed to generate customer ID.");
            }
        } else {
            UIUtils.displayErrorMessage("Failed to save customer record: Required fields cannot be null.");
        }
    } catch (SQLException e) {
        UIUtils.displayErrorMessage("An error occurred while saving customer record: " + e.getMessage());
    }
    }
}
