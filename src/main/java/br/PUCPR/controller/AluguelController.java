package br.PUCPR.controller;

import br.PUCPR.model.Aluguel;
import br.PUCPR.dto.AluguelJoinDTO;
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

    // Listar todos os aluguéis (com JOIN)
    @GetMapping
    public List<AluguelJoinDTO> listar() {
        return aluguelRepository.findAllWithJoin();
    }

    // Buscar Aluguel pelo ID (com JOIN)
    @GetMapping("/{id}")
    public AluguelJoinDTO buscarPorId(@PathVariable Long id) {
        return aluguelRepository.findByIdWithJoin(id).orElse(null);
    }

    // Listar aluguéis básicos (sem JOIN - opcional)
    @GetMapping("/basico")
    public List<Aluguel> listarBasico() {
        return aluguelRepository.findAll();
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