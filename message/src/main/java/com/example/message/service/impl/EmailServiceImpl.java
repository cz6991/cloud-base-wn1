package com.example.message.service.impl;

import com.example.commonresource.entity.TextEmailEntity;
import com.example.message.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    JavaMailSender javaMailSender;

    public void sendTextMail(TextEmailEntity textEmailEntity){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(textEmailEntity.getTo());
        simpleMailMessage.setSubject("eureka服务通知");
        simpleMailMessage.setText(textEmailEntity.getContent());

        javaMailSender.send(simpleMailMessage);
    }
}
