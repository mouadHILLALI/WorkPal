package configuration;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class EmailSender {

    public static void sendEmail(String recipient, String subject, String content) {
            final String username = "mauadtoto001@gmail.com";
            final String password = "bbjdvtdbjxuojmat"; // Your generated app password

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true"); // Enable TLS
            props.put("mail.smtp.host", "smtp.gmail.com"); // Use Gmail's SMTP server
            props.put("mail.smtp.port", "587"); // Use port 587 for TLS


            // Create a session with username and password
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                // Create a MIME message
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username)); // From
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient)); // To
                message.setSubject(subject); // Email subject
                message.setText(content); // Email content

                // Send the email
                Transport.send(message);
                System.out.println("Email sent successfully");

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }


}
