package org.hms.receptionistmicroservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hms.receptionistmicroservice.entity.enums.BranchCode;
import org.hms.receptionistmicroservice.entity.enums.Department;


import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentInfoDto {

    private Long patientId;
    private String pEmail;
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
