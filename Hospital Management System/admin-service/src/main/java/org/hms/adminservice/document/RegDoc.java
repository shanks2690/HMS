package org.hms.adminservice.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pat_reg_req")
public class RegDoc {
    @Id
    private String email;
    private String firstname;
    private String lastname;
    private String role;
}
