package com.jrblab.green4rapi.domain.dto.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioForm(
        @NotBlank(message = "Nome de usuário não pode ser vazio")
        @NotNull(message = "Nome de usuário é obrigatório")
        String nomeUsuario,

        @NotBlank(message = "Email de usuário não pode ser vazio")
        @NotNull(message = "Email de usuário é obrigatório")
        String emailUsuario,

        @NotBlank(message = "Senha de usuário não pode ser vazio")
        @Size(min = 8, message = "Senha de usuário deve ter no minímo 8 caracteres")
        String senhaUsuario
//        byte[] fotoPerfil
) {
}
