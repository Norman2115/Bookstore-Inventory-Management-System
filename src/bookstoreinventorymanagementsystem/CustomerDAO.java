package bookstoreinventorymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Liew Wen Yen
 */
public class CustomerDAO {

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

    public static void saveCustomerDataToDatabase(CustomerData customerData) throws SQLException {
        if (customerData.getFullName() == null) {
            throw new NullPointerException("Full name cannot be null");
        }

        if (customerData.getMobileNumber() == null) {
            throw new NullPointerException("Mobile number cannot be null");
        }

        if (customerData.getEmail() == null) {
            throw new NullPointerException("Email cannot be null");
        }
        
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
