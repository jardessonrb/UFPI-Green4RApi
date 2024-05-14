package com.jrblab.green4rapi.domain.dto.out;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProdutorDto {

    private String nomeCompleto;
    private UUID id;
}
