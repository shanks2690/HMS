package org.hms.mailingservice.controller;


import lombok.extern.log4j.Log4j2;
import org.hms.mailingservice.entity.MailBody;
import org.hms.mailingservice.entity.SimpleMail;
import org.hms.mailingservice.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")

@Log4j2
public class MailController {
@Autowired
MailSenderService mailSenderService;

    @PostMapping("att")
    public ResponseEntity<?> sendMailAtt(@RequestBody MailBody mailBody) {
        try {
            mailSenderService.sendMailAtt(mailBody);
            log.info(mailBody);
            return ResponseEntity.ok(mailBody);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>("Error Sending the mail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("normal")
    public ResponseEntity<?> sendMail(@RequestBody SimpleMail simpleMail) {
        try {
            log.info(simpleMail);
            mailSenderService.sendMail(simpleMail);
            return ResponseEntity.ok(simpleMail);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>("Error Sending the mail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
