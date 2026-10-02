package br.com.niltonpereira.posto_combustivel.controller;


import br.com.niltonpereira.posto_combustivel.infrastructure.entity.TiposDeCombustivel;
import br.com.niltonpereira.posto_combustivel.service.TiposDeCombustivelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TiposDeCombustivelController {

    private final TiposDeCombustivelService tiposDeCombustivelService;

    public TiposDeCombustivelController(TiposDeCombustivelService tiposDeCombustivelService) {
        this.tiposDeCombustivelService = tiposDeCombustivelService;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody TiposDeCombustivel tiposDeCombustivel){
        tiposDeCombustivelService.criar(tiposDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<TiposDeCombustivel>> buscarTiposDeCombustivel(){
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivel());
    }


    @GetMapping("/{id}")
    public ResponseEntity<TiposDeCombustivel> buscarTiposDeCombustivelPorId(@PathVariable Integer id){
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivelPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTiposDeCombustivel(@PathVariable(name = "id") Integer id){
        tiposDeCombustivelService.DeletarTipoDeCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> alterarTiposDeCombustivel(@RequestParam(name = "id") Integer id,
                                                          @RequestBody TiposDeCombustivel tiposDeCombustivel){
        tiposDeCombustivelService.AlterarTipoDeCombustivel(id, tiposDeCombustivel);
        return ResponseEntity.ok().build();
    }

}
