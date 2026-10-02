package br.com.niltonpereira.posto_combustivel.service;


import br.com.niltonpereira.posto_combustivel.infrastructure.entity.TiposDeCombustivel;
import br.com.niltonpereira.posto_combustivel.infrastructure.repository.TiposDeCombustivelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TiposDeCombustivelService {

    private final TiposDeCombustivelRepository tiposDeCombustivelRepository;

    public TiposDeCombustivelService(TiposDeCombustivelRepository tiposDeCombustivelRepository) {
        this.tiposDeCombustivelRepository = tiposDeCombustivelRepository;
    }

    public void criar(TiposDeCombustivel tiposDeCombustivel){
        tiposDeCombustivelRepository.save(tiposDeCombustivel);
    }

    public TiposDeCombustivel buscarTiposDeCombustivelPorId(Integer id){
        return tiposDeCombustivelRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("TIpo de combustivel não encontrado por id" + id));
    }

    public List<TiposDeCombustivel> buscarTiposDeCombustivel(){
        return tiposDeCombustivelRepository.findAll();
    }

    @Transactional
    public void DeletarTipoDeCombustivel(Integer id){
        tiposDeCombustivelRepository.deleteById(id);
    }

    public void AlterarTipoDeCombustivel(Integer id, TiposDeCombustivel tiposDeCombustivel){
        TiposDeCombustivel bomba = buscarTiposDeCombustivelPorId(id);
        tiposDeCombustivel.setId(bomba.getId());
        tiposDeCombustivelRepository.save(tiposDeCombustivel);
    }
}
