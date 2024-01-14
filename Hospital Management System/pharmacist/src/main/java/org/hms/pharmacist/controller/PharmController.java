package org.hms.pharmacist.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.hms.pharmacist.dto.CredentialsDto;
import org.hms.pharmacist.dto.GuardFeign;
import org.hms.pharmacist.dto.MedicineQtyDto;
import org.hms.pharmacist.dto.PasswordChange;
import org.hms.pharmacist.entity.Pharma;
import org.hms.pharmacist.entity.PharmaCompany;
import org.hms.pharmacist.entity.PharmaDistributor;
import org.hms.pharmacist.entity.PharmaMedicine;
import org.hms.pharmacist.mapper.PharCredMapper;
import org.hms.pharmacist.service.CompanyService;
import org.hms.pharmacist.service.DistributorService;
import org.hms.pharmacist.service.MedicineService;
import org.hms.pharmacist.service.PharmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pharma")
public class PharmController {

    @Autowired
    private PharmaService pharmaService;
    @Autowired
    GuardFeign guardFeign;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private DistributorService distributorService;

    @Autowired
    private MedicineService medicineService;

    // Save Pharama entry
    @PostMapping("addpharm")
    public Boolean addPhar(@RequestBody CredentialsDto pharma) {
        pharmaService.savepharma(PharCredMapper.credToPhar(pharma));
        return true;
    }

    // Update Pharama
    @PutMapping("/updatepharm")
    public ResponseEntity<Pharma> updatePharam(@RequestBody Pharma pharma, @PathVariable String email) {
        return pharmaService.updatePharma(pharma, email);
    }

    // Delete Pharama
    @DeleteMapping("/delpharm")
    public String delPhar(@RequestBody String email) {
         pharmaService.delPharmaByEmail(email);
    return "Pharmacist Deleted";
    }

    @PutMapping("changepwd")
    public ResponseEntity<?> updatePwd(@RequestHeader("loggedInUser") String email, @RequestBody PasswordChange pwd) {
        pwd.setEmail(email);
        return ResponseEntity.ok(guardFeign.update(pwd));
    }

    // Get list of Companies
    @GetMapping("/allcompany")
    public ResponseEntity<List<PharmaCompany>> GetallPharmaCompany() {
        return companyService.getAllCompany();
    }

    // Get list of Companies
    @PostMapping("/coybyname")
    public ResponseEntity<List<PharmaCompany>> GetCompanyByName(@Parameter(description = "Enter Company Name", required = true) @RequestBody String companyName) {
        return companyService.getCompanyByCompanyName(companyName);
    }

    //Save Company
    @PostMapping("/savecompany")
    public ResponseEntity<PharmaCompany> insertCompany(@RequestBody PharmaCompany company) {

        return companyService.insertCompany(company);
    }

    // Update Company

    @PutMapping("/updatecoy")
    public ResponseEntity<PharmaCompany> updateCompany(@RequestBody PharmaCompany company) {
        return companyService.updateCompany(company);
    }

    //Delete Company
    @DeleteMapping("/delcoy")
    public ResponseEntity<String> deleteCompany(@Parameter(description = "Enter Company Id", required = true) @RequestBody Integer id) {
        return companyService.deleteCompany(id);
    }

    // Get list of Distributor
    @GetMapping("/alldistributor")
    public ResponseEntity<List<PharmaDistributor>> GetAllPharmaDistributor() {
        return distributorService.getAllDistributor();
    }

    // Get list of Distributors
    @PostMapping("/sdistname")
    public ResponseEntity<List<PharmaDistributor>> GetDistributorByName(@Parameter(description = "Enter Distributor Name", required = true) @RequestBody String fname) {
        return distributorService.getDistributorByName(fname);
    }

    //Save Distributor
    @PostMapping("/savedistributor")
    public ResponseEntity<PharmaDistributor> insertDistributor(@RequestBody PharmaDistributor distributor) {

        return distributorService.insertDistributor(distributor);
    }

    // Update Distributor

    @PutMapping("/updatedistributor")
    public ResponseEntity<PharmaDistributor> updateDistributor(@RequestBody PharmaDistributor distributor) {

        return distributorService.updateDistributor(distributor);
    }

    //Delete Distributor
    @DeleteMapping("/deldist")
    public ResponseEntity<String> deleteDistributor(@Parameter(description = "Enter Distributor Id", required = true) @RequestBody Integer id) {
        return distributorService.deleteDist(id);
    }

    // Get list of Medicine
    @GetMapping("/allmed")
    public ResponseEntity<List<PharmaMedicine>> GetAllMedicine() {
        return medicineService.getAllMed();
    }

    // Get list of Medicine by name
    @PostMapping("/searchmedbyname")
    public ResponseEntity<List<PharmaMedicine>> GetMedByName(@Parameter(description = "Enter Medicine Name", required = true) @RequestBody String name) {
        return medicineService.getMedicineByName(name);
    }

    //Save Medicine
    @PostMapping("/savemed")
    public ResponseEntity<PharmaMedicine> insertMed(@RequestBody PharmaMedicine medicine) {

        return medicineService.insertMedicine(medicine);
    }
    @PostMapping("/searchmedicinebynamecollection")
    public List<PharmaMedicine> GetMedByNameCollection(@Parameter(description = "Enter Medicine Name", required = true) @RequestBody String nameCollection) {
        return medicineService.getMedicineByNameCollection(nameCollection);

    }
    // Update Medicine

    @PutMapping("/updatemed")
    public ResponseEntity<PharmaMedicine> updateMed(@RequestBody PharmaMedicine medicine) {

        return medicineService.updateMedicine(medicine);
    }

    //Delete Medicine
    @DeleteMapping("/deletemed")
    public ResponseEntity<String> deleteMed(@Parameter(description = "Enter Medicine Id for deletion", required = true) @RequestBody Integer id) {
        return medicineService.deleteMed(id);
    }
    @PutMapping("/updatemedqty")
    public Boolean updateMedQty(@RequestBody List<MedicineQtyDto> medicineQty) {
        return medicineService.updateMedicineQty(medicineQty);
    }

}
