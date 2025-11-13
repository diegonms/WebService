package br.PUCPR.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "MANUTENCAO")

public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MANUTENCAO")
    private int idManutencao;

    @Column(name = "FK_CARRO_ID", nullable = false)
    private int idfkCarroId;

    @Column(name = "DATA_MANUTENCAO" , nullable = false)
    private Date dataManutencao;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "VALOR", nullable = false)
    private double valor;

    @Column(name = "CREATED_AT", insertable = false, updatable = false)
    private java.sql.Timestamp createdAt;

    @Column(name = "UPDATED_AT", insertable = false, updatable = false)
    private java.sql.Timestamp updatedAt;
}
