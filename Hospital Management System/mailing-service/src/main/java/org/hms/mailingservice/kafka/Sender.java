package org.hms.mailingservice.kafka;



import org.hms.CredToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class Sender {
CredToken credToken;

    private final String topic = "DOCTOR";
    @Autowired
    private KafkaTemplate<String, CredToken> kafkaTemplate;

    public void sendToDoc(CredToken message) {

        kafkaTemplate.send("DOCRED", message);
    }

    public void sendToPat(CredToken message) {

        kafkaTemplate.send("PATCRED", message);
    }
    public void sendToRec(CredToken message) {

        kafkaTemplate.send("RECRED", message);
    }
    public void sendToPhar(CredToken message) {

        kafkaTemplate.send("PHARCRED", message);
    }
}
