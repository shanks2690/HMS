package com.shanks.appointmentservice.externalservices;

import com.shanks.appointmentservice.entity.MailBody;
import com.shanks.appointmentservice.entity.SimpleMail;
import org.apache.kafka.common.memory.SimpleMemoryPool;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="EMAIL-SERVICE")
public interface EmailFeign {
    @PostMapping("mail/normal")
     ResponseEntity<SimpleMail> sendMail( SimpleMail simpleMail);
}
