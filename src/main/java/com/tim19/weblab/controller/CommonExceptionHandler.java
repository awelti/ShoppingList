package com.tim19.weblab.controller;

import com.tim19.weblab.dto.ErrorDto;
import com.tim19.weblab.error.CartitemNotFoundException;
import com.tim19.weblab.error.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleException(Throwable ex) {
        return new ErrorDto(ex.getMessage());
    }

    @ExceptionHandler(value = CartitemNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorDto handleNotFoundException(CartitemNotFoundException ex) {
        return new ErrorDto(ex.getMessage());
    }

}
