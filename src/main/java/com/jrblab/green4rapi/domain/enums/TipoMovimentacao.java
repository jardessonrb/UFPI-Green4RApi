package com.jrblab.green4rapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoMovimentacao {

    ENTRADA("Entrada"),
    RETIRADA("Retirada");

    private String descricao;
}
