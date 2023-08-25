package com.vadim.userservice.service.mail;

public interface MailSender {

    void sendTextMessage(String email, String message, String subject);

    void sendConfirmationButton(String email, String subject, String code);
}
