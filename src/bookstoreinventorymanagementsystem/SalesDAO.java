package bookstoreinventorymanagementsystem;

import bookstoreinventorymanagementsystem.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author coco1
 */
public class SalesDAO {

    public static String setNextSalesID() throws SQLException {
        try (Connection con = DatabaseManager.getConnection()) {
            String query = "SELECT current_sales_id FROM sales_id_counter";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return "S" + rs.getInt("current_sales_id");
            } else {
                throw new SQLException("No current sales ID found in the database");
            }
        }
    }

    public static ArrayList<String[]> getSalesDataForCustomerAndSalesperson(
            String selectedCustomerID,
            String selectedSalespersonID
    ) throws SQLException {
        ArrayList<String[]> salesData = new ArrayList<>();
        String query = "SELECT sales_id, sales_date, total_price FROM sales_detail WHERE customer_id = ? AND salesperson_id = ?";

        try (Connection con = DatabaseManager.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, selectedCustomerID);
            pst.setString(2, selectedSalespersonID);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String salesID = rs.getString("sales_id");
                    String salesDate = rs.getString("sales_date");
                    double totalPrice = rs.getDouble("total_price");

                    salesData.add(new String[]{salesID, salesDate, String.valueOf(totalPrice)});
                }
            }
        }
        return salesData;
    }

    public static ArrayList<String> getCustomerIDs() throws SQLException {
        ArrayList<String> customerIDs = new ArrayList<>();
        String query = "SELECT DISTINCT customer_id FROM sales_detail";
        try (Connection con = DatabaseManager.getConnection(); PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                customerIDs.add(rs.getString("customer_id"));
            }
        }
        return customerIDs;
    }

    public static void saveSalesData(SalesData salesData, JTable cartTable) throws SQLException {
        DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
        Connection con = null;
        PreparedStatement statement = null;

        try {
            con = DatabaseManager.getConnection();
            con.setAutoCommit(false);

            String nextSalesID = setNextSalesID();

            String salesQuery = "INSERT INTO sales_detail(sales_id, salesperson_id, customer_id,sales_date,total_price) VALUES(?, ?, ?, ?, ?)";
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            salesData.setOrderDate(myFormat.format(cal.getTime()));
            statement = con.prepareStatement(salesQuery);
            statement.setString(1, nextSalesID);
            statement.setString(2, salesData.getSalespersonID());
            statement.setString(3, salesData.getCustomerID());
            statement.setString(4, salesData.getOrderDate());
            statement.setDouble(5, salesData.getTotalPrice());
            statement.executeUpdate();

            // Insert sales book records
            String bookQuery = "INSERT INTO sales_book(sales_id, book_id, quantity, subtotal) VALUES (?, ?, ?, ?)";
            statement = con.prepareStatement(bookQuery);
            for (int i = 0; i < dtm.getRowCount(); i++) {
                String bookID = dtm.getValueAt(i, 0).toString();
                int quantity = Integer.parseInt(dtm.getValueAt(i, 2).toString());
                double subtotal = Double.parseDouble(dtm.getValueAt(i, 3).toString());

                statement.setString(1, salesData.getCurrentSalesID());
                statement.setString(2, bookID);
                statement.setInt(3, quantity);
                statement.setDouble(4, subtotal);

                statement.executeUpdate();
            }

            String IDQuery = "UPDATE sales_id_counter SET current_sales_id = ?";
            statement = con.prepareStatement(IDQuery);
            statement.setInt(1, Integer.parseInt(nextSalesID.substring(1)) + 1);
            statement.executeUpdate();

            con.commit();
        } catch (SQLException ex) {
            if (con != null) {
                con.rollback();
            }
            throw ex;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.setAutoCommit(true);
                con.close();
            }
        }
    }
}
