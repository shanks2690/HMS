package org.hms.adminservice.feigncalls;

import org.hms.adminservice.dto.CredentialsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "DOCTOR")
public interface DocFeign {
    @PostMapping("doc/add")
    public Boolean addDoc(CredentialsDto userCred);


    @DeleteMapping("doc/del")
    ResponseEntity<String> delDoc(@RequestBody String email);
}
