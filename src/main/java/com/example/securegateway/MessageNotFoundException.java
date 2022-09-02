package com.example.securegateway;

public class MessageNotFoundException extends RuntimeException {
    MessageNotFoundException() {
        super("Could not find message");
    }
}
