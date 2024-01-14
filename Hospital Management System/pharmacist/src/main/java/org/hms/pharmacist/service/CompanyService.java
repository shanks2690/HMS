package org.hms.pharmacist.service;

import org.hms.pharmacist.entity.PharmaCompany;
import org.hms.pharmacist.repository.PharmaCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private PharmaCompanyRepository companyRepository;

    // Get all for Company
    public ResponseEntity<List<PharmaCompany>> getAllCompany() {

        try {
            return new ResponseEntity<>(companyRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Get all for Company
    public ResponseEntity<List<PharmaCompany>> getCompanyByCompanyName(String company) {

        try {
            return new ResponseEntity<>(companyRepository.findByPharCompanyNameStartingWith(company), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Get all for Company
    public ResponseEntity<List<PharmaCompany>> getCompanyByName() {

        try {
            return new ResponseEntity<>(companyRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // insert for Company
    public ResponseEntity<PharmaCompany> insertCompany(PharmaCompany company) {

        try {
            return new ResponseEntity<>(companyRepository.save(company), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Update for Company
    public ResponseEntity<PharmaCompany> updateCompany(PharmaCompany company) {

        try {

            PharmaCompany fetchCompany = companyRepository.findById(company.getPharCompanyId()).orElseThrow(RuntimeException::new);

            company.setPharCompanyId(fetchCompany.getPharCompanyId());
            company.setPharCompanyName(company.getPharCompanyName() == null ? fetchCompany.getPharCompanyName() : company.getPharCompanyName());
            company.setPharCompanyOrigin(company.getPharCompanyOrigin() == null ? fetchCompany.getPharCompanyOrigin() : company.getPharCompanyOrigin());
            company.setPharId(company.getPharId() == null ? fetchCompany.getPharId() : company.getPharId());
            company.setStatus(company.getStatus() == null ? fetchCompany.getStatus() : company.getStatus());
            return new ResponseEntity<>(
                    companyRepository.save(company), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Delete for Company
    public ResponseEntity<String> deleteCompany(int companyid) {

        try {
            companyRepository.deleteById(companyid);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Deleting", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
