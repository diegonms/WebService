package br.PUCPR.controller;

import br.PUCPR.model.Manutencao;
import br.PUCPR.repository.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manutencao")
@CrossOrigin(origins = "*")
public class ManutencaoController {
    @Autowired
    private ManutencaoRepository manutencaoRepository;

    @GetMapping
    public List<Manutencao> listarManutencao(){return manutencaoRepository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> buscarPorId(@PathVariable int id){
        return manutencaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manutencao> atualizar(@PathVariable int id, @RequestBody Manutencao manutencao){
        return manutencaoRepository.findById(id)
                .map(p ->{
            manutencao.setIdManutencao(id);
            return ResponseEntity.ok(manutencaoRepository.save(manutencao));
        })
            .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        if(manutencaoRepository.existsById(id)){
            manutencaoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
