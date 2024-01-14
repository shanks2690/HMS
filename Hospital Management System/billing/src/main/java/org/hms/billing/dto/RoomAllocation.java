package org.hms.billing.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomAllocation {

    private int allocationId;

    private RoomType roomId;

    private int patientId;

    private int receptionistId;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean occupation;
}
