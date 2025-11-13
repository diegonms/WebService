package br.PUCPR.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "PAGAMENTO")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGAMENTO")
    private int idPagamento;

    @Column(name = "FK_ALUGUEL_ID", nullable = false)
    private int fkAluguelId;

    @Column(name = "DATA_PAGAMENTO", nullable = false)
    private Date dataPagamento;

    @Column(name = "VALOR_PAGO", nullable = false)
    private Double valorPago;

    @Column(name = "METODO", nullable = false)
    private String metodo;

    @Column(name = "CREATED_AT", insertable = false, updatable = false)
    private java.sql.Timestamp createdAt;

    @Column(name = "UPDATED_AT", insertable = false, updatable = false)
    private java.sql.Timestamp updatedAt;
}
