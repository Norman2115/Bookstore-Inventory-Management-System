package bookstoreinventorymanagementsystem;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                "user@12345@?");
    }

    /**
     * Gets the connection to the database.
     *
     * @return the database connection
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bookstore_inventory",
                    "root",
                    "user@12345@?"
            );
        }
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

    public static void registerShutdownHook() throws SQLException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }));
    }
}
