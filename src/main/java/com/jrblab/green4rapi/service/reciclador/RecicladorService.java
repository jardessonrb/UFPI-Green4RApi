package com.jrblab.green4rapi.service.reciclador;

import com.jrblab.green4rapi.domain.dto.in.RecicladorForm;
import com.jrblab.green4rapi.domain.dto.out.RecicladorDto;
import com.jrblab.green4rapi.domain.model.Reciclador;

import java.util.UUID;

public interface RecicladorService {

    RecicladorDto criarReciclador(RecicladorForm recicladorForm);

    RecicladorDto buscarPorId(UUID recicladorId);
}
