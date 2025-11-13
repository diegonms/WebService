package br.PUCPR.controller;

import br.PUCPR.exception.BusinessException;
import br.PUCPR.model.Aluguel;
import br.PUCPR.model.Carro;
import br.PUCPR.repository.AluguelRepository;
import br.PUCPR.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<Aluguel> criar(@RequestBody Aluguel aluguel) {
        if (aluguel.getDataFim().before(aluguel.getDataInicio())) {
            throw new BusinessException("DATA_INVALIDA", "A data final não pode ser anterior à data inicial.");
        }

        Carro carro = CarroRepository.findById(aluguel.getFkCarroId())
                .orElseThrow(() -> new BusinessException("CARRO_INEXISTENTE", "O carro informado não existe."));

        if (!"DISPONIVEL".equalsIgnoreCase(carro.getStatus())) {
            throw new BusinessException("CARRO_INDISPONIVEL", "O carro informado não está disponível.");
        }

        // Marca o carro como alugado
        carro.setStatus("ALUGADO");
        carroRepository.save(carro);

        Aluguel novo = aluguelRepository.save(aluguel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
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
