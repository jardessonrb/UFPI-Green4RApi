package com.jrblab.green4rapi.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "tb_produtor")
@Entity
public class Produtor extends EntityBase {

    @Column(nullable = false)
    private String nomeCompleto;

    private String telefone;

    @Column(length = 11, unique = true)
    private String cpf;

    private LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "produtor_id")
    private List<SolicitacaoColeta> solicitacoes;
}
