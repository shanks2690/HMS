package com.shanks.appointmentservice.appointmentrequest;


import org.shanks.MailBoxObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class SendRequest {

MailBoxObject mailBoxObject;
    private final String topic = "request";

    @Autowired
    private KafkaTemplate<String, MailBoxObject> kafkaTemplate;

    public void sendMessage(MailBoxObject message) {

        kafkaTemplate.send(topic, message);
    }
}
