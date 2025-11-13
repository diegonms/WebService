package br.PUCPR.controller;


import br.PUCPR.model.Reserva;
import br.PUCPR.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
@CrossOrigin(origins = "*")
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable int id) {
        return reservaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizar(@PathVariable int id, @RequestBody Reserva reserva) {
        return reservaRepository.findById(id)
                .map(p -> {
                    reserva.setIdSeguro(id);
                    return ResponseEntity.ok(reservaRepository.save(reserva));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        if(reservaRepository.existsById(id)){
            reservaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}