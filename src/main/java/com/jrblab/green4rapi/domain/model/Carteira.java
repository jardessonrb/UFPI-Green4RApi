package com.jrblab.green4rapi.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_carteira")
@Entity
public class Carteira extends EntityBase {

    @Column(nullable = false)
    private BigDecimal saldoAtualGreenCoin = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal saldoAtualReal = BigDecimal.ZERO;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "carteira_id")
    private List<RegistroMovimentacao> registrosMovimentacoes;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

}
