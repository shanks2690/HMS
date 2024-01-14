package org.hms.billing.service;

import org.hms.billing.entity.RoomCharges;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomChargesServiceI {
    // Get all Room Charges
    public List<RoomCharges> allRoomCharges();

    // Get all Room Charges by Code
    public RoomCharges getRoomByCode(String code);

    // add new RoomCharges
    public RoomCharges addRoomCharges(RoomCharges roomCharges);

    // update RoomCharges
    public RoomCharges updateRoomCharges(RoomCharges roomCharges);

    // delete RoomCharges
    public String deleteRoomCharges(int rcId);
}
