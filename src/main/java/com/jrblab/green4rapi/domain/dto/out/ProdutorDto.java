package com.jrblab.green4rapi.domain.dto.out;


import com.jrblab.green4rapi.domain.model.Produtor;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ProdutorDto {

    private String nomeCompleto;
    private UUID id;
    private String telefone;
    private String cpf;
    private LocalDate dataNascimento;
    private UsuarioDto usuario;
    private EnderecoDto endereco;

}
