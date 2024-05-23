package com.jrblab.green4rapi.service.coletor;

import com.jrblab.green4rapi.domain.dto.in.ColetorForm;
import com.jrblab.green4rapi.domain.dto.out.ColetorDto;

import java.util.UUID;

public interface ColetorService {

    ColetorDto criarColetor(ColetorForm coletorForm);

    ColetorDto buscarPorId(UUID coletorId);
}
