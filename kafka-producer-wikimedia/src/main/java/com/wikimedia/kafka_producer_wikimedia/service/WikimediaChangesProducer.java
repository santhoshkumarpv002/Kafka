package com.wikimedia.kafka_producer_wikimedia.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WikimediaChangesProducer {

    @Autowired  
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.topic.name}")
    private String topic;
  

    public void postChanges() throws InterruptedException {

        // Read real-time stream data from Wikimedia
        EventHandler eventHandler = new WikimediaChangesHandler(topic, kafkaTemplate);
        String URL = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(URL));
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep((60*24)); //collect data only for 10 minutes

        eventSource.close();
    }
}
