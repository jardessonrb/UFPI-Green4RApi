package com.jrblab.green4rapi.shared.handlerexception.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String mensagem){
        super(mensagem);
    }
}
