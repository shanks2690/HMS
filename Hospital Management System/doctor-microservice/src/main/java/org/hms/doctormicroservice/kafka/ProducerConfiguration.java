package org.hms.doctormicroservice.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class ProducerConfiguration {

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name("DOCTOR1").build();
    }
}
