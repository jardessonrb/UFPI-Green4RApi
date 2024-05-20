package com.jrblab.green4rapi.shared.parser;

import com.jrblab.green4rapi.domain.dto.in.ProdutorForm;
import com.jrblab.green4rapi.domain.dto.out.ProdutorDto;
import com.jrblab.green4rapi.domain.model.Produtor;

public class ProdutorParser {

    public static Produtor toModel(ProdutorForm produtorForm){
        return Produtor
                .builder()
                .cpf(produtorForm.cpf())
                .dataNascimento(produtorForm.dataNascimento())
                .nomeCompleto(produtorForm.nomeCompleto())
                .telefone(produtorForm.telefone())
                .build();
    }

    public static ProdutorDto toDto(Produtor produtor){

        return ProdutorDto
                .builder()
                .id(produtor.getUuid())
                .nomeCompleto(produtor.getNomeCompleto())
                .cpf(produtor.getCpf())
                .dataNascimento(produtor.getDataNascimento())
                .telefone(produtor.getTelefone())
                .usuario(UsuarioParser.toDto(produtor.getUsuario()))
                .endereco(EnderecoParser.toDto(produtor.getUsuario().getEndereco()))
                .build();
    }
}
