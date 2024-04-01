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
        this.code = null;
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
    
    public void sendEmail(
            String toEmail,
            EmailType emailType
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

        String subject = null;
        String body = null;

        switch (emailType) {
            case EMAIL_VERIFICATION -> {
                subject = EmailTemplates.EMAIL_VERIFICATION_SUBJECT;
                code = generateCode();
                body = EmailTemplates.EMAIL_VERIFICATION_BODY.formatted(code);
            }
            case RESET_PASSWORD -> {
                subject = EmailTemplates.RESET_PASSWORD_SUBJECT;
                code = generateCode();
                body = EmailTemplates.RESET_PASSWORD_BODY.formatted(code);
            }
        }

        if (subject == null || body == null) {
            throw new IllegalArgumentException("Attemped to send email without subject and body");
        }

        msg.setSubject(subject, "UTF-8");
        msg.setContent(body, "text/HTML");

        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(toEmail, false));

        Transport.send(msg);
    }
}
