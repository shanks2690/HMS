package org.hms.prescriptionservice.controller;

import lombok.AllArgsConstructor;
import org.hms.prescriptionservice.dto.PrescriptionDto;
import org.hms.prescriptionservice.feigncalls.ApntFeign;
import org.hms.prescriptionservice.feigncalls.BillFeign;
import org.hms.prescriptionservice.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prsc")
@AllArgsConstructor
public class PrescriptionController {
    //@Autowired
    PrescriptionService prescriptionService;
    //@Autowired
    ApntFeign apntFeign;

    BillFeign billFeign;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody PrescriptionDto pDto) {
        apntFeign.setStatus(pDto.getAppointmentId());
        System.out.println(pDto);
        billFeign.addBill(pDto);
        return ResponseEntity.ok(prescriptionService.addPrsc(pDto));
    }

    @PostMapping("form")
    public ResponseEntity<?> show(@RequestBody PrescriptionDto pDto) {
        return ResponseEntity.ok(pDto);
    }

    @PostMapping("forpat")
    public ResponseEntity<?> forPat(@RequestBody String patientID) {
        return ResponseEntity.ok(prescriptionService.forPatient(Integer.valueOf(patientID)));
    }

    @PostMapping("view")
    public ResponseEntity<?> viewPrsc(@RequestBody String prscId) {
        return ResponseEntity.ok(prescriptionService.viewPrsc(Integer.valueOf(prscId)));
    }

    @PostMapping("bydoc")
    public ResponseEntity<?> byDoc(@RequestBody String docId) {
        return ResponseEntity.ok(prescriptionService.byDoc(Integer.valueOf(docId)));
    }

//    @PostMapping("mailprsc")
//    public ResponseEntity<?> mailIt(@RequestBody String prscId)
//    {
//
//    }

}
