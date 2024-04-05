package bookstoreinventorymanagementsystem;

/**
 * The class represents the result of a validation operation, indicating whether
 * the validation was successful and accompanied by an error message if failed.
 *
 * @author Teo Chung Henn
 */
public class ValidationResult {

    /**
     * A Boolean value indicating whether the validation was successful
     */
    private final boolean isValid;

    /**
     * The error message associated with the validation result, if any.
     */
    private final String errorMessage;

    /**
     * Constructs a ValidationResult object with the specified validity value
     * and error message.
     *
     * @param isValid a Boolean value indicating whether the validation was
     * successful.
     * @param errorMessage the error message associated with the validation
     * result, if any.
     */
    public ValidationResult(boolean isValid, String errorMessage) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
    }

    /**
     * Retrieves the validity value of the validation result.
     *
     * @return true if the validation was successful.
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Retrieves the error message associated with the validation result.
     *
     * @return the error message, or null if no error occurred.
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
