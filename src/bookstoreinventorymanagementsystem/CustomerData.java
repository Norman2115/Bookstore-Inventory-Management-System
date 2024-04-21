package bookstoreinventorymanagementsystem;

/**
 * The class represents customer data in the system. It encapsulates information
 * such as customer ID, full name, mobile number, and email.
 *
 * @author Liew Wen Yen
 */
public final class CustomerData {

    private String customerID;
    private String fullName;
    private String mobileNumber;
    private String email;

    /**
     * Constructs a new CustomerData object with default values.
     */
    public CustomerData() {
        setCustomerID(null);
        setFullName(null);
        setMobileNumber(null);
        setEmail(null);
    }

    /**
     * Retrieves the customer ID.
     *
     * @return the customer ID.
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Sets the customer ID.
     *
     * @param customerID the customer ID to set.
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * Retrieves the full name of the customer.
     *
     * @return the full name of the customer.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the customer.
     *
     * @param fullName the full name to set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Retrieves the mobile number of the customer.
     *
     * @return the mobile number of the customer.
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Sets the mobile number of the customer.
     *
     * @param mobileNumber the mobile number to set.
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * Retrieves the email address of the customer.
     *
     * @return the email address of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the customer.
     *
     * @param email the email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
