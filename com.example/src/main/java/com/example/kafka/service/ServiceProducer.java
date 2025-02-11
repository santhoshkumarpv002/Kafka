package com.example.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class ServiceProducer {
    // we need kafka templete to post msg on topic
@Value("${spring.kafka.topic.name}")
    private String topic;
@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String post(String msg) {
        log.info(String.format("Message sent %s", msg));
        kafkaTemplate.send(topic, msg);

        return msg;

    }

}
