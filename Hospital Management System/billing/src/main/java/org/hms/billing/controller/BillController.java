package org.hms.billing.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.hms.billing.dto.BillDto;
import org.hms.billing.dto.PrescriptionDto;
import org.hms.billing.entity.Bills;
import org.hms.billing.service.BillisServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillisServiceI billisServiceI;


    // Generate Bill entry
    @PostMapping("/genbill")
    @Operation(summary = "Add Pharma Controller")
    public ResponseEntity<Bills> generateBill(@Parameter(description = "This function will generate bill", required = true) @RequestBody BillDto billDto) {
        try {
            return new ResponseEntity<>(billisServiceI.generateBill(billDto), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // Update bill as per prescription feign call is updating
    @PostMapping("/addbill")
    public void addBill(@RequestBody PrescriptionDto prescriptionDto) {
        billisServiceI.addBill(prescriptionDto);
    }

    // This will show all the bills in database without any filter
    @GetMapping("/allbills")
    public ResponseEntity<List<Bills>> getAllBills() {
        return new ResponseEntity<>(billisServiceI.allBills(), HttpStatus.OK);
    }

    //Method will return bills based on branch code
    @PostMapping("/branchbills")
    public ResponseEntity<List<Bills>> getBillsByBranchCode(@RequestBody String branchCode) {

        return new ResponseEntity<>(billisServiceI.getBillByBranchCode(branchCode), HttpStatus.OK);
    }

    @PostMapping("/patpendbills") // paid bills
    public ResponseEntity<List<Bills>> getActiveBillsByPatientId(@RequestBody Integer patientId) {

        return new ResponseEntity<>(billisServiceI.getBillsByPatientId(patientId, true), HttpStatus.OK);
    }

    @PostMapping("/patpaidbills") // unpaid bills
    public ResponseEntity<List<Bills>> getOldBillsByPatientId(@RequestBody Integer patientId) {

        return new ResponseEntity<>(billisServiceI.getBillsByPatientId(patientId, false), HttpStatus.OK);
    }
}
