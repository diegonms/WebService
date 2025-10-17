package br.PUCPR.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALUGUEL")
    private int idAluguel;
    private String carro;
    private String dataInicio;
    private String dataFim;
    private String status;
    private String valorTotal;

    //Construtor padrão (Obrigatorio pelo JPA)
    public Aluguel(){}

    //Construtor com parametro
    public Aluguel(String carro, String dataInicio, String dataFim, String status, String valorTotal) {
        this.carro = carro;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.valorTotal = valorTotal;
    }
}
