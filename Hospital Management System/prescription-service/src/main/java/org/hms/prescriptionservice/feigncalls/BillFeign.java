package org.hms.prescriptionservice.feigncalls;


import org.hms.prescriptionservice.dto.PrescriptionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="BILLING")
public interface BillFeign {

    @PostMapping("bill/addbill")
    void addBill(@RequestBody PrescriptionDto prescriptionDto);

    
}
