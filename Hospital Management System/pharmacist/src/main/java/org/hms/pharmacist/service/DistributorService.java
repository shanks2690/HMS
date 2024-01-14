package org.hms.pharmacist.service;

import org.hms.pharmacist.entity.PharmaCompany;
import org.hms.pharmacist.entity.PharmaDistributor;
import org.hms.pharmacist.repository.PharmaDistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributorService {

    @Autowired
    PharmaDistributorRepository distributorRepositoryl;

    public ResponseEntity<List<PharmaDistributor>> getAllDist() {

        try {
            return new ResponseEntity<>(distributorRepositoryl.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Get all for Distributors by name
    public ResponseEntity<List<PharmaDistributor>> getDistributorByName(String firstname) {

        try {
            return new ResponseEntity<>(distributorRepositoryl.findByPharDistFirstNameStartingWith(firstname), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Get all Distributor
    public ResponseEntity<List<PharmaDistributor>> getAllDistributor() {

        try {
            return new ResponseEntity<>(distributorRepositoryl.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // insert for Company
    public ResponseEntity<PharmaDistributor> insertDistributor(PharmaDistributor distributor) {

        try {
            return new ResponseEntity<>(distributorRepositoryl.save(distributor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Update for Company
    public ResponseEntity<PharmaDistributor> updateDistributor(PharmaDistributor distributor) {

        try {

            PharmaDistributor fetchDist = distributorRepositoryl.findById(distributor.getPharId()).orElseThrow(RuntimeException::new);

            //id
            distributor.setPharDistId(fetchDist.getPharDistId());
            //firstname
            distributor.setPharDistFirstName(distributor.getPharDistFirstName() == null ? fetchDist.getPharDistFirstName() : distributor.getPharDistFirstName());
            // lastname
            distributor.setPharDistLastName(distributor.getPharDistLastName() == null ? fetchDist.getPharDistLastName() : distributor.getPharDistLastName());
            // phar id
            distributor.setPharId(distributor.getPharId() == 0 ? fetchDist.getPharId() : distributor.getPharId());
            // status
            distributor.setStatus(distributor.getStatus() == null ? fetchDist.getStatus() : distributor.getStatus());
            // age
            distributor.setPharDistAge(distributor.getPharDistAge() == 0 ? fetchDist.getPharDistAge() : distributor.getPharDistAge());
            // city
            distributor.setPharDistCity(distributor.getPharDistCity() == null ? fetchDist.getPharDistCity() : distributor.getPharDistCity());
            // address
            distributor.setPharDistAddress(distributor.getPharDistAddress() == null ? fetchDist.getPharDistAddress() : distributor.getPharDistAddress());
            // email
            distributor.setPharDistEmail(distributor.getPharDistEmail() == null ? fetchDist.getPharDistEmail() : distributor.getPharDistEmail());
            //mobile
            distributor.setPharDistMobile(distributor.getPharDistMobile() == null ? fetchDist.getPharDistMobile() : distributor.getPharDistMobile());
            //pinCode
            distributor.setPharDistPincode(distributor.getPharDistPincode() == null ? fetchDist.getPharDistPincode() : distributor.getPharDistPincode());
            //registration date
            distributor.setPharDistRegistrationDate(distributor.getPharDistRegistrationDate() == null ? fetchDist.getPharDistRegistrationDate() : distributor.getPharDistRegistrationDate());

            return new ResponseEntity<>(
                    distributorRepositoryl.save(distributor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Delete for Distributor
    public ResponseEntity<String> deleteDist(int distid) {

        try {
            distributorRepositoryl.deleteById(distid);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Deleting", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
