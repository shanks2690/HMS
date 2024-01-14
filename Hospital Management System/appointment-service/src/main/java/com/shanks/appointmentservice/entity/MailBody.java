package com.shanks.appointmentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MailBody {

    private String from;
    private String to;
    private String body;
    private List<FileName> files;
    private String sub;
}
