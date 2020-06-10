package com.example.fishFarm.services;

import com.example.fishFarm.models.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;
    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }

    public void sendNotification(SystemUser user) throws MailException {

        SimpleMailMessage mail= new SimpleMailMessage();

        mail.setTo(user.getEmail());
        mail.setFrom("zackogoma@gmail.com");
        mail.setSubject("Notification from inventory department");
        mail.setText("This is to inform you that new feed has been added");

            javaMailSender.send(mail);
    }


}
