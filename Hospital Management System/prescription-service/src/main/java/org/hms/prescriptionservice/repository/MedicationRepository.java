package org.hms.prescriptionservice.repository;

import org.hms.prescriptionservice.entity.Medications;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MedicationRepository extends MongoRepository<Medications,Integer> {
}
