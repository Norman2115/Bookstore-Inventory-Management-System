package bookstoreinventorymanagementsystem;

import java.io.IOException;
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

    public static final String EMAIL_VERIFICATION_SUBJECT
            = "Family Bookstore Email Verification";

    public static final String EMAIL_VERIFICATION_BODY;

    public static final String RESET_PASSWORD_SUBJECT
            = "Family Bookstore Account Password Reset";

    public static final String RESET_PASSWORD_BODY;
    
    static {
        String emailVerificationBody = null;
        String resetPasswordBody = null;
        
        try {
            emailVerificationBody = EmailTemplateLoader
                    .loadTemplate("verification_email_template.html");
            resetPasswordBody = EmailTemplateLoader
                    .loadTemplate("reset_password_email_template.html");
        } catch (IOException ex) {
            UIUtils.displayErrorMessage(ex.getMessage());
        }
        
        EMAIL_VERIFICATION_BODY = emailVerificationBody;
        RESET_PASSWORD_BODY = resetPasswordBody;
    }
    
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

    public void sendVerificationEmail(
            String toEmail
    ) throws MessagingException, UnsupportedEncodingException {
        code = generateCode();
        sendEmail(toEmail,EMAIL_VERIFICATION_SUBJECT, 
                EMAIL_VERIFICATION_BODY.formatted(code));
    }

    public void sendResetPasswordEmail(
            String toEmail
    ) throws MessagingException, UnsupportedEncodingException {
        code = generateCode();
        sendEmail(toEmail, RESET_PASSWORD_SUBJECT,
                RESET_PASSWORD_BODY.formatted(code));
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
                return new PasswordAuthentication(EmailConfig.getUsername(), EmailConfig.getPassword());
            }
        };

        Session session = Session.getDefaultInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);

        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress(EmailConfig.getUsername(), "Family Bookstore"));
        msg.setReplyTo(InternetAddress.parse("noreply@example.com", false));

        msg.setSubject(subject, "UTF-8");
        msg.setContent(body, "text/HTML");

        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(toEmail, false));

        Transport.send(msg);
    }
}
