package org.hms.patientmicroservice.controller;

import org.hms.patientmicroservice.dto.AppointmentInfoDto;
import org.hms.patientmicroservice.dto.Bills;
import org.hms.patientmicroservice.dto.CredentialsDto;
import org.hms.patientmicroservice.dto.PatientHealthRecDto;
import org.hms.patientmicroservice.entity.PatientHealthRec;
import org.hms.patientmicroservice.entity.PatientInfo;
import org.hms.patientmicroservice.feigncalls.ApntFeign;
import org.hms.patientmicroservice.feigncalls.BillFeign;
import org.hms.patientmicroservice.feigncalls.PrscFeign;
import org.hms.patientmicroservice.mapper.HealthMapper;
import org.hms.patientmicroservice.repository.PatientRepository;
import org.hms.patientmicroservice.service.HealthRecService;
import org.hms.patientmicroservice.service.impl.PatImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pat")

public class PatientController {
    public Integer patId;

    @Autowired
    PatImpl pat;
    @Autowired
    ApntFeign apntFeign;
    @Autowired
    HealthRecService healthRecService;
    @Autowired
    PrscFeign prscFeign;
    @Autowired
    PatientRepository patrepo;

    @Autowired
    BillFeign billFeign;

    @GetMapping("myhealth")   // direct access to patient and doctor
    public ResponseEntity<?> viewMyHealthRec(@RequestHeader("loggedInUser") String email) {
        List<PatientHealthRec> rec = healthRecService.getHealthRec(email);
        return ResponseEntity.ok(rec);
    }

    @GetMapping("myprsc")   // direct access to patient and doctor
    public ResponseEntity<?> viewMyPrscs(@RequestHeader("loggedInUser") String email) {
        PatientInfo rec = pat.showMyInfo(email);
        return prscFeign.forPat(String.valueOf(rec.getPatientId()));
    }

    @GetMapping("pathealth")   // feign access doctor only
    public ResponseEntity<?> patHealthRec(@RequestBody String email) {
        List<PatientHealthRec> rec = healthRecService.getHealthRec(email);
        if (!rec.isEmpty())
            return ResponseEntity.ok(rec);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such Record");
    }

    @PostMapping("updatehealth")    //feign access to doc only
    public ResponseEntity<?> addHealthRec(@RequestBody PatientHealthRecDto healthRecDto) {
        int patId = pat.showMyInfo(healthRecDto.getEmail()).getPatientId();
        return ResponseEntity.ok(healthRecService.addHealthRec(HealthMapper.dtoToHealth(healthRecDto, patId)));

    }


    @PutMapping("updateinfo") //access to patient only
    public ResponseEntity<?> updateMyInfo(@RequestBody PatientInfo patientInfo, @RequestHeader("loggedInUser") String email) {


        return ResponseEntity.ok(pat.updateMyInfo(patientInfo, email));
    }

    @GetMapping("myinfo")  //access to patient only
    public ResponseEntity<?> showMyInfo(@RequestHeader("loggedInUser") String email) {
        return ResponseEntity.ok(pat.showMyInfo(email));
    }


    @PostMapping("regapnt")
    public ResponseEntity<?> reqApnt(@RequestHeader("loggedInUser") String email, @RequestBody AppointmentInfoDto appointmentInfoDto) {
        PatientInfo p = pat.showMyInfo(email);
        appointmentInfoDto.setPEmail(email);
        appointmentInfoDto.setPatientId(p.getPatientId());
        appointmentInfoDto.setPatLname(p.getLastName());
        appointmentInfoDto.setPatFname(p.getFirstName());
        return apntFeign.addApnt(appointmentInfoDto);
    }

    @GetMapping("regform")
    public ResponseEntity<?> form(@RequestHeader("loggedInUser") String email) {
        PatientInfo p = pat.showMyInfo(email);
        var appointmentInfoDto = new AppointmentInfoDto();
        appointmentInfoDto.setPEmail(email);
        appointmentInfoDto.setPatientId(p.getPatientId());
        appointmentInfoDto.setPatLname(p.getLastName());
        appointmentInfoDto.setPatFname(p.getFirstName());
        appointmentInfoDto.setApproval(true);

        return ResponseEntity.ok(appointmentInfoDto);
    }


    @PostMapping("add")
    public Boolean addPat(@RequestBody CredentialsDto userCred) {
        System.out.println("adding pat");
        pat.addPat(userCred);
        return true;
    }

    @DeleteMapping("del")
    public String delPat(@RequestBody String username) {
        pat.delPat(username);
        return "Patient Deleted";
    }

    @GetMapping("/mypendbills")
    public ResponseEntity<?> getActiveBillsByPatientId(@RequestHeader("loggedInUser") String email) {
        var list = billFeign.getOldBillsByPatientId(pat.showMyInfo(email).getPatientId());
        if (list.getBody().isEmpty())
    return ResponseEntity.ok("No pending bills");
        else return  list;
    }


    @GetMapping("/mypaidbills")
    public ResponseEntity<?> getOldBillsByPatientId(@RequestHeader("loggedInUser") String email) {
        var list = billFeign.getActiveBillsByPatientId(pat.showMyInfo(email).getPatientId());
        if (list.getBody().isEmpty())
            return ResponseEntity.ok("No bills paid by you");
        else return  list;
    }
}
