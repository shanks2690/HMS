package org.hms.billing.repository;

import org.hms.billing.entity.RoomCharges;
import org.hms.billing.entity.enums.RoomCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomChargesRepository extends JpaRepository<RoomCharges,Integer> {


    public RoomCharges findByRoomCode(RoomCode roomCode);


}
