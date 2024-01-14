package org.hms.billing.service;

import org.hms.billing.entity.RoomCharges;
import org.hms.billing.entity.enums.RoomCode;
import org.hms.billing.repository.RoomChargesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RoomChargesService implements RoomChargesServiceI {

    @Autowired
    RoomChargesRepository repository;

    //get all
    public List<RoomCharges> allRoomCharges() {

        try {
            return repository.findAll();

        } catch (Exception e) {
            return Collections.emptyList();
        }

    }

    // get by name
    public RoomCharges getRoomByCode(String code) {
        try {
            return repository.findByRoomCode(RoomCode.valueOf(code));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // add
    public RoomCharges addRoomCharges(RoomCharges roomCharges) {
        try {
            return repository.save(roomCharges);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // update

    public RoomCharges updateRoomCharges(RoomCharges roomCharges) {
        try {
            RoomCharges fetchCharges = repository.findById(roomCharges.getRcId()).orElseThrow(RuntimeException::new);

            roomCharges.setRcId(fetchCharges.getRcId());
            roomCharges.setRoomCode(roomCharges.getRoomCode() == null ? fetchCharges.getRoomCode() : roomCharges.getRoomCode());
            roomCharges.setPrice(roomCharges.getPrice() == 0.0 ? fetchCharges.getPrice() : roomCharges.getPrice());
            roomCharges.setEmergencyPrice(roomCharges.getEmergencyPrice() == 0.0 ? fetchCharges.getEmergencyPrice() : roomCharges.getEmergencyPrice());
            return repository.save(roomCharges);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //delete
    public String deleteRoomCharges(int rcId) {
        try {
            repository.deleteById(rcId);
            return "Deleted";
        } catch (Exception e) {
            return "Error deleting";

        }
    }

}
