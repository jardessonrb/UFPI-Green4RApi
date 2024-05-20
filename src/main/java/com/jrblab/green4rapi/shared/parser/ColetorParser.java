package com.jrblab.green4rapi.shared.parser;

import com.jrblab.green4rapi.domain.dto.in.ColetorForm;
import com.jrblab.green4rapi.domain.dto.out.ColetorDto;
import com.jrblab.green4rapi.domain.model.Coletor;

public class ColetorParser {

    public static Coletor toModel(ColetorForm coletorForm){
        return Coletor
                .builder()
                .cpfCNPJ(coletorForm.cpfCNPJ())
                .razaoSocial(coletorForm.razaoSocial())
                .telefone(coletorForm.telefone())
                .build();
    }
    public static ColetorDto toDto(Coletor coletor){
        return ColetorDto
                .builder()
                .id(coletor.getUuid())
                .cpfCnpj(coletor.getCpfCNPJ())
                .telefone(coletor.getTelefone())
                .razaoSocial(coletor.getRazaoSocial())
                .usuario(UsuarioParser.toDto(coletor.getUsuario()))
                .endereco(EnderecoParser.toDto(coletor.getUsuario().getEndereco()))
                .build();
    }
}
