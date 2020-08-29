package com.example.fishFarm.controllers;

import com.example.fishFarm.models.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class SmtpTestingClass{

    @Autowired
    private SmtpMailSender smtpMailSender;

    @RequestMapping("/send-mail")
    public void sendMail() throws MessagingException{
        smtpMailSender.send("kevineoyanda20@gmail.com","Testing from Spring","Hope its working");
    }

}
