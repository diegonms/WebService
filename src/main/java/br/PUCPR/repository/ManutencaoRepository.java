package br.PUCPR.repository;

import br.PUCPR.model.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface ManutencaoRepository extends JpaRepository<Manutencao, Integer>{
}
