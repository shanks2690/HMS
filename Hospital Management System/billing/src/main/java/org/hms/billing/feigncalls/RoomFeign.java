package org.hms.billing.feigncalls;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.hms.billing.dto.RoomAllocation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name= "ROOM")
public interface RoomFeign {

    // get room Active booked against patientId
    // this will return
    @PostMapping("/room/patroomact")
    @Operation(summary = "It will show room allocation in room allocation table for given patient")
    public RoomAllocation getActiveAllocations(@RequestBody Integer patientId);

    // End booking for given Patient
    @PutMapping("room/endroombooking")
    @Operation(summary = "Update Room Allocation table for given Patient Id for ending its occupancy")
    public Boolean endRoomOccupancy(@Parameter(description = "Update Room Allocation Status", required = true) @RequestBody Integer patientId);


}
