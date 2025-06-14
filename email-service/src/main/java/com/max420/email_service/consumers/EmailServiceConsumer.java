package com.max420.email_service.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceConsumer {
    private static final String QUEUE_NAME = "user_registered";

    @RabbitListener(queues = {"user_registered"})
    public void handleUserCreatedMessage(String message) {
        System.out.println("Message received: " + message);

        //TODO: further email logic
    }
}
