package com.jrblab.green4rapi.service.produtor;

import com.jrblab.green4rapi.domain.dto.in.ProdutorForm;
import com.jrblab.green4rapi.domain.dto.out.ProdutorDto;

import java.util.UUID;

public interface ProdutorService {
    ProdutorDto criarProdutor(ProdutorForm produtor);
    ProdutorDto buscarPorId(UUID id);
}
