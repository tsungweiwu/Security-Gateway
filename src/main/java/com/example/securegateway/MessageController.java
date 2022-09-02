package com.example.securegateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    private final MessageRepository repository;

    MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/message")
    List<SecretMessage> message() {
        return repository.findAll();
    }

    @GetMapping("/test")
    String greeting() {
        return "Hello there";
    }
}
