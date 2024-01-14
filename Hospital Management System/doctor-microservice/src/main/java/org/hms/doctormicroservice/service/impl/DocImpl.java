package org.hms.doctormicroservice.service.impl;


import lombok.AllArgsConstructor;
import org.hms.doctormicroservice.dto.DocCredDto;
import org.hms.doctormicroservice.dto.DocDepDto;
import org.hms.doctormicroservice.dto.PatientHealthRecDto;
import org.hms.doctormicroservice.dto.PrescriptionDto;
import org.hms.doctormicroservice.entity.DoctorInfo;
import org.hms.doctormicroservice.exception.ErrorSavingUserException;
import org.hms.doctormicroservice.exception.UserNotFoundException;
import org.hms.doctormicroservice.mapper.DocCredMapper;
import org.hms.doctormicroservice.repository.DoctorRepository;
import org.hms.doctormicroservice.service.DocServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DocImpl implements DocServices {
DoctorRepository doctorRepository;
    @Override
    public DoctorInfo getDoc(String userName) {
        try{
            return doctorRepository.findByEmail(userName);

        } catch (Exception e) {
            throw new UserNotFoundException("No such doctor exists!!");
        }
    }

    @Override
    public String delDoc(String userName) {

        try {
            doctorRepository.deleteById(doctorRepository.findByEmail(userName).getDocId());
//        doctorRepository.deleteByEmail(userName);
        } catch (Exception e) {
            throw new UserNotFoundException("No such doctor exists!");
        }
        return "Doctor deleted";
    }

    @Override
    public DoctorInfo updateInfo(DoctorInfo updatedInfo, String userName) {
       try {
           DoctorInfo newDoctor = doctorRepository.findByEmail(userName);
           newDoctor.setBranchCode(updatedInfo.getBranchCode() == null ? newDoctor.getBranchCode() : updatedInfo.getBranchCode());
           newDoctor.setDepartment(updatedInfo.getDepartment() == null ? newDoctor.getDepartment() : updatedInfo.getDepartment());
           newDoctor.setDateOfReg(updatedInfo.getDateOfReg() == null ? newDoctor.getDateOfReg() : updatedInfo.getDateOfReg());
           newDoctor.setQualification(updatedInfo.getQualification() == null ? newDoctor.getQualification() : updatedInfo.getQualification());
           newDoctor.setDateOfSpl(updatedInfo.getDateOfSpl() == null ? newDoctor.getDateOfSpl() : updatedInfo.getDateOfSpl());
           newDoctor.setRegNo(updatedInfo.getRegNo() == null ? newDoctor.getRegNo() : updatedInfo.getRegNo());
           newDoctor.setAvailability(true);
           doctorRepository.save(newDoctor);
           return newDoctor;
       } catch (Exception e) {
           throw new UserNotFoundException("No such doctor exists!");
       }
    }

    @Override
    public DoctorInfo showMyInfo(Integer docId) {
        try{
            return doctorRepository.findById(docId).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean addNewDoc(DocCredDto docCredDto) {
        try{
            DoctorInfo doctorInfo = new DoctorInfo();
            doctorInfo.setEmail(docCredDto.getEmail());
            doctorInfo.setFirstName(docCredDto.getFirstname());
            doctorInfo.setLastName(docCredDto.getLastname());
            doctorRepository.save(doctorInfo);
            return true;

        } catch (Exception e) {
            throw new ErrorSavingUserException("Error saving doctor!");
        }
    }

    @Override
    public List<DocDepDto> getAllDocs() {
        try{
            List<DoctorInfo> allDocs= doctorRepository.findAll().stream().filter(doc-> (doc.getDepartment()!=null&&doc.getBranchCode()!=null)).toList();
            System.out.println(allDocs);

            return allDocs.stream().map(DocCredMapper::infoMap).toList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public PatientHealthRecDto addHealthRec(PatientHealthRecDto patientHealthRecDto) {
        try{

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return patientHealthRecDto;
    }
}
