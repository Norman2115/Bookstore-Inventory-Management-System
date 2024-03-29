package bookstoreinventorymanagementsystem;

/**
 *
 * @author Norman
 */
public class UserData {
    private static UserData instance;
    
    private String userID;
    private String username;
    private String password;
    private UserRole role;
    private byte[] profilePicture;

    public UserData() {
        setUserID(null);
        setUsername(null);
        setPassword(null);
        setRole(null);
        setProfilePicture(null);
    }
    
    public static UserData getInstance() {
        if (instance == null) {
            instance = new UserData();
        }
        return instance;
    }

    public void setUserID(String userID) {
        // Todo: Set prefix + id
        // Create a new table in mySQL for storing counter
        // Like the approach we used to do in C++ to generate id
        // Admin prefix (A), Salesperson prefix (S)
        this.userID = userID;
    }
    
    public String getUserID() {
        return userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
    
    public UserRole getRole() {
        return role;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
    
    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void reset() {
        setUserID(null);
        setUsername(null);
        setPassword(null);
        setRole(null);
        setProfilePicture(null);
    }
}