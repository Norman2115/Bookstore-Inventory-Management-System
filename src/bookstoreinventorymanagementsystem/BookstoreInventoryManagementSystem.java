package bookstoreinventorymanagementsystem;

/**
 *
 * @author Norman
 */
public class BookstoreInventoryManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Alternate VM configuration for UI scaling:
        // Setting the "sun.java2d.uiScale" property to "1.0" ensures that the UI
        // components are displayed at their default scale, unaffected by system
        // DPI settings. This can help mitigate issues related to DPI scaling, such
        // as blurry or improperly sized UI elements, especially when running the
        // application on systems with non-standard DPI scaling settings.
        System.setProperty("sun.java2d.uiScale", "1.0");
        
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }

}
