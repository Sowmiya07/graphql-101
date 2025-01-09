package org.example.exception;

import lombok.Getter;

@Getter
public class BookException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public BookException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
