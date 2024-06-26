/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author My Lap
 */
public class EmailUtils {

    private static final String EMAIL_USERNAME = "dangphhe172554@fpt.edu.vn";
    private static final String EMAIL_PASSWORD = "eqla ccgx tfgm lmuk";

    public static void sendEmail(String recipientEmail, String subject, String body) {
        // Set up mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(body);

            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully to " + recipientEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Failed to send the email to " + recipientEmail);
        }

    }
    // Define the characters to choose from (64 unique characters)
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

    // Length of the OTP code
    private static final int OTP_LENGTH = 8;

    public static String generateOTP() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder(OTP_LENGTH);

        for (int i = 0; i < OTP_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            otp.append(randomChar);
        }

        return otp.toString();
    }
}
