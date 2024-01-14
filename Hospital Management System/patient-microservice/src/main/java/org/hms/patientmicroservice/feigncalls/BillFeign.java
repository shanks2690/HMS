package org.hms.patientmicroservice.feigncalls;

import org.hms.patientmicroservice.dto.Bills;
import org.hms.patientmicroservice.dto.PasswordChange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name= "BILLING")
public interface BillFeign {

    @PostMapping("bill/patpendbills")
    public ResponseEntity<List<Bills>> getActiveBillsByPatientId(@RequestBody Integer patientId);



    @PostMapping("bill/patpaidbills")
    public ResponseEntity<List<Bills>> getOldBillsByPatientId(@RequestBody Integer patientId);
}
