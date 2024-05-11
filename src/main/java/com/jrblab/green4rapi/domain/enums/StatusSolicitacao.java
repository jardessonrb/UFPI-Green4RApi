package com.jrblab.green4rapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusSolicitacao {

    SOLICITADO("Solicitado"),
    ACEITO("Aceito"),
    COLETADO("Coletado"),
    CONFIRMADO("Confirmado"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");

    private String descricao;
}
