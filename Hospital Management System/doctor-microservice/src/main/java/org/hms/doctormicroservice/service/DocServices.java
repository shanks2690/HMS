package org.hms.doctormicroservice.service;


import org.hms.doctormicroservice.dto.DocCredDto;
import org.hms.doctormicroservice.dto.DocDepDto;
import org.hms.doctormicroservice.dto.PatientHealthRecDto;
import org.hms.doctormicroservice.dto.PrescriptionDto;
import org.hms.doctormicroservice.entity.DoctorInfo;

import java.util.List;

public interface DocServices {
DoctorInfo getDoc(String userName);
  String  delDoc(String userName);

DoctorInfo updateInfo(DoctorInfo updatedInfo, String userName);
DoctorInfo showMyInfo(Integer docId);

Boolean addNewDoc(DocCredDto docCredDto);
List<DocDepDto> getAllDocs();

PatientHealthRecDto addHealthRec(PatientHealthRecDto patientHealthRecDto);
}
