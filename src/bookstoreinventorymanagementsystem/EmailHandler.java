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
 *
 * @author coco1
 */
public class EmailHandler {

    private static final String FROM_EMAIL = "bookstoreautomated@gmail.com";
    private static final String PASSWORD = "oynb kbnd totr ysnf";
    private String code;

    public EmailHandler() {
        code = null;
    }

    public String getCode() {
        return code;
    }

    private String generateCode() {
        Random rand = new Random();
        StringBuilder codeBuilder = new StringBuilder();

        for (int i = 0; i < 6; ++i) {
            codeBuilder.append(rand.nextInt(9));
        }

        return codeBuilder.toString();
    }

    public void sendRegistrationVerificationEmail(
            String toEmail
    ) throws MessagingException, UnsupportedEncodingException {
        final String registrationVerificationEmailSubject
                = "Family Bookstore Email Verification";

        code = generateCode();
        
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
                """.formatted(code);
        
        sendEmail(toEmail, registrationVerificationEmailSubject, 
                registrationVerificationEmailBody);
    }

    public void sendResetPasswordEmail(
            String toEmail
    ) throws MessagingException, UnsupportedEncodingException {
        final String passwordResetEmailSubject
                = "Family Bookstore Account Password Reset";

        code = generateCode();
        
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
                """.formatted(code);
        
        sendEmail(toEmail, passwordResetEmailSubject,
                passwordResetEmailBody);
    }

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
