package org.hms.mailingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SimpleMail {

    private String from;
    private String to;
    private String body;
    private String sub;
}
