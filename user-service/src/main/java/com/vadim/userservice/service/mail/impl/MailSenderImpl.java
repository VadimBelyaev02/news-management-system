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

import static com.vadim.userservice.util.constants.Html.getHtmlForm;

@RequiredArgsConstructor
@Service
public class MailSenderImpl implements MailSender {

    private final JavaMailSender mailSender;

    @Override
    public void sendTextMessage(String email, String message, String subject) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setText(message);
        mailMessage.setSubject(subject);

        mailSender.send(mailMessage);
    }

    @Override
    public void sendConfirmationButton(String email, String subject, String code) {
        String URL = "localhost:8765/user-service/api/auth/register/confirm?code=" + code;
        String text = getHtmlForm(subject, URL);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, false, "UTF-8");
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setText(text, true);
            mimeMessageHelper.setSubject(subject);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new MailSendingException("Can't send an email. Error: " + e.getMessage());
        }
    }
}
