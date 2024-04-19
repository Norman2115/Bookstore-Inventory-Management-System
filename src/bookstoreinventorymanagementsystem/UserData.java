package bookstoreinventorymanagementsystem;

/**
 *
 * @author Norman
 */
public final class UserData {

    private String userID;
    private String fullName;
    private String username;
    private String email;
    private String password;
    private UserRole role;
    private byte[] profilePicture;

    private boolean isUsingUsernameForRecover;

    public UserData() {
        setUserID(null);
        setFullName(null);
        setUsername(null);
        setEmail(null);
        setPassword(null);
        setRole(null);
        setProfilePicture(null);
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
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

    public boolean isUsingUsernameForRecover() {
        return isUsingUsernameForRecover;
    }

    public void setUsingUsernameForRecover(boolean isUsingUsernameForRecover) {
        this.isUsingUsernameForRecover = isUsingUsernameForRecover;
    }
}
