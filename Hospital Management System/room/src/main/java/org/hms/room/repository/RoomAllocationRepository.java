package org.hms.room.repository;

import org.hms.room.entity.RoomAllocation;
import org.hms.room.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomAllocationRepository extends JpaRepository<RoomAllocation, Integer> {

    public List<RoomAllocation> findByRoomIdAndOccupation(RoomType roomId, boolean occupation);

    public RoomAllocation findByPatientIdAndOccupation(int patientId, boolean occupation);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE room_allocation_tb u SET u.occupation = ?1, u.end_date=?2 WHERE u.patient_Id = ?3", nativeQuery = true)
    public void updateOccupation(boolean status,  LocalDate enddate,int patientId);
}
