package com.jrblab.green4rapi.shared.parser;

import com.jrblab.green4rapi.domain.dto.in.EnderecoForm;
import com.jrblab.green4rapi.domain.dto.out.EnderecoDto;
import com.jrblab.green4rapi.domain.model.Endereco;

public class EnderecoParser {

    public static Endereco toModel(EnderecoForm enderecoForm){
        return Endereco
                .builder()
                .cep(enderecoForm.cep())
                .bairro(enderecoForm.bairro())
                .cidade(enderecoForm.cidade())
                .estado(enderecoForm.estado())
                .logradouro(enderecoForm.logradouro())
                .latitude(enderecoForm.latitude())
                .longitude(enderecoForm.longitude())
                .numero(enderecoForm.numero())
                .build();
    }

    public static EnderecoDto toDto(Endereco endereco){
        return EnderecoDto
                .builder()
                .id(endereco.getUuid())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .cep(endereco.getCep())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .bairro(endereco.getBairro())
                .longitude(endereco.getLongitude())
                .latitude(endereco.getLatitude())
                .build();
    }
}
