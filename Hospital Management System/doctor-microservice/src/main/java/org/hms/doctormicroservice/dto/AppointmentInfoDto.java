package org.hms.doctormicroservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hms.doctormicroservice.entity.enums.BranchCode;
import org.hms.doctormicroservice.entity.enums.Department;



import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentInfoDto {

    private int appointmentId;
    private String pEmail;
	private Long patientId;
    private String patFname;
    private String patLname;
    private int docId;
    private String docFname;
    private String docLname;
    private BranchCode branchCode;
    private Department department;
    private Long slotId;
	private Boolean approval;
    private Boolean emergency;
    private LocalDate date;
    private Boolean Status;
}
