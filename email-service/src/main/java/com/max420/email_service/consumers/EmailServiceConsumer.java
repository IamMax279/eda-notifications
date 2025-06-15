package com.max420.email_service.consumers;

import com.max420.email_service.services.impl.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceConsumer {
    private final EmailService emailService;

    public EmailServiceConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = {"user_registered"})
    public void handleUserCreatedMessage(String message) {
        System.out.println("Message received: " + message);
        String[] msg = message.split(",");
        String email = msg[0];

        emailService.sendEmail(email, "Account creation", "<p>Account has been created.</p>");
    }
}
