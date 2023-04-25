package com.vrvabeneficios.vrvabeneficios.exception;

public class InvalidCreditCardNumberException extends RuntimeException{

    public InvalidCreditCardNumberException(String message) {
        super(message);
    }
}
