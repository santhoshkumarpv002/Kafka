package com.kafka.kafka_consumer_database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.kafka_consumer_database.entity.Wiki;
import com.kafka.kafka_consumer_database.repository.WikiRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumer {
@Autowired
    private WikiRepository wikiRepository;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventmsg) {
        log.info(String.format("Data consumed -> %s", eventmsg));
        Wiki wiki=new Wiki();
        wiki.setEventData(eventmsg);
        wikiRepository.save(wiki);

    }

}
