package br.com.niltonpereira.posto_combustivel.controller;


import br.com.niltonpereira.posto_combustivel.infrastructure.entity.BombaDeCombustivel;
import br.com.niltonpereira.posto_combustivel.service.BombaDeCombustivelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bombasDeCombustivel")
public class BombasDeCombustivelController {

    private final BombaDeCombustivelService bombaDeCombustivelService;

    public BombasDeCombustivelController(BombaDeCombustivelService bombaDeCombustivelService) {
        this.bombaDeCombustivelService = bombaDeCombustivelService;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody BombaDeCombustivel bombaDeCombustivel){
        bombaDeCombustivelService.criar(bombaDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<BombaDeCombustivel>> buscarBombaDeCombustivel(){
        return ResponseEntity.ok(bombaDeCombustivelService.buscarbombasDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombaDeCombustivel> buscarBombaDeCombustivelPorId(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(bombaDeCombustivelService.buscarBombaCombustivelPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarBombaDeCombustivel(@PathVariable(name = "id") Integer id){
        bombaDeCombustivelService.deletarBombaCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> alterarBombaDeCombustivel(@RequestParam(name = "id") Integer id,
                                                          @RequestBody BombaDeCombustivel bombaDeCombustivel){
        bombaDeCombustivelService.alterarBombaCombustivel(id, bombaDeCombustivel);
        return ResponseEntity.ok().build();
    }
}
