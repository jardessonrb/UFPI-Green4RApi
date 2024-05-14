package com.jrblab.green4rapi.shared.handlerexception.handler;

import java.util.ArrayList;
import java.util.List;

import com.jrblab.green4rapi.shared.handlerexception.exception.dto.ExceptionDefaultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FailedFieldFormInputHandler {

    private MessageSource messsageSource;

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionDefaultDto handle(MethodArgumentNotValidException exception, HttpServletRequest request){
        List<String> errosDto = new ArrayList<>();
        List<FieldError> camposComErros = exception.getBindingResult().getFieldErrors();

        camposComErros.forEach(erro -> {
            String mensagemErroValidacao = messsageSource.getMessage(erro, LocaleContextHolder.getLocale());
            String erroCampo = "Campo: "+erro.getField()+"; Mensagem: "+mensagemErroValidacao;

            errosDto.add(erroCampo);
        });

        ExceptionDefaultDto exceptionDTO = ExceptionDefaultDto
                .builder()
                .mensagem("Campos inválidos")
                .erros(errosDto)
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .path(request.getRequestURI())
                .build();

        return exceptionDTO;
    }

}

