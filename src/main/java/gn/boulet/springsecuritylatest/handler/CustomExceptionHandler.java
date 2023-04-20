package gn.boulet.springsecuritylatest.handler;

import gn.boulet.springsecuritylatest.dto.ErrorMessage;
import gn.boulet.springsecuritylatest.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage productNotFound(ProductNotFoundException exception) {
        return new ErrorMessage(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
