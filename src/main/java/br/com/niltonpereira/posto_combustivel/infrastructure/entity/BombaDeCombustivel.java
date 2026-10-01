package br.com.niltonpereira.posto_combustivel.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bomba_de_combustivel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BombaDeCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_da_bomba")
    private String nomeDaBomba;

    @ManyToOne
    @JoinColumn(name = "combustivel_id")
    private TiposDeCombustivel tiposDeCombustivel;
}
