package org.hms.pharmacist.dto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name= "GUARD")
public interface GuardFeign {

    @PostMapping("guard/changepwd")
    public ResponseEntity<?> update(@RequestBody PasswordChange pwd);
}
