package org.hms.billing.repository;

import org.hms.billing.entity.Bills;
import org.hms.billing.entity.enums.BranchCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillsRepository extends JpaRepository<Bills,Integer> {

    // find bills using status of bill
    public List<Bills> findAllByBillStatus(boolean status);

    //find all bills using patient id
    public  List<Bills> findAllByPatientId(int patientId);

    //find all bills using patient id
    public Optional<Bills> findByPatientId(int patientId);

    //find all bills using patient id and status of bill
    public  List<Bills> findAllByPatientIdAndBillStatus(int patientId,boolean status);

    public List<Bills> findAllByBranchCode(BranchCode branchCode);

    //find all bills using appointmentId
    public Bills findByAppointmentId(int patientId);


}
