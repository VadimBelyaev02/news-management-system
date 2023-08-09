package com.vadim.newsservice.exception.handler;

import com.vadim.newsservice.exception.NotFoundException;
import com.vadim.newsservice.model.dto.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    //    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiResponseDto<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
//        final ApiResponseDto<?> apiResponseDto = ApiResponseDto.badApiResponse(
//                exception.getMessage(),
//                exception.getBody()
//        );
//        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<ApiResponseDto<?>> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
//        final ApiResponseDto<?> apiResponseDto = ApiResponseDto.badApiResponse(
//                exception.getMessage()
//        );
//        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
//    }
//
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNotFoundException(NotFoundException exception,
                                                                     HttpServletRequest servletRequest) {
        return ApiResponse.notFound(
                exception.getMessage(),
                servletRequest.getServletPath()
        );
    }
//
//    @ExceptionHandler({DuplicateRecordException.class})
//    public ResponseEntity<ApiResponseDto<?>> handleDuplicateRecordException(DuplicateRecordException exception) {
//        final ApiResponseDto<?> apiResponseDto = ApiResponseDto.badApiResponse(
//                exception.getMessage()
//        );
//        return new ResponseEntity<>(apiResponseDto, HttpStatus.CONFLICT);
//    }
}
