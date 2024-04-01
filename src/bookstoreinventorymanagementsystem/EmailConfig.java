/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author coco1
 */
public class EmailConfig {
    
    private static final String EMAIL_CONFIG_FILE = "email_auth.properties";
    private static final Properties PROPERTIES = new Properties();
    
    static {
        try {
            PROPERTIES.load(new FileInputStream(EMAIL_CONFIG_FILE));
        } catch (IOException ex) {
            UIUtils.displayErrorMessage(ex.getMessage());
        }
    }
    
    public static String getUsername() {
        return PROPERTIES.getProperty("email.username");
    }
    
    public static String getPassword() {
        return PROPERTIES.getProperty("email.password");
    }
}
