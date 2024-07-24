/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
/**
 *
 * @author yali_il
 */



public class EmailSender {
  
  // length of the verification code
  public static final int CODE_LENGTH = 6; 
  
  // allowed characters for the verification code
  public static final String ALLOWED_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
  
  public static String generateVerificationCode() {
    // create a new Random object
    Random random = new Random();

    // create a StringBuilder to store the verification code
    StringBuilder code = new StringBuilder();

    // generate a random verification code
    for (int i = 0; i < CODE_LENGTH; i++) {
      code.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
    }

    return code.toString();
  }

  public static void sendVerificationCode(String email, String code) {
    // set up the email properties
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    String appPassword = "tesptbokcqryfwse";
    String OwnerEmail = "InventoryManagementSystemIB@gmail.com";
    // create a new session with the authenticated user's credentials
    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
      public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(OwnerEmail, appPassword);
      }
    });

    try {
      // create a new message
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(OwnerEmail));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
      message.setSubject("Email Verification");
      message.setText("Your verification code is: " + code);

      // send the message
      Transport.send(message);

     JOptionPane.showMessageDialog(null,"Verification code sent to " +email);
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }
}


