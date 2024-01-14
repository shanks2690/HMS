package org.hms.doctormicroservice.kafka;

import org.shanks.AppointmentRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class Sender {

    private final String topic = "DOCTOR";
    @Autowired
    private KafkaTemplate<String, AppointmentRequest> kafkaTemplate;

    public void sendMessage(AppointmentRequest message) {
        kafkaTemplate.send(topic, message);
    }
}
