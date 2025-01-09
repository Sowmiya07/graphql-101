package org.example.exception;

import org.example.model.response.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(exception = BookException.class)
    public ErrorResponse handleBookException(BookException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ex.getErrorCode());
        errorResponse.setMessage(ex.getErrorMessage());
        return errorResponse;
    }

    @ExceptionHandler(exception = AuthorException.class)
    public ErrorResponse handleAuthorException(AuthorException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ex.getErrorCode());
        errorResponse.setMessage(ex.getErrorMessage());
        return errorResponse;
    }
}
