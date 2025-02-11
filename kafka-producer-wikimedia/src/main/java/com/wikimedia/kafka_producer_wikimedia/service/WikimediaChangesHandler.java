package com.wikimedia.kafka_producer_wikimedia.service;

import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

import lombok.extern.slf4j.Slf4j;
@Slf4j

public class WikimediaChangesHandler implements EventHandler {
    private String topic;
    private KafkaTemplate<String,String> kafkaTemplate;


    public WikimediaChangesHandler(String topic, KafkaTemplate<String, String> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void onOpen() throws Exception {
        // Add your code here
    }

    @Override
    public void onClosed() throws Exception {
        // Add your code here
    }

    @Override
    public void onMessage(String event, MessageEvent messageEvent) throws Exception {

        log.info(String.format("Event Data -> %s", messageEvent.getData()));
        kafkaTemplate.send(topic,messageEvent.getData());
        
        // Add your code here
    }

    @Override
    public void onComment(String comment) throws Exception {
        // Add your code here
    }

    @Override
    public void onError(Throwable t) {
        // Add your code here
    }
}
