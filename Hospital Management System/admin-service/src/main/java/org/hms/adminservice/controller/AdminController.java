package org.hms.adminservice.controller;

import lombok.AllArgsConstructor;
import org.hms.adminservice.document.RegDoc;
import org.hms.adminservice.dto.CredentialsDto;
import org.hms.adminservice.dto.RegistrationCredentials;
import org.hms.adminservice.feigncalls.GuardFeign;
import org.hms.adminservice.repository.RegRepository;
import org.hms.adminservice.service.AdminImpl;
import org.hms.adminservice.transferservices.ConsistencyTfr;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Guard;
import java.util.List;


@RestController
@RequestMapping("admin")
@AllArgsConstructor
public class AdminController {
    AdminImpl admin;
    RegRepository regRepository;
    ConsistencyTfr consistencyTfr;
    GuardFeign guardFeign;
    @PostMapping("register")
    public ResponseEntity<CredentialsDto> registerUser(@RequestBody RegistrationCredentials request) {
        CredentialsDto userCred = admin.registerUser(request).getBody();
        consistencyTfr.saveUser(userCred);
        return ResponseEntity.ok(userCred);
    }
    @DeleteMapping("del")
    public ResponseEntity<String> delUser(@RequestBody String email) {

        System.out.println("deleting "+ email);
        ResponseEntity<CredentialsDto> cred = guardFeign.getUser(email);
        String msg = admin.delUser(email).getBody();

        System.out.println("deleted from user");
//        if(!cred.getBody().getRole().equalsIgnoreCase("ADMIN"))
        consistencyTfr.delUser(cred.getBody());
        return ResponseEntity.ok(msg);

    }

    @GetMapping("allusers")
    public ResponseEntity<List<CredentialsDto>> getAllUsers() {
        return admin.getAllUsers();
    }

    @PostMapping("user")
    public ResponseEntity<CredentialsDto> getUser(@RequestBody  String email) {
        System.out.println("Finding "+ email);
            return guardFeign.getUser(email);

    }

    @GetMapping("regreq")
    public ResponseEntity<List<RegDoc>> getRegRequests() {
        System.out.println(regRepository.findAll());
        return ResponseEntity.ok(regRepository.findAll());
    }
    @PostMapping("regpat")
    public ResponseEntity<?> regPats() {
        RegistrationCredentials request = new RegistrationCredentials();
        List<RegDoc> regList = regRepository.findAll();
        CredentialsDto dto;
        for (RegDoc x : regList) {
            request.setRole("PATIENT");
            request.setEmail(x.getEmail());
            request.setFirstname(x.getFirstname());
            request.setPassword("patient123");
            request.setLastname(x.getLastname());
            dto = admin.registerUser(request).getBody();
             consistencyTfr.saveUser(dto);
            regRepository.deleteByEmail(x.getEmail());
        }
        return ResponseEntity.ok("Requests registered successfully");
    }
}
