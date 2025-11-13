package br.PUCPR.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARRO")
    private int idCarro;

    private String marca;
    private String modelo;
    private String placa;
    private String status;

    @Column(name = "VALOR_DIARIA", nullable = false)
    private Double valorDiaria;  // 👈 Campo obrigatório no banco

    public Carro() {}

    public Carro(String marca, String modelo, String placa, String status, Double valorDiaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.status = status;
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "idCarro=" + idCarro +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", status='" + status + '\'' +
                ", valorDiaria=" + valorDiaria +
                '}';
    }
}
