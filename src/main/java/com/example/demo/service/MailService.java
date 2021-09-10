package com.example.demo.service;

import com.example.demo.domain.MailDomain;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {

    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "parkpark14@naver.com";

    public void mailSend(MailDomain mailDomain) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDomain.getAddress());
        message.setFrom(MailService.FROM_ADDRESS);
        message.setSubject(mailDomain.getTitle());
        message.setText(mailDomain.getMessage());

        mailSender.send(message);
    }

}
