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

    // Listar todos os aluguéis (SEM JOIN) — retorna a entidade Aluguel
    @GetMapping
    public List<Aluguel> listar() {
        return aluguelRepository.findAll();
    }

    // Buscar Aluguel pelo ID (SEM JOIN)
    @GetMapping("/{id}")
    public Aluguel buscarPorId(@PathVariable Long id) {
        return aluguelRepository.findById(id).orElse(null);
    }

    // Mantive um endpoint /basico caso queira outra rota - agora redundante, mas deixei por compatibilidade
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
