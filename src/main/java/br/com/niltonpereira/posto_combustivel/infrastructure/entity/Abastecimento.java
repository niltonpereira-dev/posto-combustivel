package br.com.niltonpereira.posto_combustivel.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "abastecimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "bomba_combustivel_id")
    private BombaDeCombustivel bombaDeCombustivel;

    @Column(name = "data_abastecimento")
    private LocalDate dataAbastecimento;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "quantidade_litros")
    private Long quantidadeLitros;


}
