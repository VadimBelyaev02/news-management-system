package com.vadim.userservice.exception.handler;

import com.vadim.userservice.exception.AccessDeniedException;
import com.vadim.userservice.exception.DuplicateRecordException;
import com.vadim.userservice.exception.MailSendingException;
import com.vadim.userservice.exception.RecordNotFoundException;
import com.vadim.userservice.model.dto.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                                     HttpServletRequest servletRequest) {
        return ApiResponse.badRequest(
                exception.getMessage(),
                servletRequest.getServletPath()
        );
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNotFoundException(RecordNotFoundException exception,
                                                                     HttpServletRequest servletRequest) {
        return ApiResponse.notFound(
                exception.getMessage(),
                servletRequest.getServletPath()
        );
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<Void>> handleAccessDeniedException(AccessDeniedException exception,
                                                                     HttpServletRequest servletRequest) {
        return ApiResponse.forbidden(
                exception.getMessage(),
                servletRequest.getServletPath()
        );
    }

    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<ApiResponse<Void>> handleDuplicateRecordException(DuplicateRecordException exception,
                                                                     HttpServletRequest servletRequest) {
        return ApiResponse.badRequest(
                exception.getMessage(),
                servletRequest.getServletPath()
        );
    }



    @ExceptionHandler({MailSendingException.class})
    public ResponseEntity<ApiResponse<Object>> handleDuplicateRecordException(MailSendingException exception, HttpServletRequest servletRequest) {
        return ApiResponse.badRequest(
                exception.getMessage(),
                servletRequest.getServletPath()
        );
    }
}
