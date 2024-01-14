package org.hms.receptionistmicroservice.dto;


import lombok.*;


import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomAllocDto {
    private int patientID;
    private int receptionistId;
    private LocalDate startDate;
    private int roomId;
}
