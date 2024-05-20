package com.jrblab.green4rapi.shared.handlerexception.handler;

import com.jrblab.green4rapi.shared.handlerexception.exception.EntityAlreadyExistException;
import com.jrblab.green4rapi.shared.handlerexception.exception.EntityNotFoundException;
import com.jrblab.green4rapi.shared.handlerexception.exception.dto.ExceptionDefaultDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class EntityNotFoundExceptionHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ExceptionDefaultDto handle(EntityNotFoundException exception, HttpServletRequest request){
        return ExceptionDefaultDto
                .builder()
                .mensagem(exception.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .erros(Arrays.asList(exception.getMessage()))
                .path(request.getRequestURI())
                .build();
    }
}
