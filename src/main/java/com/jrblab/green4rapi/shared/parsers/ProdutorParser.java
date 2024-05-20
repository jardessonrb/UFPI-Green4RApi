package com.jrblab.green4rapi.shared.parsers;

import com.jrblab.green4rapi.domain.dto.in.EnderecoForm;
import com.jrblab.green4rapi.domain.dto.in.ProdutorForm;
import com.jrblab.green4rapi.domain.dto.in.UsuarioForm;
import com.jrblab.green4rapi.domain.dto.out.EnderecoDto;
import com.jrblab.green4rapi.domain.dto.out.ProdutorDto;
import com.jrblab.green4rapi.domain.enums.TipoUsuario;
import com.jrblab.green4rapi.domain.model.Endereco;
import com.jrblab.green4rapi.domain.model.Produtor;
import com.jrblab.green4rapi.domain.model.Usuario;

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
