package org.hms.mailingservice.service;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.log4j.Log4j2;
import org.hms.mailingservice.entity.FileName;
import org.hms.mailingservice.entity.MailBody;
import org.hms.mailingservice.entity.SimpleMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Log4j2
@Service
public class MailSenderService {
@Autowired
 private JavaMailSender javaMailSender;
    public void sendMailAtt(MailBody mailBody) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setFrom("shashankk.mtoc@gmail.com");
            mimeMessageHelper.setTo(mailBody.getTo());
            mimeMessageHelper.setSubject(mailBody.getSub());
            mimeMessageHelper.setText(mailBody.getBody());
            for (FileName fileName : mailBody.getFiles()) {
                FileSystemResource fileSystemResource = new FileSystemResource(new File(fileName.getFilename()));
                mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
                log.info(fileName.getFilename());
            }

            log.info("mail sent to :" + mailBody.getFrom());
            javaMailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMail(SimpleMail simpleMail) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
           mailMessage.setFrom("shashankk.mtoc@gmail.com");
            mailMessage.setTo(simpleMail.getTo());
            mailMessage.setSubject(simpleMail.getSub());
            mailMessage.setText(simpleMail.getBody());
            log.info("Sending Mail");
            javaMailSender.send(mailMessage);
            log.info("mail sent to :" + simpleMail.getFrom());
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
