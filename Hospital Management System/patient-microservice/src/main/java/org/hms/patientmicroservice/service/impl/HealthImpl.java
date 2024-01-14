package org.hms.patientmicroservice.service.impl;

import lombok.AllArgsConstructor;
import org.hms.patientmicroservice.dto.PatCredDto;
import org.hms.patientmicroservice.entity.PatientHealthRec;
import org.hms.patientmicroservice.entity.PatientInfo;
import org.hms.patientmicroservice.exception.ErrorSavingUserException;
import org.hms.patientmicroservice.exception.NoRecordsFound;
import org.hms.patientmicroservice.exception.UserNotFoundException;
import org.hms.patientmicroservice.repository.HealthRepository;
import org.hms.patientmicroservice.repository.PatientRepository;
import org.hms.patientmicroservice.service.HealthRecService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HealthImpl implements HealthRecService {
 HealthRepository healthRepository;
 PatientRepository patientRepository;


    @Override
    public PatientInfo updateMyInfo(PatientInfo uPat, String userName) {

        try {
            PatientInfo exPat = patientRepository.findByEmail(userName);
            uPat.setCity(uPat.getCity() == null ? exPat.getCity() : uPat.getCity());
            uPat.setDob(uPat.getDob() == null ? exPat.getDob() : uPat.getDob());
            uPat.setContactNo(uPat.getContactNo() == null ? exPat.getContactNo() : uPat.getContactNo());
            uPat.setEmContactNo(uPat.getEmContactNo() == null ? exPat.getEmContactNo() : uPat.getEmContactNo());
            uPat.setPincode(uPat.getPincode() == null ? exPat.getPincode() : uPat.getPincode());
            uPat.setNok(uPat.getNok() == null ? exPat.getNok() : uPat.getNok());
            uPat.setState(uPat.getState() == null ? exPat.getState() : uPat.getState());
            return patientRepository.save(uPat);
        } catch (Exception e) {
            throw new ErrorSavingUserException("Error Saving Patient");
        }
    }


    @Override
    public Boolean addNewPat(PatCredDto patCredDto) {
        try {
            PatientInfo patientInfo = new PatientInfo();
            patientInfo.setEmail(patCredDto.getEmail());
            patientInfo.setFirstName(patCredDto.getFirstname());
            patientInfo.setLastName(patCredDto.getLastname());
            patientRepository.save(patientInfo);
            return true;

        } catch (Exception e) {
            throw new ErrorSavingUserException("Error saving Patient");
        }
    }

    @Override
    public String delPat(String email) {
        try {

            patientRepository.deleteByEmail(email);
            return "Patient Deleted";
        } catch (Exception e) {
            throw new NoRecordsFound("No such patient exists!");
        }
    }

    @Override
    public List<PatientHealthRec> getHealthRec(String email) {
        try {
            List<PatientHealthRec> healthRec = healthRepository.findByEmail(email);
            if(healthRec.isEmpty())
              throw new RuntimeException("No health record found for the patient!");
            return healthRec;
        } catch (Exception e) {
         throw new NoRecordsFound(e.getMessage());
        }
    }

    @Override
    public PatientHealthRec addHealthRec(PatientHealthRec rec) {
        try {
            return healthRepository.save(rec);
        } catch (Exception e) {
            throw new RuntimeException("Error saving record");
        }
    }
}
