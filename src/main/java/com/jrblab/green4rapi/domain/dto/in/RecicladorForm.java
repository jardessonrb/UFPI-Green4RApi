package com.jrblab.green4rapi.domain.dto.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RecicladorForm(
         @NotBlank(message = "Razão Social não pode ser vazio")
         @NotNull(message = "Razão Social é obrigatório")
         String razaoSocial,
         @NotBlank(message = "Telefone não pode ser vazio")
         @NotNull(message = "Telefone é obrigatório")
         String telefone,
         @NotBlank(message = "CPJ/CNPJ não pode ser vazio")
         @NotNull(message = "CPJ/CNPJ é obrigatório")
         String cpfCNPJ,
         @NotNull
         UsuarioForm usuario,
         @NotNull
         EnderecoForm endereco
) {
}
