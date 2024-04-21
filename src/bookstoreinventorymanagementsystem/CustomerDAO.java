package bookstoreinventorymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) class for managing customer data in the database.
 * This class provides methods to interact with the database for CRUD operations
 * related to customer data.
 *
 * @author Liew Wen Yen
 */
public class CustomerDAO {

    /**
     * Retrieves the next available customer ID from the database. Customer IDs
     * are generated using a prefix followed by an incrementing number. Throws
     * an SQLException if the generation fails.
     *
     * @return The next available customer ID.
     * @throws SQLException If an SQL exception occurs.
     */
    private static String setNextCustomerID() throws SQLException {
        try (Connection con = DatabaseManager.getConnection();) {
            String query = "SELECT current_customer_id FROM customer_id_counter";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return "C" + rs.getInt("current_customer_id");
            } else {
                throw new SQLException("Failed to generate customer ID");
            }
        }
    }

    /**
     * Retrieves all customers from the database.
     *
     * @return An ArrayList of CustomerData objects containing all customers.
     * @throws SQLException If an SQL exception occurs.
     */
    public static ArrayList<CustomerData> getAllCustomers() throws SQLException {
        ArrayList<CustomerData> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";
        CustomerData customer = new CustomerData();

        try (Connection con = DatabaseManager.getConnection(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                customer.setCustomerID(rs.getString("customer_id"));
                customer.setFullName(rs.getString("name"));
                customer.setMobileNumber(rs.getString("mobileNumber"));
                customer.setEmail(rs.getString("email"));
                customers.add(customer);
            }
        }

        return customers;
    }

    /**
     * Retrieves the names of all customers from the database.
     *
     * @return An ArrayList of Strings containing the names of all customers.
     * @throws SQLException If an SQL exception occurs.
     */
    public static ArrayList<String> getAllCustomersName() throws SQLException {
        ArrayList<String> customersName = new ArrayList<>();
        String query = "SELECT name FROM customer";

        try (Connection con = DatabaseManager.getConnection(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                customersName.add(rs.getString("name"));
            }
        }

        return customersName;
    }

    /**
     * Updates customer information in the database.
     *
     * @param customerData The CustomerData object containing updated
     * information.
     * @return True if the update was successful, false otherwise.
     * @throws SQLException If an SQL exception occurs.
     */
    public static boolean updateCustomer(CustomerData customerData) throws SQLException {
        try (Connection con = DatabaseManager.getConnection();) {
            String query = "UPDATE customer SET name = ?, mobileNumber = ?, email = ? WHERE customer_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, customerData.getFullName());
            ps.setString(2, customerData.getMobileNumber());
            ps.setString(3, customerData.getEmail());
            ps.setString(4, customerData.getCustomerID());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }

    /**
     * Retrieves customer information from the database based on the name.
     *
     * @param name The name of the customer to retrieve.
     * @return A CustomerData object containing the customer's information.
     * @throws SQLException If an SQL exception occurs.
     */
    public static CustomerData getCustomerByName(String name) throws SQLException {
        CustomerData customerData = null;
        String sql = "SELECT * FROM customer WHERE name = ?";
        try (Connection con = DatabaseManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, name);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    customerData = new CustomerData();
                    customerData.setCustomerID(rs.getString("customer_id"));
                    customerData.setFullName(rs.getString("name"));
                    customerData.setMobileNumber(rs.getString("mobileNumber"));
                    customerData.setEmail(rs.getString("email"));
                }
            }
        }
        return customerData;
    }

    /**
     * Deletes a customer from the database based on the customer ID.
     *
     * @param customerID The ID of the customer to delete.
     * @return True if the deletion was successful, false otherwise.
     * @throws SQLException If an SQL exception occurs.
     */
    public static boolean deleteCustomer(String customerID) throws SQLException {
        try (Connection con = DatabaseManager.getConnection(); PreparedStatement ps = con.prepareStatement("DELETE FROM customer WHERE customer_id = ?")) {
            ps.setString(1, customerID);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }

    /**
     * Saves customer data to the database.
     *
     * @param customerData The CustomerData object containing the customer's
     * information.
     * @throws SQLException If an SQL exception occurs.
     */
    public static void saveCustomerDataToDatabase(CustomerData customerData) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DatabaseManager.getConnection();
            con.setAutoCommit(false);

            String nextCustomerID = setNextCustomerID();

            if (nextCustomerID == null) {
                throw new NullPointerException("Customer ID cannot be null");
            }

            String query = "INSERT INTO customer (customer_id, name, mobileNumber, email) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nextCustomerID);
            ps.setString(2, customerData.getFullName());
            ps.setString(3, customerData.getMobileNumber());
            ps.setString(4, customerData.getEmail());
            ps.executeUpdate();

            String query2 = "UPDATE customer_id_counter SET current_customer_id = ?";
            ps = con.prepareStatement(query2);
            ps.setInt(1, Integer.parseInt(nextCustomerID.substring(1)) + 1);
            ps.executeUpdate();

            con.commit();
        } catch (SQLException ex) {
            if (con != null) {
                con.rollback();
            }
            throw ex;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.setAutoCommit(true);
                con.close();
            }
        }
    }
}
