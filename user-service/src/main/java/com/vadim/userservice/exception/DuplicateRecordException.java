package com.vadim.userservice.exception;

import lombok.experimental.StandardException;
public class DuplicateRecordException extends RuntimeException{

    public DuplicateRecordException(String message, String param) {
        super(String.format(message, param));
    }

    public DuplicateRecordException() {
        super();
    }

    public DuplicateRecordException(String message) {
        super(message);
    }
}
