package com.googledrive.notificationservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.googledrive.notificationservice.Entity.EmailRequest;
import com.googledrive.notificationservice.Service.EmailSenderService;

@RestController
@RequestMapping("/notifications")
public class EmailController {
    @Autowired
    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService){
        this.emailSenderService = emailSenderService;
    }
    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest){
        System.out.println(emailRequest.getEmail() + emailRequest.getBody() + emailRequest.getSubject());
        emailSenderService.sendEmail(emailRequest);
        return new ResponseEntity<String>("email sent", HttpStatus.OK);
    }
}
