package org.hms.adminservice.kafka;


import lombok.extern.log4j.Log4j2;

import org.hms.CredToken;
import org.hms.adminservice.mapper.PatCredMapper;
import org.hms.adminservice.repository.RegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ReceiveRegRequest {
    @Autowired
RegRepository regRepository;
    private final String topic = "PATREG";
    @KafkaListener(topics = topic, groupId = "ADMINBOX")
    public void consumeMessage(CredToken request) {

        System.out.println("Checking for user name");
        System.out.println(request);
       try{

           if(regRepository.findByEmail(request.getEmail()).isEmpty()) {
               regRepository.save(PatCredMapper.tokenToCred(request));
           }
           }
       catch (Exception e) {
           throw new RuntimeException(e);
       }

    }
}
