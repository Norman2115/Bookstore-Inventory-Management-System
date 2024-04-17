/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public final class ReadProductData {
    private Connection connection;
    private int rowNumber;
    public ReadProductData(){
        try {
            //Connect to database
            connection = DatabaseManager.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ReadProductData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ProductData[] readData(String tableName,String orderBy){
        try {
            //get select coloumn number
            String query = "SELECT COUNT(*) FROM "+tableName;
            System.out.println(query);
            Statement countRow = connection.createStatement();
            ResultSet resultCount = countRow.executeQuery(query);
            resultCount.next();
            rowNumber = resultCount.getInt(1);
            ProductData[] productData = new ProductData[rowNumber];
            //initialized
            for (int i = 0;i<rowNumber;i++){
                productData[i] = new ProductData();
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
                productData[i].setISBN(resultSet.getInt("isbn"));
                productData[i].setStockQuantity(resultSet.getInt("stock_quantity"));
                productData[i].setUnitPrice(resultSet.getDouble("unit_price"));
                productData[i].setDiscount(resultSet.getDouble("discount"));
                try {
                    byte[] image = ImageUtils.convertBlobToByteArray(resultSet.getBlob("picture"));
                    productData[i].setImage(image);
                } catch (IOException ex) {
                    Logger.getLogger(ReadProductData.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            return productData;
        } catch (SQLException ex) {
            Logger.getLogger(ReadProductData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ProductData[] readData(String tableName,String condition,String orderBy){
        try {
            //get select coloumn number
            String query = "SELECT COUNT(*) FROM "+tableName+ " WHERE " + condition;
            System.out.println(query);
            Statement countRow = connection.createStatement();
            ResultSet resultCount = countRow.executeQuery(query);
            resultCount.next();
            rowNumber = resultCount.getInt(1);
            ProductData[] productData = new ProductData[rowNumber];
            //initialized
            for (int i = 0;i<rowNumber;i++){
                productData[i] = new ProductData();
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
                productData[i].setISBN(resultSet.getInt("isbn"));
                productData[i].setStockQuantity(resultSet.getInt("stock_quantity"));
                productData[i].setUnitPrice(resultSet.getDouble("unit_price"));
                productData[i].setDiscount(resultSet.getDouble("discount"));
                try {
                    byte[] image = ImageUtils.convertBlobToByteArray(resultSet.getBlob("picture"));
                    productData[i].setImage(image);
                } catch (IOException ex) {
                    Logger.getLogger(ReadProductData.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            return productData;
        } catch (SQLException ex) {
            Logger.getLogger(ReadProductData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getLength(String tableName){
        try {
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
            Logger.getLogger(ReadProductData.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }
    
    public int getLength(String tableName,String condition){
        try {
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
            Logger.getLogger(ReadProductData.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }    
}
