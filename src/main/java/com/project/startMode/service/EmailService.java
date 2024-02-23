package com.project.startMode.service;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.project.startMode.model.EmailDetails;

import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration configuration;

    private String sender = "${spring.mail.username}";

    public String sendFreeMark(EmailDetails emailDetails, Map<String, Object> model) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            // set mediaType
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            Template template = configuration.getTemplate("emailTemplate.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setFrom(sender, "Doctor");
            mimeMessageHelper.setSubject("Digital Prescription");

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            System.out.println("Exception occurred :" + e);
        }
        return "Message sent successfully";
    }

    public String acceptMail(String id) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(id);
        mailMessage
                .setText(
                        "Your appointment has been accepted" + "\nMeeting Link : https://meet.google.com/ikz-fvxu-njf");
        mailMessage.setSubject("Appointment Confirmation");

        mailSender.send(mailMessage);
        return "Mail sent successfully";
    }

}

// public interface EmailService {
// String sendEmail(EmailDetails emailDetails);

// String sendEmailWithAttachment(EmailDetails emailDetailsAttached);
// }
