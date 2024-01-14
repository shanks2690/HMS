package org.hms.patientmicroservice.exception.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
private String message;
private Boolean success;
private HttpStatus status;
}
