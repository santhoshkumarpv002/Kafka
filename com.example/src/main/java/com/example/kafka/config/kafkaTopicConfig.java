package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topic1;

    // create a new topic
    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name(topic1)
                // .partitions(0) we can set number of partition here
                .build();
    }

    @Value("${spring.kafka.topic.name.json}")
    private String topic2;

    // for json topic
    @Bean
    public NewTopic jsonTopic() {
        return TopicBuilder.name(topic2)
                // .partitions(0) we can set number of partition here
                .build();
    }

}
