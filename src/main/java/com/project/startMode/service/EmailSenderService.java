// package com.project.startMode.service;

// import java.io.File;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.io.FileSystemResource;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;

// import com.project.startMode.model.EmailDetails;

// import jakarta.mail.Multipart;
// import jakarta.mail.internet.MimeMessage;

// @Service
// public class EmailSenderService implements EmailService {

// @Autowired
// private JavaMailSender javaMailSender;

// private String sender = "${spring.mail.username}";

// public String sendEmail(EmailDetails emailDetails) {

// SimpleMailMessage mailMessage = new SimpleMailMessage();
// mailMessage.setFrom(sender);
// mailMessage.setSubject(emailDetails.getSubject());
// mailMessage.setTo(emailDetails.getRecipient());
// mailMessage.setText(emailDetails.getBody() + "\n\n Your meeting Id : " +
// emailDetails.getMeetLink());

// javaMailSender.send(mailMessage);
// return "mail sent successfully";
// }

// public String sendEmailWithAttachment(EmailDetails emailDetailsAttached) {

// MimeMessage mimeMessage = javaMailSender.createMimeMessage();
// MimeMessageHelper mimeMessageHelper;

// try {
// mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
// mimeMessageHelper.setFrom(sender);
// // mimeMessageHelper.setFrom(sender, "Saran");
// mimeMessageHelper.setTo(emailDetailsAttached.getRecipient());
// mimeMessageHelper.setText(emailDetailsAttached.getBody());
// mimeMessageHelper.setSubject(emailDetailsAttached.getSubject());

// // if(!emailDetailsAttached.getAttachment().isEmpty()){
// // String fileName =
// // }

// FileSystemResource file = new FileSystemResource(new
// File(emailDetailsAttached.getAttachment()));
// mimeMessageHelper.addAttachment(file.getFilename(), file);
// mimeMessage.setHeader(sender, sender);
// javaMailSender.send(mimeMessage);
// return "Mail sent successfully";

// } catch (Exception e) {
// return e.getMessage();
// }
// }
// }
