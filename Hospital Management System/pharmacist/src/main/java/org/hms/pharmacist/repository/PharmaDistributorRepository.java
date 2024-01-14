package org.hms.pharmacist.repository;

import org.hms.pharmacist.entity.PharmaDistributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmaDistributorRepository extends JpaRepository<PharmaDistributor,Integer> {
    public List<PharmaDistributor> findByPharDistFirstNameStartingWith(String name);

}
