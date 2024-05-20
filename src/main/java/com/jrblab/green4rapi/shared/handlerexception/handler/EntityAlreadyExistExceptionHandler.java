package com.jrblab.green4rapi.shared.handlerexception.handler;

import com.jrblab.green4rapi.shared.handlerexception.exception.dto.EntityAlreadyExistException;
import com.jrblab.green4rapi.shared.handlerexception.exception.dto.ExceptionDefaultDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class EntityAlreadyExistExceptionHandler {

    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(EntityAlreadyExistException.class)
    public ExceptionDefaultDto handle(EntityAlreadyExistException exception, HttpServletRequest request){
        return ExceptionDefaultDto
                .builder()
                .mensagem(exception.getMessage())
                .statusCode(HttpStatus.CONFLICT.value())
                .erros(Arrays.asList(exception.getMessage()))
                .path(request.getRequestURI())
                .build();
    }
}
