package org.hms.receptionistmicroservice.feigncalls;

import org.hms.receptionistmicroservice.dto.CredentialsDto;
import org.hms.receptionistmicroservice.dto.PasswordChange;
import org.hms.receptionistmicroservice.dto.RegistrationCredentials;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name= "GUARD")
public interface GuardFeign {

    @PostMapping("guard/changepwd")
    public ResponseEntity<?> update(@RequestBody PasswordChange pwd);

    @PostMapping("guard/register")
    public ResponseEntity<CredentialsDto> register(@RequestBody RegistrationCredentials request);
}
