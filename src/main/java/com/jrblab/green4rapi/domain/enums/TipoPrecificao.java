package com.jrblab.green4rapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoPrecificao {

    KG("Por quilo Kg"),
    UNIDADE("Por unidade"),
    VOLUME("Por volume");

    private String descricao;
}
