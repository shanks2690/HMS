package org.hms.receptionistmicroservice.kafka;


import org.hms.CredToken;
import org.hms.receptionistmicroservice.dto.CredentialsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class Sender {
CredToken credToken;

    private final String topic = "PATREG";
    @Autowired
    private KafkaTemplate<String, CredToken> kafkaTemplate;

    public void regRequest(CredToken message) {
        System.out.println(message);
        kafkaTemplate.send("PATREG", message);
    }


}
