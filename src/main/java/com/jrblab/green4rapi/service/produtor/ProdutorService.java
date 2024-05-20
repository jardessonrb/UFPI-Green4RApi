package com.jrblab.green4rapi.service.produtor;

import com.jrblab.green4rapi.domain.dto.in.ProdutorForm;
import com.jrblab.green4rapi.domain.dto.out.ProdutorDto;

public interface ProdutorService {

    ProdutorDto criarProdutor(ProdutorForm produtor);
}
