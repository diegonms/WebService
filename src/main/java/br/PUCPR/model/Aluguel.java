// Aluguel.java
package br.PUCPR.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "ALUGUEL")
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALUGUEL")
    private Long idAluguel;

    @Column(name = "FK_CARRO_ID")
    private Long carroId;

    @Column(name = "FK_CLIENTE_ID")
    private Long clienteId;

    @Column(name = "DATA_INICIO")
    private String dataInicio;

    @Column(name = "DATA_FIM")
    private String dataFim;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "VALOR_TOTAL")
    private String valorTotal;

    // Construtor padrão (Obrigatório pelo JPA)
    public Aluguel() {}

    // Construtor com parâmetros
    public Aluguel(Long carroId, Long clienteId, String dataInicio, String dataFim, String status, String valorTotal) {
        this.carroId = carroId;
        this.clienteId = clienteId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.valorTotal = valorTotal;
    }

    public Object getFkCarroId() {
        return carroId;
    }
}