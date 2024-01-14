package org.hms.doctormicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor
@Data
public class DocLogin {
    private String username;
    private String password;
}
