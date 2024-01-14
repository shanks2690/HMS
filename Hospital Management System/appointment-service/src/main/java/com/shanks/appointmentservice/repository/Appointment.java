package com.shanks.appointmentservice.repository;
import com.shanks.appointmentservice.entity.AppointmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Appointment extends JpaRepository<AppointmentInfo,Integer> {

    List<AppointmentInfo> findByDocId(int docId);
}
