package br.com.niltonpereira.posto_combustivel.infrastructure.repository;

import br.com.niltonpereira.posto_combustivel.infrastructure.entity.BombaDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BombaDeCombustivelRepository extends JpaRepository<BombaDeCombustivel, Integer> {
}
