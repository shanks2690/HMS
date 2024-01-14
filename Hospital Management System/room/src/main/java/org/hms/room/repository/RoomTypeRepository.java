package org.hms.room.repository;

import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.QueryHints;
import org.hms.room.dto.RoomAvailabilityDto;
import org.hms.room.entity.RoomType;
import org.hms.room.entity.enums.BranchCode;
import org.hms.room.entity.enums.RoomCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {

   public List<RoomType> findAllByRoomCode(RoomCode roomCode);

   public RoomType findByRoomCodeAndBranchCode(RoomCode roomCode, BranchCode branchCode);

   public RoomType findByRoomId(int roomId);

   @Procedure(name = "SPRoomAvailabilityByBranchCode")
   public List<Object[]> SPRoomAvailabilityByBranchCode(@Param("user_input_branch_code") String branchCode);


   @Query(value = "Select * from RoomsAvailableAllBranchView",nativeQuery = true)
   public List<Object[]> GetAllRoomInAllBranches();


}
