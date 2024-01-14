package org.hms.prescriptionservice.service.impl;

import lombok.AllArgsConstructor;
import org.hms.prescriptionservice.dto.PrescriptionDto;
import org.hms.prescriptionservice.entity.Prescription;
import org.hms.prescriptionservice.exception.ErrorSavingUserException;
import org.hms.prescriptionservice.exception.NoRecordsFound;
import org.hms.prescriptionservice.feigncalls.ApntFeign;
import org.hms.prescriptionservice.mapper.PrscMapper;
import org.hms.prescriptionservice.repository.PrescriptionRepository;
import org.hms.prescriptionservice.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PrscImpl implements PrescriptionService {
    PrescriptionRepository repository;

    @Override
    public List<Prescription> forPatient(int patientId) {
        try {
            return repository.findByPatientId(patientId);
        } catch (Exception e) {
            throw new NoRecordsFound("No records found for the patient");
        }
    }

    @Override
    public List<Prescription> byDoc(int docId) {
        try {
            return repository.findByDocId(docId);
        } catch (Exception e) {
            throw new NoRecordsFound("No record found!");
        }
    }

    @Override
    public Prescription addPrsc(PrescriptionDto pDto) {
        int size = (int) repository.count();
        try {
            Prescription p = PrscMapper.dtoToPrsc(pDto);
            p.setPrescriptionId(++size);
            return repository.save(p);
        } catch (Exception e) {
            throw new ErrorSavingUserException("Error saving prescription");
        }
    }

    @Override
    public Prescription viewPrsc(int prscId) {
        try {
            return repository.findById(prscId).orElseThrow();
        } catch (Exception e) {
            throw new NoRecordsFound("No record found!");
        }
    }
}
