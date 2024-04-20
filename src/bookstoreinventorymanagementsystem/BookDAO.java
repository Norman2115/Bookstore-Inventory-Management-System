package bookstoreinventorymanagementsystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tay Xuan Ye
 */
public class BookDAO {

    /**
     * Deletes rows from the database table based on the specified column name
     * and values.
     *
     * @param columnName the name of the column to match for deletion.
     * @param values an array containing the values of the specified column to
     * match for deletion.
     * @throws SQLException if a database access error occurs or SQL execution
     * fails.
     */
    public static void deleteBookData(String columnName, Object values[]) throws SQLException {
        try (Connection connection = DatabaseManager.getConnection()) {
            for (Object value : values) {
                String query = "DELETE FROM product WHERE " + columnName + " = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setObject(1, value);
                statement.executeUpdate();
            }
        }
    }

    /**
     * Updates book data in the database.
     *
     * @param bookData the BookData object containing the updated information.
     * @throws SQLException if a database access error occurs or the SQL
     * execution fails.
     * @throws NullPointerException if any of the mandatory fields in the
     * provided BookData object are null.
     */
    public static void updateBookData(BookData bookData) throws SQLException {
        if (bookData.getBookTitle() == null) {
            throw new NullPointerException("Title cannot be null");
        }

        if (bookData.getGenre() == null) {
            throw new NullPointerException("Genre cannot be null");
        }

        if (bookData.getLanguage() == null) {
            throw new NullPointerException("Language cannot be null");
        }

        if (bookData.getAuthor() == null) {
            throw new NullPointerException("Author cannot be null");
        }
        
        if (bookData.getPublisher() == null) {
            throw new NullPointerException("Publisher cannot be null");
        }

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE product "
                    + "SET book_title = ?, "
                    + "genre = ?, "
                    + "language = ?, "
                    + "author = ?, "
                    + "publisher = ?, "
                    + "publication_year = ?, "
                    + "stock_quantity = ?, "
                    + "unit_price = ?, "
                    + "discount = ?, "
                    + "image = ? "
                    + "WHERE isbn = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, bookData.getBookTitle());
            statement.setObject(2, bookData.getGenre());
            statement.setObject(3, bookData.getLanguage());
            statement.setObject(4, bookData.getAuthor());
            statement.setObject(5, bookData.getPublisher());
            statement.setObject(6, bookData.getPublicatioYear());
            statement.setObject(7, bookData.getStockQuantity());
            statement.setObject(8, bookData.getUnitPrice());
            statement.setObject(9, bookData.getDiscount());
            statement.setObject(10, bookData.getImage());
            statement.setObject(11, bookData.getISBN());
            statement.executeUpdate();
        }
    }

    public static void restockUpdate(BookData productData) throws SQLException {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE product "
                    + "SET stock_quantity = ? "
                    + "WHERE isbn = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setObject(1, productData.getStockQuantity());
            statement.setObject(2, productData.getISBN());
            System.out.println(query);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BookData[] readData(String tableName, String orderBy) {
        try (Connection connection = DatabaseManager.getConnection()) {
            int rowNumber;
            //get select coloumn number

            rowNumber = getLength(tableName);
            BookData[] productData = new BookData[rowNumber];
            //initialized
            for (int i = 0; i < rowNumber; i++) {
                productData[i] = new BookData();
            }//select data from database
            String query = "SELECT * FROM " + tableName + " ORDER BY " + orderBy;
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //catch data
            int i = 0;
            while (resultSet.next()) {
                productData[i].setBookTitle(resultSet.getString("book_title"));
                productData[i].setGenre(resultSet.getString("genre"));
                productData[i].setLanguage(resultSet.getString("language"));
                productData[i].setAuthor(resultSet.getString("author"));
                productData[i].setPublisher(resultSet.getString("publisher"));
                productData[i].setPublicationYear(resultSet.getInt("publication_year"));
                productData[i].setISBN(resultSet.getLong("isbn"));
                productData[i].setStockQuantity(resultSet.getInt("stock_quantity"));
                productData[i].setUnitPrice(resultSet.getDouble("unit_price"));
                productData[i].setDiscount(resultSet.getDouble("discount"));

                try {
                    byte[] imageByte = ImageUtils.convertBlobToByteArray(resultSet.getBlob("image"));
                    productData[i].setImage(imageByte);
                } catch (IOException ex) {
                    Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            return productData;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static BookData[] readData(String tableName, String condition, String orderBy) {
        try (Connection connection = DatabaseManager.getConnection()) {
            int rowNumber;
            //get select coloumn number
            rowNumber = getLength(tableName, condition);
            BookData[] productData = new BookData[rowNumber];
            //initialized
            for (int i = 0; i < rowNumber; i++) {
                productData[i] = new BookData();
            }
            //select data from database
            String query = "SELECT * FROM " + tableName + " WHERE " + condition + " ORDER BY " + orderBy;
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //catch data
            int i = 0;
            while (resultSet.next()) {
                productData[i].setBookTitle(resultSet.getString("book_title"));
                productData[i].setGenre(resultSet.getString("genre"));
                productData[i].setLanguage(resultSet.getString("language"));
                productData[i].setAuthor(resultSet.getString("author"));
                productData[i].setPublisher(resultSet.getString("publisher"));
                productData[i].setPublicationYear(resultSet.getInt("publication_year"));
                productData[i].setISBN(resultSet.getLong("isbn"));
                productData[i].setStockQuantity(resultSet.getInt("stock_quantity"));
                productData[i].setUnitPrice(resultSet.getDouble("unit_price"));
                productData[i].setDiscount(resultSet.getDouble("discount"));
                try {
                    byte[] image = ImageUtils.convertBlobToByteArray(resultSet.getBlob("image"));
                    productData[i].setImage(image);
                } catch (IOException ex) {
                    Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            return productData;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int getLength(String tableName) {
        try (Connection connection = DatabaseManager.getConnection()) {
            int rowNumber;
            //get select coloumn number
            String query = "SELECT COUNT(*) FROM " + tableName;
            System.out.println(query);
            Statement countRow = connection.createStatement();
            ResultSet resultCount = countRow.executeQuery(query);
            resultCount.next();
            rowNumber = resultCount.getInt(1);
            //return length
            return rowNumber;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int getLength(String tableName, String condition) {
        try (Connection connection = DatabaseManager.getConnection()) {
            int rowNumber;
            //get select coloumn number
            String query = "SELECT COUNT(*) FROM " + tableName + " WHERE " + condition;
            System.out.println(query);
            Statement countRow = connection.createStatement();
            ResultSet resultCount = countRow.executeQuery(query);
            resultCount.next();
            rowNumber = resultCount.getInt(1);
            //return length
            return rowNumber;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static String getNextBookID() {
        try (Connection connection = DatabaseManager.getConnection();) {
            //get select coloumn number
            int rowNumber = getLength("product");
            if (rowNumber == 0) {
                return ("B1001");
            }
            String query = "SELECT * FROM product ORDER BY book_id LIMIT 1";
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            String result = resultSet.getString(1);
            int id = Integer.parseInt(result.substring(1));
            return ("B" + id++);
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
