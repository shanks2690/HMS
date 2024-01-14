package org.hms.room.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="room_allocation_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description ="Room Allocation Class")
public class RoomAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int allocationId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomType roomId;

    private int patientId;

    private int receptionistId;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean occupation;
}
