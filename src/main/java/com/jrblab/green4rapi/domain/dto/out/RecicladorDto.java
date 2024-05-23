package com.jrblab.green4rapi.domain.dto.out;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RecicladorDto {
    private UUID id;
    private String razaoSocial;
    private String telefone;
    private String cpfCnpj;
    private UsuarioDto usuario;
    private EnderecoDto endereco;
}
