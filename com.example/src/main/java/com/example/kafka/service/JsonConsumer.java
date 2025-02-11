package com.example.kafka.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.pojo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JsonConsumer {


@KafkaListener(topics = "${spring.kafka.topic.name.json}",groupId = "${spring.kafka.consumer.group-id}")

public void JsonConsumer1(User user){

    log.info(String.format("Json message Received -> %s", user.toString()));
}



}
