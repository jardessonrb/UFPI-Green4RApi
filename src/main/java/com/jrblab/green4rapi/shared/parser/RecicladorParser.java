package com.jrblab.green4rapi.shared.parser;

import com.jrblab.green4rapi.domain.dto.in.ColetorForm;
import com.jrblab.green4rapi.domain.dto.in.RecicladorForm;
import com.jrblab.green4rapi.domain.dto.out.ColetorDto;
import com.jrblab.green4rapi.domain.dto.out.RecicladorDto;
import com.jrblab.green4rapi.domain.model.Coletor;
import com.jrblab.green4rapi.domain.model.Reciclador;

public class RecicladorParser {

    public static Reciclador toModel(RecicladorForm recicladorForm){
        return Reciclador
                .builder()
                .cpfCNPJ(recicladorForm.cpfCNPJ())
                .razaoSocial(recicladorForm.razaoSocial())
                .telefone(recicladorForm.telefone())
                .build();
    }
    public static RecicladorDto toDto(Reciclador reciclador){
        return RecicladorDto
                .builder()
                .id(reciclador.getUuid())
                .cpfCnpj(reciclador.getCpfCNPJ())
                .telefone(reciclador.getTelefone())
                .razaoSocial(reciclador.getRazaoSocial())
                .usuario(UsuarioParser.toDto(reciclador.getUsuario()))
                .endereco(EnderecoParser.toDto(reciclador.getUsuario().getEndereco()))
                .build();
    }
}
