package org.hms.prescriptionservice.mapper;

import org.hms.prescriptionservice.dto.PrescriptionDto;
import org.hms.prescriptionservice.entity.Medications;
import org.hms.prescriptionservice.entity.PhysicalDetails;
import org.hms.prescriptionservice.entity.Prescription;
import org.hms.prescriptionservice.entity.enums.BranchCode;

import java.time.LocalDate;
import java.util.List;

public class PrscMapper {

    public static Prescription dtoToPrsc(PrescriptionDto dto)
    {
        Prescription prescription = new Prescription();
        prescription.setAppointmentId(dto.getAppointmentId());
        prescription.setMedications(dto.getMedications());
        prescription.setAdmission(dto.getAdmission());
        prescription.setDocId(dto.getDocId());
        prescription.setAdvice(dto.getAdvice());
        prescription.setBranchCode(dto.getBranchCode());
        prescription.setComplaints(dto.getComplaints());
        prescription.setDiagnosis(dto.getDiagnosis());
        prescription.setDocName(dto.getDocName());
        prescription.setDocRegdNo(dto.getDocRegdNo());
        prescription.setFindings(dto.getFindings());
        prescription.setDocQual(dto.getDocQual());
        prescription.setPrescriptionDate(dto.getPrescriptionDate());
        prescription.setPhysicalDetails(dto.getPhysicalDetails());
        prescription.setPatientId(dto.getPatientId());
        prescription.setDocName(dto.getDocName());
        prescription.setPatientName(dto.getPatientName());
        prescription.setEmergency(dto.getEmergency());
        prescription.setDepartment(dto.getDepartment());
        return prescription;
    }
}
