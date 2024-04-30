package com.example.messaging.rabbitmq.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.messaging.rabbitmq.dto.Item;
import com.example.messaging.rabbitmq.producer.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class ItemController {

	private RabbitMQJsonProducer jsonProducer;

    public ItemController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Item item){
        jsonProducer.sendJsonMessage(item);
        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }
}
