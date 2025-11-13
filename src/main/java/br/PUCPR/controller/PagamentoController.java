package br.PUCPR.controller;

import br.PUCPR.exception.BusinessException;
import br.PUCPR.model.Pagamento;
import br.PUCPR.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
@CrossOrigin(origins = "*")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping
    public List<Pagamento> listar() {
        return pagamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable int id) {
        return pagamentoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pagamento> criar(@RequestBody Pagamento pagamento) {
        //exception pra nao deixar ter pagamento duplicado
        boolean alreadyExists = pagamentoRepository.existsByFkAluguelId(pagamento.getFkAluguelId());
        if (alreadyExists){
            throw new BusinessException("PAGAMENTO_DUPLICADO", "Já foi pago");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoRepository.save(pagamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> atualizar(@PathVariable int id, @RequestBody Pagamento pagamento) {
        return pagamentoRepository.findById(id)
                .map(p -> {
                    pagamento.setIdPagamento(id);
                    return ResponseEntity.ok(pagamentoRepository.save(pagamento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (pagamentoRepository.existsById(id)) {
            pagamentoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
