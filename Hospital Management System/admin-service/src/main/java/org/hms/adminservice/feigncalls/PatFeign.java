package org.hms.adminservice.feigncalls;

import org.hms.adminservice.dto.CredentialsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "PATIENT")
public interface PatFeign {
    @PostMapping("pat/add")
    public Boolean addPat(CredentialsDto userCred);
    @DeleteMapping("pat/del")
    public void delPat(String email);
}
