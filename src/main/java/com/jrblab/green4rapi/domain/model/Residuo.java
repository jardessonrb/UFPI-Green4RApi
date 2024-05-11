package com.jrblab.green4rapi.domain.model;

import com.jrblab.green4rapi.domain.enums.TipoPrecificao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_residuo")
@Entity
public class Residuo extends EntityBase {

    private String nome;

    private BigDecimal valorBase = BigDecimal.ZERO;

    private BigDecimal valorGreenCoin = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private TipoPrecificao tipoPrecificao;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "residuo_id")
    private List<RegistroResiduoSolicitacao> registrosResiduos;

}

