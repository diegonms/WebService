package br.PUCPR.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "SEGURO")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SEGURO")
    private int idSeguro;

    @Column(name = "FK_ALUGUEL_ID", nullable = false)
    private int idfkALuguel;

    @Column(name = "TIPO", nullable = false)
    private String tipo;

    @Column(name = "VALOR",  nullable = false)
    private float valor;

    @Column(name = "COBERTURA", insertable = false)
    private String cobertura;

    @Column(name = "DATA_INICIO", insertable = false)
    private Date dataInicio;

    @Column(name = "DATA_FIM", insertable = false)
    private Date dataFim;

    @Column(name = "CREATED_AT", insertable = false, updatable = false)
    private java.sql.Timestamp createdAt;

    @Column(name = "UPDATED_AT", insertable = false, updatable = false)
    private java.sql.Timestamp updatedAt;
}
