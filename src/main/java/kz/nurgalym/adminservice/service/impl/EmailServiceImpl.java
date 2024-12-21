package kz.nurgalym.adminservice.service.impl;

import kz.nurgalym.adminservice.service.EmailService;
import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendMessage() {
        // Sender's email and password
        final String senderEmail = "dauren.buribekov@gmail.com";
        final String senderPassword = "zgjr lgip crfw bcgk"; // Use App Passwords for Gmail accounts with 2FA

        // Receiver's email
        String recipientEmail = "mikon.2000@bk.ru";

        // SMTP server configuration
        String host = "smtp.gmail.com";

        // Set properties for the mail session
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        // Create a session with an authenticator
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Test Email");
            message.setText("Hello, this is a test email sent from Java!");

            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
