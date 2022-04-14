package com.tindev.apicontato.service;

import com.tindev.apicontato.dto.contato.ContatoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String tindev_mail;

    private final JavaMailSender emailSender;

    public void sendSimpleMessage(String email, String assunto, String mensagem) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(tindev_mail);
        message.setTo(tindev_mail);
        message.setSubject(assunto + " - " + email);
        message.setText(mensagem);
        emailSender.send(message);
    }

    public void sendEmail(ContatoDTO contatoDTO)  {
        sendSimpleMessage(contatoDTO.getEmail(), contatoDTO.getAssunto(), contatoDTO.getMensagem());
    }


}
