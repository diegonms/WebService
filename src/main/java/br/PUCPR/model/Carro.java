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


    public Carro() {}

    public Carro(String marca, String modelo, String placa, String status) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.status = status;
    }

    /* Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }


     */
    // Opcional: toString para debug
    @Override
    public String toString() {
        return "Carro{" +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}