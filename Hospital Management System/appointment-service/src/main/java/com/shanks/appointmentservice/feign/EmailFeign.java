package com.shanks.appointmentservice.feign;

import com.shanks.appointmentservice.entity.SimpleMail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="MAILING-SERVICE")
public interface EmailFeign {
    @PostMapping("mail/normal")
     ResponseEntity<SimpleMail> sendMail( SimpleMail simpleMail);

}
