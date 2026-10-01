package br.com.niltonpereira.posto_combustivel.infrastructure.repository;

import br.com.niltonpereira.posto_combustivel.infrastructure.entity.TiposDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposDeCombustivelRepository extends JpaRepository<TiposDeCombustivel, Integer> {
}
