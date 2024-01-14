package org.hms.adminservice.feigncalls;

import org.hms.adminservice.dto.CredentialsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PHARMACIST")
public interface PharFeign {
    @PostMapping("pharma/addpharm")

    public Boolean addPhar(@RequestBody CredentialsDto pharma);

    @DeleteMapping("pharma/delpharm")
    public void delPhar(String email);

}

