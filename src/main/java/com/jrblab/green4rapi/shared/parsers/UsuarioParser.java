package com.jrblab.green4rapi.shared.parsers;

import com.jrblab.green4rapi.domain.dto.in.UsuarioForm;
import com.jrblab.green4rapi.domain.dto.out.UsuarioDto;
import com.jrblab.green4rapi.domain.enums.TipoUsuario;
import com.jrblab.green4rapi.domain.model.Endereco;
import com.jrblab.green4rapi.domain.model.Usuario;

public class UsuarioParser {

    public static Usuario toModel(UsuarioForm usuarioForm){

        return Usuario
                .builder()
                .nomeUsuario(usuarioForm.nomeUsuario())
                .emailUsuario(usuarioForm.emailUsuario())
                .tipoUsuario(TipoUsuario.PRODUTOR)
                .senhaUsuario(usuarioForm.senhaUsuario())
                .build();
    }

    public static UsuarioDto toDto(Usuario usuario){
        return UsuarioDto
                .builder()
                .id(usuario.getUuid())
                .emailUsuario(usuario.getEmailUsuario())
                .nomeUsuario(usuario.getNomeUsuario())
                .tipoUsuario(usuario.getTipoUsuario())
                .build();
    }
}
