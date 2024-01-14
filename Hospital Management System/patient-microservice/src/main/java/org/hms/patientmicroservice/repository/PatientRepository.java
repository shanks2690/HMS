package org.hms.patientmicroservice.repository;

import org.hms.patientmicroservice.entity.PatientInfo;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PatientRepository extends JpaRepository<PatientInfo,Integer> {
    PatientInfo findByEmail(String email);
    PatientInfo deleteByEmail(String email);
}
