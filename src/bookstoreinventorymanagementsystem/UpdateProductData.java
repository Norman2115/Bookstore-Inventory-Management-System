/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public final class UpdateProductData {
    private Connection connection;
    public UpdateProductData(){
        try {
            //Connect to database
            connection = DatabaseManager.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ReadProductData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateData(ProductData productData) throws SQLException{
        connection = DatabaseManager.getConnection();
        String query = "UPDATE product "
                + "SET book_title = ?, genre = ?, language = ?, author = ?, publisher = ?, publication_year = ?, stock_quantity = ?, unit_price = ?, discount = ?, image = ? "
                + "WHERE isbn = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setObject(1, productData.getBookTitle());
        statement.setObject(2, productData.getGenre());
        statement.setObject(3, productData.getLanguage());
        statement.setObject(4, productData.getAuthor());
        statement.setObject(5, productData.getPublisher());
        statement.setObject(6, productData.getPublicatioYear());
        statement.setObject(7, productData.getStockQuantity());
        statement.setObject(8, productData.getUnitPrice());
        statement.setObject(9, productData.getDiscount());
        statement.setObject(10, productData.getImage());
        statement.setObject(11, productData.getISBN());
        System.out.println(query);
        statement.executeUpdate();
        
        
        if (connection != null) {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReadProductData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
