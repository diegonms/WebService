package br.PUCPR.repository;

import br.PUCPR.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    boolean existsByFkAluguelId(int fkAluguelId);
}
