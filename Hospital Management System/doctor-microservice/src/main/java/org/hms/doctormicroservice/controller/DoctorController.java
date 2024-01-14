package org.hms.doctormicroservice.controller;


import lombok.AllArgsConstructor;
import org.hms.doctormicroservice.dto.*;
import org.hms.doctormicroservice.entity.DoctorInfo;
import org.hms.doctormicroservice.feigncalls.AppointmentFeign;
import org.hms.doctormicroservice.feigncalls.PatientFeign;
import org.hms.doctormicroservice.feigncalls.PrscFeign;
import org.hms.doctormicroservice.kafka.Sender;
import org.hms.doctormicroservice.service.impl.DocImpl;
import org.shanks.AppointmentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("doc")
@AllArgsConstructor
public class DoctorController {
    //@Autowired
//AppointmentServices appointment;
    AppointmentFeign appointmentFeign;

    PatientFeign patientFeign;
PrscFeign prscFeign;
    DocImpl docImpl;

    Sender sender;

    @GetMapping("appointments")
    public ResponseEntity<?> docLogin(@RequestHeader("loggedInUser") String userName) {
        int docId;
        List<AppointmentInfoDto> appointments;
        docId = docImpl.getDoc(userName).getDocId();
        try {
            appointments = appointmentFeign.showApnt(String.valueOf(docId)).getBody();
        } catch (Exception e) {
            return ResponseEntity.ok("No Appointments for you!");
        }
        return ResponseEntity.ok(appointments);
    }

    @PostMapping("rejapnt")
    public ResponseEntity<?> rejectApnt(@RequestBody DocCredDto docCredDto) {
        return ResponseEntity.ok(docImpl.addNewDoc(docCredDto));
    }

    @PostMapping("addprsc")
    public ResponseEntity<?> writePrsc(@RequestHeader("loggedInUser") String userName, @RequestBody PrescriptionDto pDto) {
       AppointmentInfoDto appointmentInfoDto = appointmentFeign.getApnt(pDto.getAppointmentId()).getBody();
        DoctorInfo doc = docImpl.getDoc(userName);
        pDto.setPatientName(appointmentInfoDto.getPatFname()+ " "+ appointmentInfoDto.getPatLname());
        pDto.setPatientId(Math.toIntExact(appointmentInfoDto.getPatientId()));
        pDto.setEmergency(appointmentInfoDto.getEmergency());
        pDto.setDocId(doc.getDocId());
        pDto.setBranchCode(doc.getBranchCode());
        pDto.setDocName(doc.getFirstName()+" "+doc.getLastName());
        pDto.setDocQual(doc.getQualification());
        pDto.setDocRegdNo(doc.getRegNo());
        pDto.setPrescriptionDate(LocalDate.now());
        pDto.setDepartment(doc.getDepartment());

        return ResponseEntity.ok(prscFeign.add(pDto).getBody());
    }

    @GetMapping("prscform")
    public ResponseEntity<?> writePrsc(@RequestHeader("loggedInUser") String userName) {
        DoctorInfo doc = docImpl.getDoc(userName);
        PrescriptionDto pDto = new PrescriptionDto();
        pDto.setDocId(doc.getDocId());
        pDto.setDocName(doc.getFirstName()+doc.getLastName());
        pDto.setDocQual(doc.getQualification());
        pDto.setDocRegdNo(doc.getRegNo());
        pDto.setPrescriptionDate(LocalDate.now());
        return prscFeign.show(pDto);
    }
    @PostMapping("add") //with admin only
    public ResponseEntity<?> addDoc(@RequestBody DocCredDto docCredDto) {
        return ResponseEntity.ok(docImpl.addNewDoc(docCredDto));
    }

    @DeleteMapping("del")  // with admin only
    public ResponseEntity<String> delDoc( @RequestBody String email) {

        return ResponseEntity.ok(docImpl.delDoc(email));
    }

    @PutMapping("updateinfo")
    public ResponseEntity<?> updateMyInfo(@RequestBody DoctorInfo doctorInfo, @RequestHeader("loggedInUser") String email) {
        return ResponseEntity.ok(docImpl.updateInfo(doctorInfo, email));
    }

    @PostMapping("addhealthrec")
    public ResponseEntity<?> updateHealthRec(@RequestBody PatientHealthRecDto patientHealthRecDto, @RequestHeader("loggedInUser") String userName) {
        return ResponseEntity.ok(patientFeign.addHealthRec(patientHealthRecDto));
    }

    @GetMapping("myinfo")
    public ResponseEntity<?> showMyInfo(@RequestHeader("loggedInUser") String email) {
        int docId;
        System.out.println(email);
        docId = docImpl.getDoc(email).getDocId();
        System.out.println(docId);
        return ResponseEntity.ok(docImpl.showMyInfo(docId));
    }



@GetMapping("slotform")
    public ResponseEntity<?> slotform(@RequestHeader("loggedInUser") String email) {
        var slot = new AppointmentSlotDto();
        DoctorInfo doc = docImpl.getDoc(email);
        slot.setDocId(doc.getDocId());
        return ResponseEntity.ok(slot);
    }

    @PostMapping("addslot")
    public ResponseEntity<?> addSlot(@RequestHeader("loggedInUser") String email, @RequestBody AppointmentSlotDto slot) {
        DoctorInfo doc = docImpl.getDoc(email);
        slot.setDepartment(doc.getDepartment());
        slot.setBranchCode(doc.getBranchCode());
        slot.setDocId(doc.getDocId());
        slot.setDocLname(doc.getLastName());
        slot.setDocFname(doc.getFirstName());

        return ResponseEntity.ok(appointmentFeign.addSlot(slot).getBody());
    }

    @GetMapping("myslots")
    public ResponseEntity<?> viewSlot(@RequestHeader("loggedInUser") String email) {
        DoctorInfo doc = docImpl.getDoc(email);

        return ResponseEntity.ok(appointmentFeign.showSlots(String.valueOf(doc.getDocId())).getBody());
    }


    @DeleteMapping("delslot")
    public ResponseEntity<String> delSlot(@RequestBody String slotId) {
        System.out.println(slotId);
        Long id = Long.parseLong(slotId);
        return (ResponseEntity<String>) appointmentFeign.delSlot(id);
    }

    @PostMapping("reject")
    public void send(@RequestBody AppointmentRequest request) {
        sender.sendMessage(request);
    }
    @GetMapping("alldocs")
    public ResponseEntity<?> getAllDocs() {
        return ResponseEntity.ok(docImpl.getAllDocs());
    }
}
