/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author User
 */
public class BookDAO {
    public BookDAO(){
        
    }
    
    public void deleteData(String deleteRowName,Object deleteRow[]){
        try (Connection connection = DatabaseManager.getConnection()){
            for(int i = 0;i<deleteRow.length;i++){
                String query = "DELETE FROM "+"product"+" WHERE "+deleteRowName+" = \'"+deleteRow[i]+"\'";
                System.out.println(query);
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateData(BookData productData){
        try (Connection connection = DatabaseManager.getConnection()){
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
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void restockUpdate(BookData productData){
        try (Connection connection = DatabaseManager.getConnection()){
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
    
    public BookData[] readData(String tableName,String orderBy){
        try (Connection connection = DatabaseManager.getConnection()){
            int rowNumber;
            //get select coloumn number
            String query = "SELECT COUNT(*) FROM "+tableName;
            System.out.println(query);
            rowNumber = getLength(tableName);
            BookData[] productData = new BookData[rowNumber];
            //initialized
            for (int i = 0;i<rowNumber;i++){
                productData[i] = new BookData();
            }//select data from database
            query = "SELECT * FROM " + tableName + " ORDER BY " + orderBy;
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //catch data
            int i = 0;
            while (resultSet.next()){
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
    
    public BookData[] readData(String tableName,String condition,String orderBy){
        try (Connection connection = DatabaseManager.getConnection()){
            int rowNumber;
            //get select coloumn number
            String query = "SELECT COUNT(*) FROM "+tableName+ " WHERE " + condition;
            System.out.println(query);
            rowNumber = getLength(tableName,condition);
            BookData[] productData = new BookData[rowNumber];
            //initialized
            for (int i = 0;i<rowNumber;i++){
                productData[i] = new BookData();
            }
            //select data from database
            query = "SELECT * FROM " + tableName + " WHERE " + condition + " ORDER BY " + orderBy;
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //catch data
            int i = 0;
            while (resultSet.next()){
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
    
    public int getLength(String tableName){
        try (Connection connection = DatabaseManager.getConnection()){
            int rowNumber;
            //get select coloumn number
            String query = "SELECT COUNT(*) FROM "+tableName;
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
    
    public int getLength(String tableName,String condition){
        try (Connection connection = DatabaseManager.getConnection()){
            int rowNumber;
            //get select coloumn number
            String query = "SELECT COUNT(*) FROM "+tableName+ " WHERE " + condition;
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
}
