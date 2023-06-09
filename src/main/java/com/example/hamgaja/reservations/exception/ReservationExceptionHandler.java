package com.example.hamgaja.reservations.exception;

import com.example.hamgaja.message.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ReservationExceptionHandler {

    @ExceptionHandler(value = { ReservationException.class })
    protected ResponseEntity<ResponseMessage> handleCustomException(ReservationException e) {
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        return ResponseMessage.ErrorResponse(e.getErrorCode());
    }
}
