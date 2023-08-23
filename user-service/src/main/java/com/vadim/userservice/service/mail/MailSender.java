package com.vadim.userservice.service.mail;

public interface MailSender {

    void sendMessage(String email, String message, String subject);

    void sendButton(String email, String buttonText, String subject, String URL);
}
