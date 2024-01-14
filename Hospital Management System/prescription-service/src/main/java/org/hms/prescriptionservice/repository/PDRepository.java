package org.hms.prescriptionservice.repository;

import org.hms.prescriptionservice.entity.PhysicalDetails;
import org.hms.prescriptionservice.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PDRepository extends JpaRepository<PhysicalDetails,Integer> {
}
