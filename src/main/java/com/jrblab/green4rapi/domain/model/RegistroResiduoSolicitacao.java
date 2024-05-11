package com.jrblab.green4rapi.domain.model;


import com.jrblab.green4rapi.domain.enums.TipoPrecificao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_registro_residuo_solicitacao")
@Entity
public class RegistroResiduoSolicitacao extends EntityBase {

    private Double quantidade;

    private BigDecimal valorPorUnidade;

    @Enumerated(EnumType.STRING)
    private TipoPrecificao tipoPrecificao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitacao_id", insertable = false, updatable = false)
    private SolicitacaoColeta solicitacaoColeta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "residuo_id", insertable = false, updatable = false)
    private Residuo residuo;




}
