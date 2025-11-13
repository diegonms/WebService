package br.PUCPR.controller;

import br.PUCPR.exception.BusinessException;
import br.PUCPR.model.Cliente;
import br.PUCPR.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")

public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    //Listar todos os clientes
    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    //Buscar Cliente pelo ID
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    //alterei o metodo para incluir o exception - leonardo
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        // Validação: não pode haver dois clientes com o mesmo CPF
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new BusinessException("CPF_DUPLICADO", "Já existe um cliente com este CPF.");
        }

        Cliente novo = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // Atualizar Cliente
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setIdCliente(cliente.getIdCliente());
        return clienteRepository.save(cliente);
    }
}
