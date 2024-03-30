package bookstoreinventorymanagementsystem;

/**
 *
 * @author Norman
 */
public class ValidationHandler {

    public static ValidationResult isValidUsername(String username) {
        if (username.length() < 6 || username.length() > 16) {
            return new ValidationResult(false, "Username must be between "
                    + "6 and 16 characters long");
        }
        
        return new ValidationResult(true, null);
    }

    public static ValidationResult isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return new ValidationResult(false, "Password must be between "
                    + "8 and 16 characters long");
        }

        boolean hasDigit = false;
        boolean hasLetter = false;
        boolean hasSymbol = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (isSymbol(c)) {
                hasSymbol = true;
            }
        }

        if (!hasDigit || !hasLetter || !hasSymbol) {
            return new ValidationResult(false, "Password must contain "
                    + "at least one digit, one letter, and one symbol");
        }
        
        return new ValidationResult(true, null);
    }

    private static boolean isSymbol(char c) {
        return !Character.isLetterOrDigit(c);
    }
}
