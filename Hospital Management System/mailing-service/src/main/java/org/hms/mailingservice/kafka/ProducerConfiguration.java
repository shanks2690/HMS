package org.hms.mailingservice.kafka;



import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class ProducerConfiguration {

    @Bean
    public NewTopic newTopic1() {
        return TopicBuilder.name("DOCRED").build();
    }

    @Bean
    public NewTopic newTopic2() {
        return TopicBuilder.name("PATCRED").build();
    }

    @Bean
    public NewTopic newTopic3() {
        return TopicBuilder.name("RECRED").build();
    }

    @Bean
    public NewTopic newTopic4() {
        return TopicBuilder.name("PHARCRED").build();
    }
}
