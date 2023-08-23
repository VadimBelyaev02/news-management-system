package com.vadim.userservice.service.mail.impl;

import com.vadim.userservice.exception.MailSendingException;
import com.vadim.userservice.service.mail.MailSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailSenderImpl implements MailSender {

    private final JavaMailSender mailSender;

    @Override
    public void sendMessage(String email, String message, String subject) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setText(message);
        mailMessage.setSubject(subject);

        mailSender.send(mailMessage);
    }

    @Override
    public void sendButton(String email, String buttonText, String subject, String code) {
        String URL = "localhost:8765/api/confirm-registration?code=" + code;

        String text = "<html>" +
                "<head><title>" + subject + "</title></head>" +
                "<body>" +
                "<form method=\"post\" action=\"" + URL + "\">" +
                "<input type=\"submit\" value=\"Confirm\">" +
                "</form>" +
                "</body>" +
                "</html>";

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, false, "UTF-8");
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setText(text);
            mimeMessageHelper.setSubject(subject);
        } catch (MessagingException e) {
            throw new MailSendingException("Can't send an email. Error: " + e.getMessage());
        }
    }
}
