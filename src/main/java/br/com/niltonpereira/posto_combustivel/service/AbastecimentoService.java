package br.com.niltonpereira.posto_combustivel.service;

import br.com.niltonpereira.posto_combustivel.infrastructure.entity.Abastecimento;
import br.com.niltonpereira.posto_combustivel.infrastructure.entity.BombaDeCombustivel;
import br.com.niltonpereira.posto_combustivel.infrastructure.repository.AbastecimentoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class AbastecimentoService {

    private final BombaDeCombustivelService bombaDeCombustivelService;
    private final AbastecimentoRepository abastecimentoRepository;

    public AbastecimentoService(BombaDeCombustivelService bombaDeCombustivelService,
                                AbastecimentoRepository abastecimentoRepository) {
        this.bombaDeCombustivelService = bombaDeCombustivelService;
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public void abastecer(Integer idBomba, Long litros){
        BombaDeCombustivel bomba = bombaDeCombustivelService.buscarBombaCombustivelPorId(idBomba);
        BigDecimal valorTotal = bomba.getTiposDeCombustivel()
                .getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));

        Abastecimento abastecimento  = Abastecimento.builder()
                .dataAbastecimento(LocalDate.now())
                .bombaDeCombustivel(bomba)
                .valorTotal(valorTotal)
                .quantidadeLitros(litros)
                .build();

        abastecimentoRepository.save(abastecimento);
    }

    public List<Abastecimento> buscarAbastecimento(){
        return abastecimentoRepository.findAll();
    }
}
