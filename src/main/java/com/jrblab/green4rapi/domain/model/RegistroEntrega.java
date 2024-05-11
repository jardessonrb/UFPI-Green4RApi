package com.jrblab.green4rapi.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_registro_entrega")
@Entity
public class RegistroEntrega extends EntityBase {
    private BigDecimal valorTotal;

    @OneToOne
    @JoinColumn(name = "solicitacao_coleta_id")
    private SolicitacaoColeta solicitacaoColeta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reciclador_id", insertable = false, updatable = false)
    private Reciclador reciclador;


}
