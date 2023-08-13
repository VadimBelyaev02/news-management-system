package com.vadim.userservice.exception;

import lombok.experimental.StandardException;

import java.util.UUID;

@StandardException
public class RecordNotFoundException extends RuntimeException {


    public RecordNotFoundException(UUID id) {
        super();
    }
}
