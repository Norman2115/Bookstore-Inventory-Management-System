/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public final class DeleteProductData {
    private Connection connection;
    public DeleteProductData(){
        try {
            //Connect to database
            connection = DatabaseManager.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteProductData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteData(String deleteRowName,Object deleteRow[]){
        try {
            connection = DatabaseManager.getConnection();
            for(int i = 0;i<deleteRow.length;i++){
                String query = "DELETE FROM "+"product"+" WHERE "+deleteRowName+" = \'"+deleteRow[i]+"\'";
                System.out.println(query);
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeleteProductData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DeleteProductData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
    }
}
