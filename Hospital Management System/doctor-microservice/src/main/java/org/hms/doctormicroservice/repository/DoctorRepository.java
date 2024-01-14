package org.hms.doctormicroservice.repository;

import org.hms.doctormicroservice.entity.DoctorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorInfo,Integer> {
    DoctorInfo findByEmail(String userName);

    void deleteByEmail(String userName);
}
