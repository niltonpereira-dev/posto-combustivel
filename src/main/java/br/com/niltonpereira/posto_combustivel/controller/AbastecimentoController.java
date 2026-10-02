package br.com.niltonpereira.posto_combustivel.controller;

import br.com.niltonpereira.posto_combustivel.infrastructure.entity.Abastecimento;
import br.com.niltonpereira.posto_combustivel.service.AbastecimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abastecimento")
public class AbastecimentoController {

    private final AbastecimentoService abastecimentoService;

    public AbastecimentoController(AbastecimentoService abastecimentoService) {
        this.abastecimentoService = abastecimentoService;
    }

    @PostMapping
    public ResponseEntity<Void> abastecer(@RequestParam("quantidadeEmLitro") Long litros,
                                          @RequestParam("idBomba") Integer IdBomba){
        abastecimentoService.abastecer(IdBomba, litros);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Abastecimento>> buscarAbastecimentos(){
        return ResponseEntity.ok(abastecimentoService.buscarAbastecimento());
    }


}
