package com.kafka.kafka_consumer_database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.kafka_consumer_database.entity.Wiki;

public interface WikiRepository  extends JpaRepository<Wiki,Long>{
     
}
