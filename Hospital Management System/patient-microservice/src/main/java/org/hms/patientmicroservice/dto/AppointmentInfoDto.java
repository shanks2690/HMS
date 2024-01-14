package org.hms.patientmicroservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hms.patientmicroservice.entity.enums.BranchCode;
import org.hms.patientmicroservice.entity.enums.Department;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentInfoDto {

	private int patientId;
    private String pEmail;
    private String patFname;
    private String patLname;
    private int docId;
    private String docFname;
    private String docLname;
    private Department department;
    private BranchCode branchCode;
    private Long slotId;
	private Boolean approval;
    private Boolean emergency;
    private LocalDate date;
    private Boolean Status;
}
