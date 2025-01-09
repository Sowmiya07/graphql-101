package org.example.exception;

import lombok.Getter;

@Getter
public class AuthorException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public AuthorException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
