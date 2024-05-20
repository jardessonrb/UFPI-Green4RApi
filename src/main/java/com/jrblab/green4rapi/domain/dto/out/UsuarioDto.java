package com.jrblab.green4rapi.domain.dto.out;

import com.jrblab.green4rapi.domain.enums.TipoUsuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UsuarioDto {
    private UUID id;
    private String nomeUsuario;
    private String emailUsuario;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
}
