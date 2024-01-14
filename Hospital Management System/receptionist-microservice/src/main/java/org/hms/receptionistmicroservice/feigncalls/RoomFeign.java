package org.hms.receptionistmicroservice.feigncalls;


import org.hms.receptionistmicroservice.dto.RoomAllocDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;



@FeignClient(name="ROOM")
public interface RoomFeign {

    @PostMapping("room/book")
     ResponseEntity<?> bookRoom(RoomAllocDto roomAllocDto);
}
