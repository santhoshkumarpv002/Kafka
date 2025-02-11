package com.wikimedia.kafka_producer_wikimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wikimedia.kafka_producer_wikimedia.service.WikimediaChangesProducer;

@SpringBootApplication
public class KafkaProducerWikimediaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerWikimediaApplication.class, args);
	}
	@Autowired
private WikimediaChangesProducer wikimediaChangesProducer;
	@Override
	public void run(String... args) throws Exception {
	wikimediaChangesProducer.postChanges();
		
	
	}

}
