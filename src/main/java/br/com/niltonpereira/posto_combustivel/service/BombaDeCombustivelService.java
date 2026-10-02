package br.com.niltonpereira.posto_combustivel.service;


import br.com.niltonpereira.posto_combustivel.infrastructure.entity.BombaDeCombustivel;
import br.com.niltonpereira.posto_combustivel.infrastructure.repository.BombaDeCombustivelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BombaDeCombustivelService {

    private final BombaDeCombustivelRepository bombaDeCombustivelRepository;

    public BombaDeCombustivelService(BombaDeCombustivelRepository bombaDeCombustivelRepository) {
        this.bombaDeCombustivelRepository = bombaDeCombustivelRepository;
    }

    public void criar(BombaDeCombustivel bombaDeCombustivel){
        bombaDeCombustivelRepository.save(bombaDeCombustivel);
    }

    public BombaDeCombustivel buscarBombaCombustivelPorId(Integer id){
       return bombaDeCombustivelRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Bomba de combustível não encontrada pelo id" + id));
    }

    public List<BombaDeCombustivel> buscarbombasDeCombustivel(){
      return bombaDeCombustivelRepository.findAll();

    }

    @Transactional
    public void deletarBombaCombustivel(Integer id){
        bombaDeCombustivelRepository.deleteById(id);
    }

    public void alterarBombaCombustivel(Integer id, BombaDeCombustivel bombaDeCombustivel){
        BombaDeCombustivel bomba = buscarBombaCombustivelPorId(id);
        bombaDeCombustivel.setId(bomba.getId());
        bombaDeCombustivelRepository.save(bombaDeCombustivel);
    }
}
