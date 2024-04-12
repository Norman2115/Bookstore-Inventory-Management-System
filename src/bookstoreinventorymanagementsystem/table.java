/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class table {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = DatabaseManager.getConnection();
            st = con.createStatement();
            st.executeUpdate("create table customer (customer_pk int AUTO_INCREMENT primary key, name varchar(200), mobileNumber varchar(50),email varchar(200)");
            JOptionPane.showMessageDialog(null, "Table Created Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
