package org.hms.doctormicroservice.feigncalls;

import org.hms.doctormicroservice.dto.PatientHealthRecDto;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name= "PATIENT")
public interface PatientFeign {
    @PostMapping("pat/updatehealth")
    public ResponseEntity<?> addHealthRec(@RequestBody PatientHealthRecDto healthRecDto);


    @GetMapping("pat/health")   // feign access doctor only
    public ResponseEntity<?> patHealthRec(@RequestBody String email);
}
