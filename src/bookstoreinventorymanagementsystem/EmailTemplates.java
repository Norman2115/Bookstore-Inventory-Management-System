package bookstoreinventorymanagementsystem;

/**
 *
 * @author coco1
 */
public class EmailTemplates {
    public static final String EMAIL_VERIFICATION_SUBJECT 
            = "Family Bookstore Email Verification";

    public static final String EMAIL_VERIFICATION_BODY
            = """
              <html>
                  <head>
                  </head>
                  <body style="font-family: Arial, sans-serif;">
                      <p style="margin-bottom: 30px;">
                          Welcome to 
                          <span style="color: #3ea434">Family</span>
                          <span style="color: #008cd6">Bookstore</span>!
                          To complete your registration, please verify your
                          email address.
                      </p>
                      <p style="margin-bottom: 30px;">
                          Here is your verification code: <strong>%s</strong>
                      </p>
                      <p style="margin-bottom: 30px;">
                          Didn't sign up? Please ignore this email.
                      </p>
                      <p style="margin-bottom: 30px;">
                          Thank you for choosing 
                          <span style="color: #3ea434">Family</span>
                          <span style="color: #008cd6">Bookstore</span>!
                      </p>
                  </body>
              </html>
              """;

    public static final String RESET_PASSWORD_SUBJECT 
            = "Family Bookstore Account Password Reset";

    public static final String RESET_PASSWORD_BODY
            = """
              <html>
                  <head>
                  </head>
                  <body style="font-family: Arial, sans-serif;">
                      <p style="margin-bottom: 30px;">
                          Please use this code to reset the password for your
                          <span style="color: #3ea434">Family</span>
                          <span style="color: #008cd6">Bookstore</span>
                          Inventory Management System account.
                      </p>
                      <p style="margin-bottom: 30px;">
                          Here is your code: <strong>%s</strong>
                      </p>
                      <p style="margin-bottom: 30px;">
                          Didn't request this? Please ignore.
                      </p>
                      <p>Happy managing!</p>
                  </body>
              </html>
              """;
}
