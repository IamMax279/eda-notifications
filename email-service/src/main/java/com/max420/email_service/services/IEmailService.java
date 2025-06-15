package com.max420.email_service.services;

import com.resend.core.exception.ResendException;

public interface IEmailService {
    void sendEmail(String to, String subject, String html);
}
