package org.hms.pharmacist.service;

import org.hms.pharmacist.dto.MedicineQtyDto;
import org.hms.pharmacist.entity.PharmaDistributor;
import org.hms.pharmacist.entity.PharmaMedicine;
import org.hms.pharmacist.repository.PharmaMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineService {

    @Autowired
    PharmaMedicineRepository medicineRepository;

    public ResponseEntity<List<PharmaMedicine>> getAllMed() {

        try {
            return new ResponseEntity<>(medicineRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    public Boolean updateMedicineQty(List<MedicineQtyDto> medicineList) {

        try {

            for (MedicineQtyDto med : medicineList) {

                PharmaMedicine fetchMed = medicineRepository.findById(med.getMedId()).orElseThrow(RuntimeException::new);

                fetchMed.setPharMedQty((fetchMed.getPharMedQty() - med.getQtyConsumed()));

                medicineRepository.save(fetchMed);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // Get all Medicine by name
    public ResponseEntity<List<PharmaMedicine>> getMedicineByName(String name) {

        try {
            return new ResponseEntity<>(medicineRepository.findByPharMedNameStartingWith(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public List<PharmaMedicine> getMedicineByNameCollection(String nameCollection) {
        List<PharmaMedicine> medicineList = new ArrayList<>();
        try {
            String[] name = nameCollection.split(",");
            for (String s : name) {
                if (!s.isBlank()) {
                    PharmaMedicine medicine = medicineRepository.findByPharMedName(s);
                    medicineList.add(medicine);
                }
            }
            return medicineList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // insert for Medicine
    public ResponseEntity<PharmaMedicine> insertMedicine(PharmaMedicine medicine) {

        try {
            return new ResponseEntity<>(medicineRepository.save(medicine), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Update for Medicine
    public ResponseEntity<PharmaMedicine> updateMedicine(PharmaMedicine medicine) {

        try {

            PharmaMedicine fetchMed = medicineRepository.findById(medicine.getPharDistId()).orElseThrow(RuntimeException::new);

            //id
            medicine.setPharDistId(fetchMed.getPharDistId());
            //name
            medicine.setPharMedName(medicine.getPharMedName() == null ? fetchMed.getPharMedName() : medicine.getPharMedName());
            // type
            medicine.setPharMedType(medicine.getPharMedType() == null ? fetchMed.getPharMedType() : medicine.getPharMedType());
            // Manufacture date
            medicine.setPharMedMafDate(medicine.getPharMedMafDate() == null ? fetchMed.getPharMedMafDate() : medicine.getPharMedMafDate());
            // Expiry Date
            medicine.setPharMedExpDate(medicine.getPharMedExpDate() == null ? fetchMed.getPharMedExpDate() : medicine.getPharMedExpDate());
            // Med Qyt
            medicine.setPharMedQty(medicine.getPharMedQty() == 0 ? fetchMed.getPharMedQty() : medicine.getPharMedQty());
            // price
            medicine.setPharMedPrice(medicine.getPharMedPrice() == 0.0 ? fetchMed.getPharMedPrice() : medicine.getPharMedPrice());
            // company Id
            medicine.setPharCompanyId(medicine.getPharCompanyId() == 0 ? fetchMed.getPharCompanyId() : medicine.getPharCompanyId());
            // distributor Id
            medicine.setPharDistId(medicine.getPharDistId() == 0 ? fetchMed.getPharDistId() : medicine.getPharDistId());
            //Med Inventory Addition Date
            medicine.setPharMedAdditionDate(medicine.getPharMedAdditionDate() == null ? fetchMed.getPharMedAdditionDate() : medicine.getPharMedAdditionDate());
            //status
            medicine.setStatus(medicine.getStatus() == null ? fetchMed.getStatus() : medicine.getStatus());

            return new ResponseEntity<>(
                    medicineRepository.save(medicine), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Delete for Medicine
    public ResponseEntity<String> deleteMed(int medId) {

        try {
            medicineRepository.deleteById(medId);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Deleting", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
