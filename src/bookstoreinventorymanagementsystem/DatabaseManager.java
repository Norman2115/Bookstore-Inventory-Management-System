package bookstoreinventorymanagementsystem;

import java.sql.*;

/**
 * The class manages the connection to the database.
 * 
 * @author Teo Chung Henn
 * @author Tay Xuan Ye
 * @author Liew Wen Yen
 */
public class DatabaseManager {

    private static Connection connection;

    /**
     * Connects to the database.
     * 
     * @throws SQLException if a database access error occurs
     */
    public static void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookstore_inventory",
                "root",
                "admin");
    }

    /**
     * Gets the connection to the database.
     * 
     * @return the database connection
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * Closes the database connection.
     * 
     * @throws SQLException if a database access error occurs
     */
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
