/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Liew Wen Yen
 */
public class OpenPdf {

    public static void OpenById(String id) {
        try {
            if ((new File(InventoryUtils.billPath + id + ".pdf")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler " + InventoryUtils.billPath + "" + id + ".pdf");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
