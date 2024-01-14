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
public class SimpleMail {

    private String from;
    private String to;
    private String body;
    private String sub;
}
