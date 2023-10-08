package com.vadim.newsservice.service;

public interface AuthenticationService {

    boolean canDeleteComment(String username, String token);

    boolean canModifyComment(String username, String token);

    boolean canCreateComments(String token);

    boolean canDeleteNews(String username, String token);

    boolean canModifyNews(String username, String token);

    boolean canCreateNews(String token);
}
