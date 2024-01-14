package org.hms.adminservice.feigncalls;

import org.hms.adminservice.dto.CredentialsDto;
import org.hms.adminservice.dto.RegistrationCredentials;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@FeignClient(name="GUARD")
public interface GuardFeign {
    @PostMapping("guard/register")
     ResponseEntity<CredentialsDto> register( RegistrationCredentials request );

    @GetMapping("guard/allusers") // access with admin
     ResponseEntity<List<CredentialsDto>> fetchAll();


    @DeleteMapping("guard/del")   // access with admin
    ResponseEntity<String> delAccount(@RequestBody String userName);

    @PutMapping("guard/update")
    ResponseEntity<String> updateAccount(RegistrationCredentials credentials);


    @PostMapping("guard/user") // access with admin
    ResponseEntity<CredentialsDto> getUser(@RequestBody  String email);


}
