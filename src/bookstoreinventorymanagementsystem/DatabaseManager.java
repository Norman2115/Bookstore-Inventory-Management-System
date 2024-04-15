package bookstoreinventorymanagementsystem;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

/**
 * The class manages the connection to the database.
 *
 * @author Teo Chung Henn
 * @author Tay Xuan Ye
 * @author Liew Wen Yen
 */
public class DatabaseManager {

    private static final HikariDataSource dataSource;
    
    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/bookstore_inventory");
        config.setUsername("root");
        config.setPassword("wydosql");
        config.setMaximumPoolSize(3);
        config.setMinimumIdle(1);
        dataSource = new HikariDataSource(config);
    }

    /**
     * Gets the connection from the connection pool.
     *
     * @return the database connection.
     * @throws SQLException if a database access error occurs.
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
