package com.jrblab.green4rapi.domain.dto.in;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoForm(
        @NotBlank(message = "Logradouro não pode ser vazio")
        @NotNull(message = "Logradouro é obrigatório")
        String logradouro,

        @NotNull(message = "Número é obrigatório")
        @Min(value = 1, message = "Número de residência deve ser maior que 0")
        Long numero,

        @NotBlank(message = "Bairro não pode ser vazio")
        @NotNull(message = "Bairro é obrigatório")
        String bairro,

        @NotBlank(message = "Cidade não pode ser vazio")
        @NotNull(message = "Cidade é obrigatório")
        String cidade,

        @NotBlank(message = "Estado não pode ser vazio")
        @NotNull(message = "Estado é obrigatório")
        String estado,

        @NotBlank(message = "CEP não pode ser vazio")
        @NotNull(message = "CEP é obrigatório")
        String cep,

        @NotNull(message = "Latitude é obrigatório")
        Double latitude,

        @NotNull(message = "Longitude é obrigatório")
        Double longitude
) {
}
