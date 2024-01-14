package org.hms.mailingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MailBody {

    private String from;
    private String to;
    private String body;
    private List<FileName> files;
    private String sub;
}
