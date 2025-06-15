package com.max420.email_service.services.impl;

import com.max420.email_service.services.IEmailService;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {
    @Value("${email.domain}")
    private String sender;
    private final Resend resend;

    public EmailService(Resend resend) {
        this.resend = resend;
    }

    @Override
    public void sendEmail(String to, String subject, String html) {
        CreateEmailOptions params = new CreateEmailOptions.Builder()
                .from(sender)
                .to(to)
                .subject(subject)
                .html(html)
                .build();

        try {
            CreateEmailResponse data = resend.emails().send(params);
            System.out.println("id: " + data.getId());
        } catch (ResendException e) {
            e.printStackTrace();
        }
    }
}
