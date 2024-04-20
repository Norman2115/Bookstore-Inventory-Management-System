package bookstoreinventorymanagementsystem;

/**
 *
 * @author Liew Wen Yen
 */
public final class CustomerData {

    private String customerID;
    private String fullName;
    private String mobileNumber;
    private String email;

    public CustomerData() {
        setCustomerID(null);
        setFullName(null);
        setMobileNumber(null);
        setEmail(null);
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
