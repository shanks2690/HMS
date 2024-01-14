package org.hms.billing.repository;

import org.hms.billing.entity.DoctorCharges;
import org.hms.billing.entity.enums.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorChargesRepository extends JpaRepository<DoctorCharges,Integer> {

    public DoctorCharges findByDeptCode(Department department);
}
