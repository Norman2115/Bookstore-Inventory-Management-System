package bookstoreinventorymanagementsystem;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.time.Duration;

/**
 * The class manages the connection to the database.
 *
 * @author Teo Chung Henn
 * @author Tay Xuan Ye
 * @author Liew Wen Yen
 */
public class DatabaseManager {

    private static final BasicDataSource dataSource;
    
    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bookstore_inventory");
        dataSource.setUsername("root");
        dataSource.setPassword("user@12345@?");

        // Maximum number of active connections
        dataSource.setMaxTotal(3);

        // Maximum of idle connections
        dataSource.setMaxIdle(1);

        // Maximum wait time of 5 seconds
        dataSource.setMaxWait(Duration.ofSeconds(5));
    }

    /**
     * Gets the connection from the connection pool
     *
     * @return the database connection
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // For debugging purpose
    public static int getNumberIdle() {
        return dataSource.getNumIdle();
    }

    // For debugging purpose
    public static int getNumberActive() {
        return dataSource.getNumActive();
    }

    /**
     * Closes the database connection.
     *
     * @param connection the database connection to close
     * @throws SQLException if a database access error occurs
     */
    public static void closeConnection(Connection connection)
            throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
