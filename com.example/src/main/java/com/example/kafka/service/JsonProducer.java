package com.example.kafka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;

import org.springframework.stereotype.Service;

import com.example.kafka.pojo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JsonProducer {
    @Value("${spring.kafka.topic.name.json}")
    private String topic;

    private final KafkaTemplate<String, User> kafkaTemplate;

    public JsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJson(User data) {
        log.info(String.format("Message sent -> %s", data.toString()));
        org.springframework.messaging.Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        kafkaTemplate.send(message);
    }
}
