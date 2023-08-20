package com.googledrive.notificationservice.Service;

import org.springframework.stereotype.Service;

import com.googledrive.notificationservice.Entity.EmailRequest;

public interface EmailSenderService {
    void sendEmail(EmailRequest emailRequest);
}
