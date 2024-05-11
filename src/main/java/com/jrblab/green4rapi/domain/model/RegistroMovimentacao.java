package com.jrblab.green4rapi.domain.model;

import com.jrblab.green4rapi.domain.enums.TipoMovimentacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_registro_movimentacao")
@Entity
public class RegistroMovimentacao extends EntityBase {

    @Column(nullable = false)
    private BigDecimal valorMovimentadoGreenCoin = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal valorMovimentadoReal = BigDecimal.ZERO;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carteira_id", insertable = false, updatable = false)
    private Carteira carteira;

}
