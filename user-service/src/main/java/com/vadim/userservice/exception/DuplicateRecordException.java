package com.vadim.userservice.exception;

import lombok.experimental.StandardException;

import java.util.UUID;

import static com.vadim.userservice.util.constants.UserConstants.USER_NOT_FOUND;

@StandardException
public class DuplicateRecordException extends RuntimeException{

    public DuplicateRecordException(String message, String param) {
        super(String.format(message, param));
    }
}
