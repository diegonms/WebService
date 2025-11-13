package br.PUCPR.controller;

import br.PUCPR.model.Aluguel;
import br.PUCPR.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluguel")
@CrossOrigin(origins = "*")
public class AluguelController {

    @Autowired
    private AluguelRepository aluguelRepository;

    // ficou sem joinnn
    @GetMapping
    public List<Aluguel> listar() {
        return aluguelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Aluguel buscarPorId(@PathVariable Long id) {
        return aluguelRepository.findById(id).orElse(null);
    }

    // Cadastrar Aluguel
    @PostMapping
    public Aluguel criar(@RequestBody Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    // Atualizar Aluguel
    @PutMapping("/{id}")
    public Aluguel atualizar(@PathVariable Long id, @RequestBody Aluguel aluguel) {
        if (aluguelRepository.existsById(id)) {
            aluguel.setIdAluguel(id);
            return aluguelRepository.save(aluguel);
        }
        return null;
    }
}
