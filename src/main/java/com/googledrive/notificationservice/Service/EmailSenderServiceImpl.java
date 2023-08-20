package com.googledrive.notificationservice.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.googledrive.notificationservice.Entity.EmailRequest;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{
    private final JavaMailSender mailSender;
    public EmailSenderServiceImpl(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }
    @Override
    public void sendEmail(EmailRequest emailRequest) {
        // TODO Auto-generated method stub
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("notificationservicefilesharing@gmail.com");
        simpleMailMessage.setTo(emailRequest.getEmail());
        simpleMailMessage.setSubject(emailRequest.getSubject());
        simpleMailMessage.setText(emailRequest.getBody());
        this.mailSender.send(simpleMailMessage);
    }
    
}
