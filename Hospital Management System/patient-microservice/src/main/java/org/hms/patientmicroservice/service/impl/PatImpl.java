package org.hms.patientmicroservice.service.impl;

import lombok.AllArgsConstructor;
import org.hms.patientmicroservice.dto.CredentialsDto;
import org.hms.patientmicroservice.dto.PatCredDto;
import org.hms.patientmicroservice.entity.PatientInfo;
import org.hms.patientmicroservice.mapper.PatCredMapper;
import org.hms.patientmicroservice.repository.PatientRepository;
import org.hms.patientmicroservice.service.PatServices;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatImpl implements PatServices {
    PatientRepository patientRepository;

    @Override
    public PatientInfo showMyInfo(String userName) {
        try {
            return patientRepository.findByEmail(userName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public PatientInfo updateMyInfo(PatientInfo uPat, String email) {
        PatientInfo exPat = patientRepository.findByEmail(email);
        uPat.setEmail(email);
        uPat.setPatientId(exPat.getPatientId());
        uPat.setCity(uPat.getCity() == null ? exPat.getCity() : uPat.getCity());
        uPat.setDob(uPat.getDob() == null ? exPat.getDob() : uPat.getDob());
        uPat.setContactNo(uPat.getContactNo() == null ? exPat.getContactNo() : uPat.getContactNo());
        uPat.setEmContactNo(uPat.getEmContactNo() == null ? exPat.getEmContactNo() : uPat.getEmContactNo());
        uPat.setPincode(uPat.getPincode() == null ? exPat.getPincode() : uPat.getPincode());
        uPat.setNok(uPat.getNok() == null ? exPat.getNok() : uPat.getNok());
        uPat.setState(uPat.getState() == null ? exPat.getState() : uPat.getState());
        return patientRepository.save(uPat);
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public String delPat(String email) {
        try {
                PatientInfo pat = patientRepository.findByEmail(email);
            System.out.println("deleting from pat repos " +pat);
            patientRepository.deleteById(pat.getPatientId());
            return "Patient Deleted";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PatientInfo addPat(CredentialsDto cred) {

        return patientRepository.save(PatCredMapper.credToPat(cred));
    }
}
