package com.example.securegateway;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<SecretMessage, Long> {
}
