package org.hms.adminservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PasswordChange {

private String newPwd1;
private String newPwd2;
private String email;
}
