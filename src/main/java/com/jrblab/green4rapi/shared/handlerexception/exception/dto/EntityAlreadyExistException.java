package com.jrblab.green4rapi.shared.handlerexception.exception.dto;

public class EntityAlreadyExistException extends RuntimeException {
    public EntityAlreadyExistException(String mensagem){
        super(mensagem);
    }
}
