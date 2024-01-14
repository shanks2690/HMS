package org.hms.receptionistmicroservice;

import com.netflix.discovery.converters.Auto;
import org.hms.CredToken;
import org.hms.receptionistmicroservice.controller.ReceptionController;
import org.hms.receptionistmicroservice.dto.*;

import org.hms.receptionistmicroservice.entity.ReceptionistInfo;
import org.hms.receptionistmicroservice.entity.enums.BranchCode;
import org.hms.receptionistmicroservice.entity.enums.Department;
import org.hms.receptionistmicroservice.exception.ErrorSavingUserException;
import org.hms.receptionistmicroservice.exception.GlobalExceptionHandler;
import org.hms.receptionistmicroservice.exception.NoRecordsFound;
import org.hms.receptionistmicroservice.exception.UserNotFoundException;
import org.hms.receptionistmicroservice.exception.payload.ApiResponse;
import org.hms.receptionistmicroservice.kafka.Sender;
import org.hms.receptionistmicroservice.mapper.PatCredMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ReceptionistMicroserviceApplicationTests {
    @Autowired
    ReceptionController receptionController;
    @Autowired
    Sender sender;

    @Test
    void controller() {
        receptionController.getAllDocs();
        RecCredDto dto = new RecCredDto("Asdas", "asdas", "Asdasd");
        dto.setEmail(dto.getEmail());
        dto.setLastname(dto.getLastname());
        dto.setFirstname(dto.getFirstname());
        receptionController.addRec(dto);
        Assertions.assertThrows(Exception.class, ()-> receptionController.addRec(null));
        receptionController.showMyInfo(dto.getEmail());
        Assertions.assertThrows(Exception.class,()->receptionController.showMyInfo("asdasd"));
        receptionController.mySlots("502");
        receptionController.updateMyInfo(new ReceptionistInfo(), dto.getEmail());
        ReceptionistInfo rec = new ReceptionistInfo();
        rec.setBranchCode(BranchCode.H2);
        receptionController.updateMyInfo(rec,dto.getEmail());
        Assertions.assertThrows(Exception.class,()->receptionController.updateMyInfo(rec,"asdad"));
        receptionController.delRec(dto.getEmail());
        Assertions.assertThrows(Exception.class,()->receptionController.delRec(dto.getEmail()));

        receptionController.registerPatient(new PatientInfoDto());
//        receptionController.bookRoom("hsajhjdhsjd",new RoomAllocDto());
        Assertions.assertThrows(Exception.class,()-> receptionController.reqApnt("asd",new AppointmentInfoDto()));


    }


    @Test
    void forDto() {
        CredentialsDto dto = new CredentialsDto();
        new CredentialsDto("asda", "asdsa", "asdasd", "Asdas");
        dto.setFirstname(dto.getFirstname());
        dto.setEmail(dto.getEmail());
        dto.setRole(dto.getRole());
        dto.setLastname(dto.getLastname());
        CredentialsDto.builder().toString();
        CredentialsDto.builder().email("Asd").role("Ada").firstname("asda").lastname("adsa").build();

        RecCredDto doc = new RecCredDto();
        new RecCredDto("asdsa", "Asdasd", "asdasd");
        doc.setEmail(doc.getEmail());
        doc.setFirstname(doc.getFirstname());
        doc.setLastname(doc.getLastname());

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
        PatientInfoDto pat = new PatientInfoDto();
        pat.setFirstname(pat.getFirstname());
        pat.setLastname(pat.getLastname());
        pat.setEmail(pat.getEmail());
        pat.setDob(pat.getDob());
        pat.setNok(pat.getNok());
        pat.setContactNo(pat.getEmContactNo());
        pat.setEmContactNo(pat.getContactNo());
        pat.setPatientId(pat.getPatientId());
        new PatientInfoDto(1, "aasd", "Asda", "Asdasd", "adasd", LocalDate.now(), "Asdad", "Asdasd");

        RoomAllocDto rd = new RoomAllocDto();
        new RoomAllocDto(1, 2, LocalDate.now(), 2);
        rd.setReceptionistId(rd.getReceptionistId());
        rd.setPatientID(rd.getPatientID());
        rd.setRoomId(rd.getRoomId());
        rd.setStartDate(rd.getStartDate());

        AppointmentInfoDto apnt = new AppointmentInfoDto();
        new AppointmentInfoDto(2L, "As,", "Asd", "Asda", 1, "asdas", "Ada"
                , BranchCode.H2, Department.DENTAL, 2L, true, true, LocalDate.now(), true);
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

        ReceptionistInfo rec = new ReceptionistInfo();
        new ReceptionistInfo(1, BranchCode.H2, "asdasd", "Asdasd", "Asdasd");
        rec.setReceptionistId(1);
        rec.setEmail(rec.getEmail());
        rec.setBranchCode(rec.getBranchCode());
        rec.setLastName(rec.getLastName());
        rec.setFirstName(rec.getFirstName());
        System.out.println(rec);

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
    void forMapper() {
        new PatCredMapper();
        PatCredMapper.PatToCred(new PatientInfoDto());
        PatCredMapper.dtoToToken(new CredentialsDto());
    }
	@Test
	void forKafka() {

    sender.regRequest(new CredToken());
	}

}
