package org.hms.pharmacist.repository;

import org.hms.pharmacist.entity.PharmaCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmaCompanyRepository extends JpaRepository<PharmaCompany,Integer> {

    public List<PharmaCompany> findByPharCompanyNameStartingWith(String name);

}
