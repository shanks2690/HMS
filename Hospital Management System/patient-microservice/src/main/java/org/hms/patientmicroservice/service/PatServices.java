package org.hms.patientmicroservice.service;


import org.hms.patientmicroservice.dto.AppointmentInfoDto;
import org.hms.patientmicroservice.dto.CredentialsDto;
import org.hms.patientmicroservice.dto.PatCredDto;
import org.hms.patientmicroservice.entity.PatientInfo;


public interface PatServices {

PatientInfo updateMyInfo(PatientInfo updatedInfo, String userName);
PatientInfo showMyInfo(String email);
Boolean addNewPat(PatCredDto patCredDto);
String delPat(String email);

PatientInfo addPat(CredentialsDto credentialsDto);


}
