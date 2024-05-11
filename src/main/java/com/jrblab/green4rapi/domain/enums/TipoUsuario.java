package com.jrblab.green4rapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoUsuario {

    ADMIN("Administrador"),
    PRODUTOR("Produtor"),
    COLETOR("Coletor"),
    RECLICADOR("Reciclador");

    private String descricao;
}
