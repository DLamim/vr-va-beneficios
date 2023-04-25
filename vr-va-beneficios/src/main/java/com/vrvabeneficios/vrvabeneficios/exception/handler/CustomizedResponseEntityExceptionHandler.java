package com.vrvabeneficios.vrvabeneficios.exception.handler;

import com.vrvabeneficios.vrvabeneficios.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Void> handleResourceNotFoundExceptions(WebRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCreditCardNumberException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidCreditCardNumberException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidPasswordException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public final ResponseEntity<ExceptionResponse> handleInsufficientBalanceException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public final ResponseEntity<ExceptionResponse> handleResourceAlreadyExistsException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                ex.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
