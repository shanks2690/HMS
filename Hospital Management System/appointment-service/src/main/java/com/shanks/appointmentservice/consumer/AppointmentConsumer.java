package com.shanks.appointmentservice.consumer;

import com.shanks.appointmentservice.entity.Identity;
import com.shanks.appointmentservice.service.MailRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.shanks.MailBoxObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2

@Service
@AllArgsConstructor
public class AppointmentConsumer {

    MailRequestService mailRequestService;
    private final String topic = "DOCTOR1";
    private static int i = 0;

    @KafkaListener(topics = topic, groupId = "appointment")
    public void consumeMessage(MailBoxObject message) {

        Identity id = new Identity();
        id.setPid("dummy");
        if (id.getPid().equals(message.pname))
            if (message.approval) {

                try {
                    mailRequestService.sendMail(message);
                    log.info("Your appointment has been confirmed");


                } catch (Exception e) {
                    log.info("Mailing Services are down at the moment");

                }
            }
    }
}
