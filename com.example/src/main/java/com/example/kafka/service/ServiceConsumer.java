package com.example.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServiceConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer1(String message) {

        log.info(String.format("message received from Consumer1-> %s", message));
    }

    @KafkaListener(topics="${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void  consumer2(String message){
     
        log.info(String.format("message received from Consumer2 -> %s", message));
    

}
}
