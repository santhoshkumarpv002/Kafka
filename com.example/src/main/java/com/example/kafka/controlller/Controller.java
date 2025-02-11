package com.example.kafka.controlller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.kafka.service.*;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class Controller {

    private ServiceProducer service;

    @GetMapping("/{post}")
    public ResponseEntity<String> post(@PathVariable String post) {
        System.out.println(post);

        String value = service.post(post);

        return ResponseEntity.ok(value);

    }
}
