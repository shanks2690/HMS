package org.hms.doctormicroservice.kafka;


import lombok.extern.log4j.Log4j2;
import org.shanks.AppointmentRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ReceiveRequest {

    private final String topic = "request";
    private String did="santa";
    @KafkaListener(topics = topic, groupId = "doctor")
    public void consumeMessage(AppointmentRequest request) {

                log.info("You have an appointment request from :"+request.getPatientName());
    }

}
