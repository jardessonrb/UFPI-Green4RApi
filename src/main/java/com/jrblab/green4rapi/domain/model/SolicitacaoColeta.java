package com.jrblab.green4rapi.domain.model;

import com.jrblab.green4rapi.domain.enums.StatusSolicitacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_solicitacao_coleta")
@Entity
public class SolicitacaoColeta extends EntityBase{

    private BigDecimal valorTotal = BigDecimal.ZERO;

    private BigDecimal valorEsperado = BigDecimal.ZERO;

    private BigDecimal valorEsperadoGreenCoin = BigDecimal.ZERO;

    private BigDecimal valorTotalGreenCoin = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private StatusSolicitacao statusSolicitacao;

    private String comentarioProdutor;

    private String comentarioColetor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produtor_id", insertable = false, updatable = false)
    private Produtor produtor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coletor_id", insertable = false, updatable = false)
    private Coletor coletor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "solicitacao_id")
    private List<RegistroResiduoSolicitacao> registrosResiduos;
}
