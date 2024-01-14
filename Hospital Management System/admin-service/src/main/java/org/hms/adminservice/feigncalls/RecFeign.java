package org.hms.adminservice.feigncalls;

import org.hms.adminservice.dto.CredentialsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "RECEPTIONIST")
public interface RecFeign {
    @PostMapping("rec/add")
    public Boolean addRec(CredentialsDto userCred);

    @DeleteMapping("rec/del")
    public void delRec(String email);


    @PutMapping("pharma/del")
    public void delPhar();

}
