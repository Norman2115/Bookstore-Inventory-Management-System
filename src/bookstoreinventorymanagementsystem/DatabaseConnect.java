/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

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
public final class DatabaseConnect {
    private Connection connection;
    public DatabaseConnect(){
        try {
            //Connect to database
            DatabaseManager.connect();
            connection = DatabaseManager.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private int rowNumber;
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
            for (int i = 0;i<rowNumber;i++){
                productData[i] = ProductData.getInstance();
            }
            //select data from database
            query = "SELECT * FROM " + tableName + " ORDER BY " + orderBy;
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //catch data
            int i = 0;
            while (resultSet.next()){
                productData[i].setAuthor(resultSet.getString("author"));
                productData[i].setBookTitle(resultSet.getString("product_name"));
                productData[i].setGenre(resultSet.getString("genre"));
                productData[i].setISBN(resultSet.getInt("isbn"));
                //productData[i].setImage(resultSet.getBlob(query));
                productData[i].setLanguage(resultSet.getString("language"));
                productData[i].setPromotion(resultSet.getDouble("promotion"));
                productData[i].setPublicationYear(resultSet.getInt("publication_year"));
                productData[i].setPurchasePrice(resultSet.getDouble("purchase_price"));
                productData[i].setStockQuantity(resultSet.getInt("stock_quantity"));
                productData[i].setSupplier(resultSet.getString("supplier"));
                productData[i].setUnitPrice(resultSet.getDouble("unit_price"));
                i++;
            }
            return productData;
        } catch (SQLException ex) {
            Logger.getLogger(ViewProduct.class.getName()).log(Level.SEVERE, null, ex);
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
            for (int i = 0;i<rowNumber;i++){
                productData[i] = ProductData.getInstance();
            }
            //select data from database
            query = "SELECT * FROM " + tableName + " WHERE " + condition + " ORDER BY " + orderBy;
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //catch data
            int i = 0;
            while (resultSet.next()){
                productData[i].setAuthor(resultSet.getString("author"));
                productData[i].setBookTitle(resultSet.getString("product_name"));
                productData[i].setGenre(resultSet.getString("genre"));
                productData[i].setISBN(resultSet.getInt("isbn"));
                //productData[i].setImage(resultSet.getBlob(query));
                productData[i].setLanguage(resultSet.getString("language"));
                productData[i].setPromotion(resultSet.getDouble("promotion"));
                productData[i].setPublicationYear(resultSet.getInt("publication_year"));
                productData[i].setPurchasePrice(resultSet.getDouble("purchase_price"));
                productData[i].setStockQuantity(resultSet.getInt("stock_quantity"));
                productData[i].setSupplier(resultSet.getString("supplier"));
                productData[i].setUnitPrice(resultSet.getDouble("unit_price"));
                i++;
            }
            return productData;
        } catch (SQLException ex) {
            Logger.getLogger(ViewProduct.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }
    
    public void closeConnection(){
        try {
            //close connection
            DatabaseManager.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
