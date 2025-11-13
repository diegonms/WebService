package br.PUCPR.controller;

import br.PUCPR.exception.BusinessException;
import br.PUCPR.model.Carro;
import br.PUCPR.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
@CrossOrigin(origins = "*") //// permite acesso do front-end
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    // Listar todos os carros
    @GetMapping
    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    // Buscar carro por ID
    @GetMapping("/{id}")
    public Carro buscarPorId(@PathVariable Long id) {
        return carroRepository.findById(id).orElse(null);
    }

    // modifiquei o metodo para incluir a exception de placa duplicada - leonardo
    @PostMapping
    public ResponseEntity<Carro> criar(@RequestBody Carro carro) {
        if (carroRepository.existsByPlaca(carro.getPlaca())) {
            throw new BusinessException("PLACA_DUPLICADA", "Já existe um carro com esta placa.");
        }

        Carro novo = carroRepository.save(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // Atualizar carro existente
    @PutMapping("/{id}")
    public Carro atualizar(@PathVariable Long id, @RequestBody Carro carro) {
        carro.setIdCarro(carro.getIdCarro());
        return carroRepository.save(carro);
    }

    // Deletar carro por ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        carroRepository.deleteById(id);
    }
}