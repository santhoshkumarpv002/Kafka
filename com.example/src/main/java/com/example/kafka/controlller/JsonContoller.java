package com.example.kafka.controlller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.pojo.User;
import com.example.kafka.service.JsonProducer;

@RestController
public class JsonContoller {

   private JsonProducer jsonproducer;

    public JsonContoller(JsonProducer jsonproducer) {
        this.jsonproducer = jsonproducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonproducer.sendJson(user);
        return ResponseEntity.ok("JSON message sent to Kafka topic");
    }

}
