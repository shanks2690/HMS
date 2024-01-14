package com.shanks.appointmentservice.repository;

import com.shanks.appointmentservice.entity.AppointmentSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SlotRepository extends JpaRepository<AppointmentSlot,Long> {

    List<AppointmentSlot> findByDocId(int docId);
}
