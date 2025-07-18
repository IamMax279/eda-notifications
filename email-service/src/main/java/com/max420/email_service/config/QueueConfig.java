package com.max420.email_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    @Bean
    public Queue userRegisteredQueue() {
        return new Queue("user_registered", true);
    }
}
