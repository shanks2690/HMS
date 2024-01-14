package org.hms.patientmicroservice;

import org.hms.patientmicroservice.dto.*;
import org.hms.patientmicroservice.entity.PatientHealthRec;
import org.hms.patientmicroservice.entity.PatientInfo;
import org.hms.patientmicroservice.entity.enums.BranchCode;
import org.hms.patientmicroservice.entity.enums.Department;
import org.hms.patientmicroservice.exception.ErrorSavingUserException;
import org.hms.patientmicroservice.exception.GlobalExceptionHandler;
import org.hms.patientmicroservice.exception.NoRecordsFound;
import org.hms.patientmicroservice.exception.UserNotFoundException;
import org.hms.patientmicroservice.exception.payload.ApiResponse;
import org.hms.patientmicroservice.mapper.DocCredMapper;
import org.hms.patientmicroservice.mapper.HealthMapper;
import org.hms.patientmicroservice.mapper.PatCredMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.sql.Time;
import java.time.LocalDate;

@SpringBootTest
class PatientMicroserviceApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void forMapper() {
        DocCredMapper.credToDocCred(new CredentialsDto());
        HealthMapper.dtoToHealth(new PatientHealthRecDto(), 2);
        PatCredMapper.credToPat(new CredentialsDto());
        new DocCredMapper();
        new HealthMapper();
        new PatCredMapper();
    }

    @Test
    void forExecption() {
        ApiResponse api = new ApiResponse();
        new ApiResponse("asdasd", true, HttpStatus.ACCEPTED);
        api.setMessage(api.getMessage());
        api.setSuccess(api.getSuccess());
        api.setStatus(api.getStatus());
        System.out.println(api);
        ApiResponse.builder().toString();
        ApiResponse.builder().message("Asd").success(true).status(HttpStatus.ACCEPTED).build().toString();
        ErrorSavingUserException eruser = new ErrorSavingUserException("asds");
        UserNotFoundException usernf = new UserNotFoundException("asdsad");
        NoRecordsFound nr = new NoRecordsFound("Asdas");
        new GlobalExceptionHandler().handleErrorSavingUserException(eruser);
        new GlobalExceptionHandler().handleUserNotFoundException(usernf);
        new GlobalExceptionHandler().handleNoRecordFound(nr);
        new UserNotFoundException();
        new ErrorSavingUserException();
        new NoRecordsFound();
    }

    @Test
    void forDto() {
        CredentialsDto dto = new CredentialsDto();
        new CredentialsDto("asda", "asdsa", "asdasd", "Asdas");
        dto.setFirstname(dto.getFirstname());
        dto.setEmail(dto.getEmail());
        dto.setRole(dto.getRole());
        dto.setLastname(dto.getLastname());

        DocDepDto dep = new DocDepDto();
        dep.setLastname(dep.getLastname());
        dep.setFirstname(dep.getFirstname());
        dep.setAvailability(dep.getAvailability());
        dep.setEmail(dep.getEmail());
        dep.setQualification(dep.getQualification());
        dep.setBranchCode(dep.getBranchCode());
        dep.setRegNo(dep.getRegNo());
        dep.setDepartment(dep.getDepartment());
        new DocDepDto("asda", "Asdasd", "Asdad", Department.DENTAL, "asda", "Asdad", BranchCode.H2, true);


        AppointmentInfoDto apnt = new AppointmentInfoDto();
        new AppointmentInfoDto(2, "As,", "Asd", "Asda", 1, "asdas", "Ada",
                Department.DENTAL, BranchCode.H2, 2L, true, true, LocalDate.now(), true);
        apnt.setApproval(apnt.getApproval());
        apnt.setDepartment(apnt.getDepartment());
        apnt.setBranchCode(apnt.getBranchCode());
        apnt.setDate(apnt.getDate());
        apnt.setStatus(apnt.getStatus());
        apnt.setPatientId(apnt.getPatientId());
        apnt.setDocFname(apnt.getDocFname());
        apnt.setDocLname(apnt.getDocLname());
        apnt.setDocId(apnt.getDocId());
        apnt.setEmergency(apnt.getEmergency());
        apnt.setPatientId(apnt.getPatientId());
        apnt.setPatFname(apnt.getPatFname());
        apnt.setPatLname(apnt.getPatLname());
        apnt.setPEmail(apnt.getPEmail());
        apnt.setSlotId(apnt.getSlotId());


        PatientInfo rec = new PatientInfo();
        new PatientInfo(1, "asd", "asdasd", "Asda", "Asdad", LocalDate.MAX, "asdad", "asdasd", "Asdasd", "asdasd", "Asda");
        rec.setDob(rec.getDob());
        rec.setEmail(rec.getEmail());
        rec.setState(rec.getState());
        rec.setContactNo(rec.getContactNo());
        rec.setEmContactNo(rec.getEmContactNo());
        rec.setNok(rec.getNok());
        rec.setPincode(rec.getPincode());
        rec.setCity(rec.getCity());
        rec.setPatientId(rec.getPatientId());
        rec.setLastName(rec.getLastName());
        rec.setFirstName(rec.getFirstName());
        System.out.println(rec);

        AppointmentSlotDto slot = new AppointmentSlotDto();
        slot.setDate(slot.getDate());
        slot.setDepartment(slot.getDepartment());
        slot.setBranchCode(slot.getBranchCode());
        slot.setDocLname(slot.getDocLname());
        slot.setDocId(slot.getDocId());
        slot.setDocFname(slot.getDocFname());
        slot.setSlotFrom(slot.getSlotFrom());
        slot.setSlotTo(slot.getSlotTo());
        slot.setDate(slot.getDate());
        slot.setIsAvaiable(slot.getIsAvaiable());
        System.out.println(slot);
        new AppointmentSlotDto("Asda", "asdas", Department.DENTAL, BranchCode.H2, 1, LocalDate.MAX, Time.valueOf("12:00:00"), Time.valueOf("10:10:10"), true);

        PatCredDto doc = new PatCredDto();
        new PatCredDto("asdsa", "Asdasd", "asdasd");
        doc.setEmail(doc.getEmail());
        doc.setFirstname(doc.getFirstname());
        doc.setLastname(doc.getLastname());

        PatientHealthRec healthRec = new PatientHealthRec();
        healthRec.setEmail(healthRec.getEmail());
        healthRec.setHealthDesc(healthRec.getHealthDesc());
        healthRec.setPatientId(healthRec.getPatientId());
        healthRec.setDocId(healthRec.getDocId());
        healthRec.setDateOfEntry(healthRec.getDateOfEntry());
        healthRec.setRecId(healthRec.getRecId());
        new PatientHealthRec(2,"23,",1,"ass",LocalDate.MAX,2);
        System.out.println(healthRec);

        PatientHealthRecDto pdto = new PatientHealthRecDto();
        pdto.setDateOfEntry(pdto.getDateOfEntry());
        pdto.setPatientId(pdto.getPatientId());
        pdto.setDocId(pdto.getDocId());
        pdto.setEmail(pdto.getEmail());
        pdto.setHealthDesc(pdto.getHealthDesc());
        new PatientHealthRecDto(1,"asd","Adasd",LocalDate.MAX,1);
    }

}
