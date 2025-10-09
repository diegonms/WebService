package br.PUCPR.controller;

import br.PUCPR.model.Carro;
import br.PUCPR.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    // Criar novo carro
    @PostMapping
    public Carro criar(@RequestBody Carro Carro) {
        return carroRepository.save(Carro);
    }

    // Atualizar carro existente
    @PutMapping("/{id}")
    public Carro atualizar(@PathVariable Long id, @RequestBody Carro Carro) {
        Carro.setId(id);
        return carroRepository.save(Carro);
    }

    // Deletar carro por ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        carroRepository.deleteById(id);
    }
}
