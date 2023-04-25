package com.vrvabeneficios.vrvabeneficios.exception;

import java.io.Serializable;

public class ExceptionResponse implements Serializable {

    private String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
