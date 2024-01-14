package org.hms.prescriptionservice.repository;

import org.hms.prescriptionservice.entity.Prescription;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrescriptionRepository extends MongoRepository<Prescription,Integer> {

    List<Prescription> findByPatientId(int patientId);

    List<Prescription> findByDocId(int docId);
}
