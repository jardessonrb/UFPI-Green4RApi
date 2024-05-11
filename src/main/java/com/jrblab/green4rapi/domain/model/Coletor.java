package com.jrblab.green4rapi.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_coletor")
@Entity
public class Coletor extends EntityBase {

    @Column(nullable = false)
    private String razaoSocial;

    private String telefone;

    @Column(unique = true, name = "cpf_cnpj")
    private String cpfCNPJ;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "coletor_id")
    private List<SolicitacaoColeta> solicitacoes;
}
