package org.hms.pharmacist.repository;

import org.hms.pharmacist.entity.PharmaMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmaMedicineRepository extends JpaRepository<PharmaMedicine,Integer> {
    List<PharmaMedicine> findByPharMedNameStartingWith(String name);


    public PharmaMedicine findByPharMedName(String name);
}
