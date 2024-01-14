package org.hms.pharmacist.repository;

import org.hms.pharmacist.entity.Pharma;
import org.hms.pharmacist.entity.PharmaCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PharmaRepository extends JpaRepository<Pharma,Integer> {

    public Optional<Pharma> findOneByPharEmailIgnoreCase(String email);

   // public Boolean deleteAllByPharEmail(String email);

}
