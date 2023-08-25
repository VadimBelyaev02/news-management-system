package com.vadim.userservice.exception;

import lombok.experimental.StandardException;

import java.util.UUID;

import static com.vadim.userservice.util.constants.UserConstants.USER_NOT_FOUND_BY_ID;

//@StandardException
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UUID userId) {
        super(String.format(USER_NOT_FOUND_BY_ID, userId));
    }

    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException(String message, String param) {
        super(String.format(message, param));
    }
}
