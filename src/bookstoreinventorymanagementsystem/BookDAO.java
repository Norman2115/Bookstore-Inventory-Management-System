package bookstoreinventorymanagementsystem;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Tay Xuan Ye
 */
public class BookDAO {

    /**
     * Retrieves the next available book ID from the database.
     *
     * @return the next available book ID.
     * @throws SQLException if a database access error occurs.
     */
    private static String getNextBookID() throws SQLException {
        try (Connection connection = DatabaseManager.getConnection();) {
            String query = "SELECT current_book_id FROM book_id_counter";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return "B" + resultSet.getInt("current_user_id");
            } else {
                throw new SQLException("No book ID found in the database");
            }
        }
    }

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
     * @param originalISBN the original ISBN of the book to be updated.
     * @throws SQLException if a database access error occurs or the SQL
     * execution fails.
     * @throws NullPointerException if any of the mandatory fields in the
     * provided BookData object are null.
     */
    public static void updateBookData(BookData bookData, String originalISBN) throws SQLException {
        Objects.requireNonNull(bookData.getBookTitle(), "Title cannot be null");
        Objects.requireNonNull(bookData.getISBN(), "ISBN cannot be null");
        Objects.requireNonNull(bookData.getGenre(), "Genre cannot be null");
        Objects.requireNonNull(bookData.getLanguage(), "Language cannot be null");
        Objects.requireNonNull(bookData.getAuthor(), "Author cannot be null");
        Objects.requireNonNull(bookData.getPublisher(), "Publisher cannot be null");

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE product "
                    + "SET book_title = ?, "
                    + "isbn = ?, "
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

            statement.setString(1, bookData.getBookTitle());
            statement.setString(2, bookData.getGenre());
            statement.setString(3, bookData.getISBN());
            statement.setString(4, bookData.getLanguage());
            statement.setString(5, bookData.getAuthor());
            statement.setString(6, bookData.getPublisher());
            statement.setInt(7, bookData.getPublicatioYear());
            statement.setInt(8, bookData.getStockQuantity());
            statement.setDouble(9, bookData.getUnitPrice());
            statement.setDouble(10, bookData.getDiscount());
            InputStream inputStream = new ByteArrayInputStream(bookData.getImage());
            statement.setBlob(11, inputStream);
            statement.setString(12, originalISBN);

            statement.executeUpdate();
        }
    }

    /**
     * Updates the stock quantity of a product in the database.
     *
     * @param bookData the BookData object containing the updated stock
     * quantity.
     * @throws SQLException if a database access error occurs or the SQL
     * execution fails.
     * @throws NullPointerException if the ISBN in the provided BookData object
     * is null.
     */
    public static void updateStockQuantity(BookData bookData) throws SQLException {
        Objects.requireNonNull(bookData.getISBN(), "ISBN cannot be null");

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE product "
                    + "SET stock_quantity = ? "
                    + "WHERE isbn = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, bookData.getStockQuantity());
            statement.setString(2, bookData.getISBN());

            statement.executeUpdate();
        }
    }

    /**
     * Reads book data from the specified database table and returns an array of
     * BookData objects.
     *
     * @param tableName the name of the database table from which to read book
     * data.
     * @param orderBy optional parameter specifying the column(s) by which to
     * order the results. if null or empty, the results will not be ordered.
     * @return an array of BookData objects containing the retrieved book data.
     * @throws SQLException if a database access error occurs.
     * @throws IOException if an I/O error occurs while converting blob data to
     * byte array.
     * @throws NullPointerException if tableName is null.
     */
    public static BookData[] readBookDataFromDatabase(String tableName, String orderBy) throws SQLException, IOException {
        Objects.requireNonNull(tableName, "Table name cannot be null");

        try (Connection connection = DatabaseManager.getConnection()) {
            int rowCount = getRowCount(tableName);
            BookData[] productData = new BookData[rowCount];

            for (int i = 0; i < rowCount; i++) {
                productData[i] = new BookData();
            }

            String query = "SELECT * FROM " + tableName;
            if (orderBy != null && !orderBy.isEmpty()) {
                query += " ORDER BY " + orderBy;
            }

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int i = 0;
            while (resultSet.next()) {
                productData[i].setBookTitle(resultSet.getString("book_title"));
                productData[i].setGenre(resultSet.getString("genre"));
                productData[i].setLanguage(resultSet.getString("language"));
                productData[i].setAuthor(resultSet.getString("author"));
                productData[i].setPublisher(resultSet.getString("publisher"));
                productData[i].setPublicationYear(resultSet.getInt("publication_year"));
                productData[i].setISBN(resultSet.getString("isbn"));
                productData[i].setStockQuantity(resultSet.getInt("stock_quantity"));
                productData[i].setUnitPrice(resultSet.getDouble("unit_price"));
                productData[i].setDiscount(resultSet.getDouble("discount"));
                byte[] imageByte = ImageUtils.convertBlobToByteArray(resultSet.getBlob("image"));
                productData[i].setImage(imageByte);
                i++;
            }

            return productData;
        }
    }

    /**
     * Reads book data from the specified database table based on the given
     * condition and returns an array of BookData objects.
     *
     * @param tableName the name of the database table from which to read book
     * data.
     * @param condition optional parameter specifying the condition to filter
     * the results. if null or empty, no condition will be applied.
     * @param orderBy optional parameter specifying the column(s) by which to
     * order the results. if null or empty, the results will not be ordered.
     * @return an array of BookData objects containing the retrieved book data.
     * @throws SQLException if a database access error occurs.
     * @throws IOException if an I/O error occurs while converting blob data to
     * byte array.
     * @throws NullPointerException if tableName is null.
     */
    public static BookData[] readBookDataFromDatabase(String tableName, String condition, String orderBy) throws SQLException, IOException {
        Objects.requireNonNull(tableName, "Table name cannot be null");

        try (Connection connection = DatabaseManager.getConnection()) {
            int rowCount = getRowCount(tableName, condition);
            BookData[] productData = new BookData[rowCount];

            for (int i = 0; i < rowCount; i++) {
                productData[i] = new BookData();
            }

            String query = "SELECT * FROM " + tableName;
            if (condition != null && !condition.isEmpty()) {
                query += " WHERE " + condition;
            }
            if (orderBy != null && !orderBy.isEmpty()) {
                query += " ORDER BY " + orderBy;
            }

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int i = 0;
            while (resultSet.next()) {
                productData[i].setBookTitle(resultSet.getString("book_title"));
                productData[i].setGenre(resultSet.getString("genre"));
                productData[i].setLanguage(resultSet.getString("language"));
                productData[i].setAuthor(resultSet.getString("author"));
                productData[i].setPublisher(resultSet.getString("publisher"));
                productData[i].setPublicationYear(resultSet.getInt("publication_year"));
                productData[i].setISBN(resultSet.getString("isbn"));
                productData[i].setStockQuantity(resultSet.getInt("stock_quantity"));
                productData[i].setUnitPrice(resultSet.getDouble("unit_price"));
                productData[i].setDiscount(resultSet.getDouble("discount"));
                byte[] image = ImageUtils.convertBlobToByteArray(resultSet.getBlob("image"));
                productData[i].setImage(image);
                i++;
            }
            return productData;
        }
    }

    /**
     * Saves book data to the database.
     *
     * @param bookData the book data to be saved.
     * @throws SQLException if a database access error occurs or SQL execution
     * fails.
     * @throws IOException if an I/O error occurs while reading the image data.
     * @throws NullPointerException if any of the required fields in the book
     * data is null.
     */
    public void saveBookDataToDatabase(BookData bookData) throws SQLException, IOException {
        Objects.requireNonNull(bookData.getBookTitle(), "Title cannot be null");
        Objects.requireNonNull(bookData.getISBN(), "ISBN cannot be null");
        Objects.requireNonNull(bookData.getGenre(), "Genre cannot be null");
        Objects.requireNonNull(bookData.getLanguage(), "Language cannot be null");
        Objects.requireNonNull(bookData.getAuthor(), "Author cannot be null");
        Objects.requireNonNull(bookData.getPublisher(), "Publisher cannot be null");

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseManager.getConnection();
            connection.setAutoCommit(false);

            String nextBookID = getNextBookID();

            String query = "INSERT INTO book VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);

            statement.setString(1, nextBookID);
            statement.setString(2, bookData.getBookTitle());
            statement.setString(3, bookData.getGenre());
            statement.setString(4, bookData.getLanguage());
            statement.setString(5, bookData.getAuthor());
            statement.setString(6, bookData.getPublisher());
            statement.setInt(7, bookData.getPublicatioYear());
            statement.setString(8, bookData.getISBN());
            statement.setInt(9, bookData.getStockQuantity());
            statement.setDouble(10, bookData.getUnitPrice());
            statement.setDouble(11, bookData.getDiscount());
            InputStream inputStream = new ByteArrayInputStream(bookData.getImage());
            statement.setBlob(12, inputStream);
            statement.executeUpdate();

            query = "UPDATE book_id_counter SET current_book_id = ?";
            statement = connection.prepareStatement(query);

            statement.setInt(1, Integer.parseInt(nextBookID.substring(1)) + 1);
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            if (connection != null) {
                connection.rollback();
            }
            throw ex;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }

    /**
     * Retrieves the number of rows in the specified database table.
     *
     * @param tableName the name of the database table for which to retrieve the
     * row count. Must not be null.
     * @return the number of rows in the specified database table.
     * @throws SQLException if a database access error occurs.
     * @throws NullPointerException if tableName is null.
     */
    public static int getRowCount(String tableName) throws SQLException {
        Objects.requireNonNull(tableName, "Table name cannot be null");

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT COUNT(*) FROM " + tableName;
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultCount = statement.executeQuery();
            resultCount.next();

            int rowNumber = resultCount.getInt(1);
            return rowNumber;
        }
    }

    /**
     * Retrieves the number of rows in the specified database table that satisfy
     * the given condition.
     *
     * @param tableName the name of the database table for which to retrieve the
     * row count. Must not be null.
     * @param condition optional parameter specifying the condition to apply to
     * the query for counting rows. If null or empty, no condition will be
     * applied.
     * @return the number of rows in the specified database table that satisfy
     * the given condition.
     * @throws SQLException if a database access error occurs.
     * @throws NullPointerException if tableName is null.
     */
    public static int getRowCount(String tableName, String condition) throws SQLException {
        Objects.requireNonNull(tableName, "Table name cannot be null");

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT COUNT(*) FROM " + tableName;
            if (condition != null && !condition.isEmpty()) {
                query += " WHERE " + condition;
            }
            PreparedStatement countRow = connection.prepareStatement(query);

            ResultSet resultCount = countRow.executeQuery();
            resultCount.next();

            int rowNumber = resultCount.getInt(1);
            return rowNumber;
        }
    }
}
