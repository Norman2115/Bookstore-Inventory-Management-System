package bookstoreinventorymanagementsystem;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This class handles the functionality related to sending emails for various
 * purposes within the app, such as registration verification emails and
 * password reset emails, using Google Mail's SMTP server.
 *
 * @author Teo Chung Henn
 */
public class EmailHandler {

    /**
     * The sender's email address.
     */
    private static final String FROM_EMAIL = "bookstoreautomated@gmail.com";

    /**
     * The sender's email password.
     */
    private static final String PASSWORD = "oynb kbnd totr ysnf";

    /**
     * The generated verification code used to verify the authenticity of the
     * user requesting action (e.g, registration verification or password reset)
     */
    private String verificationCode;

    /**
     * Constructs an EmailHandler object with a null verification code.
     */
    public EmailHandler() {
        verificationCode = null;
    }

    /**
     * Retrieves the generated verification code.
     *
     * @return the verification code.
     */
    public String getVerificationCode() {
        return verificationCode;
    }

    /**
     * Generates a random verification code consisting of 6 digits.
     *
     * @return the generated verification code
     */
    private String generateVerificationCode() {
        Random rand = new Random();
        StringBuilder codeBuilder = new StringBuilder();

        for (int i = 0; i < 6; ++i) {
            codeBuilder.append(rand.nextInt(9));
        }

        return codeBuilder.toString();
    }

    /**
     * Sends a registration verification email. The email contains a
     * verification code that the recipient needs to use to verify their email
     * address to complete the sign up process.
     *
     * @param toEmail the recipient's email address to which the verification
     * email will be sent.
     * @throws MessagingException if an error occurs while sending the mail.
     * @throws UnsupportedEncodingException if the encoding is not supported.
     */
    public void sendRegistrationVerificationEmail(
            String toEmail
    ) throws MessagingException, UnsupportedEncodingException {
        if (toEmail == null) {
            throw new NullPointerException("Email cannot be null");
        }

        verificationCode = generateVerificationCode();

        final String registrationVerificationEmailSubject
                = "Family Bookstore Email Verification";

        final String registrationVerificationEmailBody
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
                """.formatted(verificationCode);

        sendEmail(toEmail, registrationVerificationEmailSubject,
                registrationVerificationEmailBody);
    }

    /**
     * Sends a password reset email to the specified email address. The email
     * contains a verification code that the user needs to use to verify their
     * identity before they can reset their password.
     *
     * @param toEmail the recipient's email address to which the password reset
     * email will be sent.
     * @throws MessagingException if an error occurs while sending the email.
     * @throws UnsupportedEncodingException if the encoding is not supported.
     */
    public void sendResetPasswordEmail(
            String toEmail
    ) throws MessagingException, UnsupportedEncodingException {
        if (toEmail == null) {
            throw new NullPointerException("Email cannot be null");
        }

        verificationCode = generateVerificationCode();

        final String passwordResetEmailSubject
                = "Family Bookstore Account Password Reset";

        final String passwordResetEmailBody
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
                """.formatted(verificationCode);

        sendEmail(toEmail, passwordResetEmailSubject, passwordResetEmailBody);
    }

    /**
     * Sends an email to the specified email address with the provided subject
     * and body content. This method sets up the SMTP server and configures
     * SSL/TLS encryption for secure communication. The email is sent using the
     * Google Mail's SMTP server.
     *
     * @param toEmail the recipient's email address to which the email will be
     * sent.
     * @param subject the subject of the email.
     * @param body the body content of the email, which should be formatted in
     * HTML.
     * @throws MessagingException if an error occurs while sending the email.
     * @throws UnsupportedEncodingException if the encoding is not supported.
     */
    private void sendEmail(
            String toEmail,
            String subject,
            String body
    ) throws MessagingException, UnsupportedEncodingException {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);

        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress(FROM_EMAIL, "Family Bookstore"));
        msg.setReplyTo(InternetAddress.parse("noreply@example.com", false));

        msg.setSubject(subject, "UTF-8");
        msg.setContent(body, "text/HTML");

        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(toEmail, false));

        Transport.send(msg);
    }
}
