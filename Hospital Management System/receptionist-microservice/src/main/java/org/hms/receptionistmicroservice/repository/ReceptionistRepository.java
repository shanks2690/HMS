package org.hms.receptionistmicroservice.repository;

import org.hms.receptionistmicroservice.entity.ReceptionistInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReceptionistRepository extends JpaRepository<ReceptionistInfo, Integer> {
    Optional<ReceptionistInfo> findByEmail(String email);
}
