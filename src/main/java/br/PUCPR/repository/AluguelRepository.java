package br.PUCPR.repository;

import br.PUCPR.model.Aluguel;
import br.PUCPR.dto.AluguelJoinDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    // JOIN para buscar todos os aluguéis com dados do carro e cliente
    @Query("SELECT new br.PUCPR.dto.AluguelJoinDTO(" +
            "a.idAluguel, a.dataInicio, a.dataFim, a.status, a.valorTotal, " +
            "c.idCarro, c.modelo, c.marca, c.placa, " +
            "cl.idCliente, cl.nome, cl.cpf) " +
            "FROM Aluguel a " +
            "INNER JOIN Carro c ON a.carroId = c.idCarro " +
            "INNER JOIN Cliente cl ON a.clienteId = cl.idCliente")
    List<AluguelJoinDTO> findAllWithJoin();

    // JOIN para buscar um aluguel específico com dados do carro e cliente
    @Query("SELECT new br.PUCPR.dto.AluguelJoinDTO(" +
            "a.idAluguel, a.dataInicio, a.dataFim, a.status, a.valorTotal, " +
            "c.idCarro, c.modelo, c.marca, c.placa, " +
            "cl.idCliente, cl.nome, cl.cpf) " +
            "FROM Aluguel a " +
            "INNER JOIN Carro c ON a.carroId = c.idCarro " +
            "INNER JOIN Cliente cl ON a.clienteId = cl.idCliente " +
            "WHERE a.idAluguel = :idAluguel")
    Optional<AluguelJoinDTO> findByIdWithJoin(@Param("idAluguel") Long idAluguel);
}