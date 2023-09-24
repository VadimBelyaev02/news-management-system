package com.vadim.grpcservice.service;

import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;

import java.time.Instant;

@GrpcAdvice
public class GrpcExceptionHandler {

//    @GrpcExceptionHandler(Exception.class)
//    public StatusRuntimeException handleValidationError(Exception cause) {
//
//
//        return null;
//    }
}
