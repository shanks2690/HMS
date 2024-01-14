package org.hms.receptionistmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PasswordChange {

private String newPwd1;
private String newPwd2;
private String email;
}
