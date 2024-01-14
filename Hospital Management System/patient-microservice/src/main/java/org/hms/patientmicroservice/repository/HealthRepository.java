package org.hms.patientmicroservice.repository;

import org.hms.patientmicroservice.entity.PatientHealthRec;


import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface HealthRepository extends JpaRepository<PatientHealthRec,Integer> {
    List<PatientHealthRec> findByEmail(String email);
}
