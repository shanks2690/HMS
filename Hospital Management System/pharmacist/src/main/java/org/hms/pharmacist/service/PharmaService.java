package org.hms.pharmacist.service;


import org.hms.pharmacist.entity.Pharma;
import org.hms.pharmacist.repository.PharmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class PharmaService {
    @Autowired
    private PharmaRepository pharmarepo;


    public Pharma savepharma(Pharma pharma) {
        try {
            return pharmarepo.save(pharma);
        } catch (Exception e) {
            throw new RuntimeException("Could not save user");
        }
    }

    // delete pharma by email
    public ResponseEntity<Boolean> delPharmaByEmail(String email) {
        try {
            //getting email id
            Pharma fetchPharma = pharmarepo.findOneByPharEmailIgnoreCase(email).orElseThrow(RuntimeException::new);
            pharmarepo.deleteById(fetchPharma.getPharId());
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update for Pharma
    public ResponseEntity<Pharma> updatePharma(Pharma pharma, String email) {

        try {
            //getting email id
            Pharma fetchPharma = pharmarepo.findOneByPharEmailIgnoreCase(pharma.getPharEmail()).orElseThrow(RuntimeException::new);

            pharma.setPharId(fetchPharma.getPharId());
            pharma.setPharEmail(pharma.getPharEmail() == null ? fetchPharma.getPharEmail() : pharma.getPharEmail());
            pharma.setPharFirstName(pharma.getPharFirstName() == null ? fetchPharma.getPharFirstName() : pharma.getPharFirstName());
            pharma.setPharLastName(pharma.getPharLastName() == null ? fetchPharma.getPharLastName() : pharma.getPharLastName());
            pharma.setStatus(pharma.getStatus() == null ? fetchPharma.getStatus() : pharma.getStatus());
            return new ResponseEntity<>(
                    pharmarepo.save(pharma), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
