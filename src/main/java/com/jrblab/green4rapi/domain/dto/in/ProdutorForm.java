package com.jrblab.green4rapi.domain.dto.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record ProdutorForm(
        @NotBlank(message = "Nome completo não pode ser vazio")
        @NotNull(message = "Nome completo é obrigatório")
        String nomeCompleto,
        @NotBlank(message = "Telefone não pode ser vazio")
        @NotNull(message = "Telefone é obrigatório")
        String telefone,
        @CPF(message = "CPF inválido")
        @NotNull(message = "CPF é obrigatório")
        String cpf,

        @NotNull(message = "Data de nascimento é obrigatória formato ano-mes-dia")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate dataNascimento,

        @NotNull
        UsuarioForm usuario,

        @NotNull
        EnderecoForm endereco
) {
}
