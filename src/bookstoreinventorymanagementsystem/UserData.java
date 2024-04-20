package bookstoreinventorymanagementsystem;

/**
 * The class represents user data within the system. It encapsulates various
 * properties of a user, such as userID, username, email, password, role, and
 * profile picture.
 *
 * @author Teo Chung Henn
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

    /**
     * Constructs a new UserData object with default values. All properties are
     * initialized to null and false values.
     */
    public UserData() {
        setUserID(null);
        setFullName(null);
        setUsername(null);
        setEmail(null);
        setPassword(null);
        setRole(null);
        setProfilePicture(null);
        setUsingUsernameForRecover(false);
    }

    /**
     * Sets the user ID.
     *
     * @param userID the user ID to set.
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Retrieves the ID of the user.
     *
     * @return the ID of the user, or null if not set.
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the full name of the user.
     *
     * @param fullName the full name to set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Retrieves the full name of the user.
     *
     * @return the full name of the user, or null if not set.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the username of the user
     *
     * @return the username of the user, or null if not set.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email the email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return the email address of the user, or null if not set.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the password of the the user.
     *
     * @param password the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return the password of the user, or null if not set.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the role of the user in the form of a value from the UserRole
     * enumeration.
     *
     * @param role the role to set.
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Retrieves the role of the user.
     *
     * @return the role of the user, or null if not set.
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Sets the profile picture of the user in the form of byte array.
     *
     * @param profilePicture the profile picture to set.
     */
    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     * Retrieves the profile picture of the user in the form of byte array.
     *
     * @return the profile picture of the user, or null if not set.
     */
    public byte[] getProfilePicture() {
        return profilePicture;
    }

    /**
     * Sets whether the username is being used for account recovery.
     *
     * @param isUsingUsernameForRecover true if username is being used for
     * recovery, false otherwise.
     */
    public void setUsingUsernameForRecover(boolean isUsingUsernameForRecover) {
        this.isUsingUsernameForRecover = isUsingUsernameForRecover;
    }

    /**
     * Determine whether the username is being used for account recovery. If
     * username is being used for recovery, the value is set to true. If email
     * is used instead, the value is set to false.
     *
     * @return true if the username is being used for account recovery, false
     * otherwise.
     */
    public boolean isUsingUsernameForRecover() {
        return isUsingUsernameForRecover;
    }
}
