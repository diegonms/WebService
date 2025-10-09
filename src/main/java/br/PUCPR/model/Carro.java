package br.PUCPR.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private int idCarro;
    private String marca;
    private String modelo;
    private String placa;
    private String status;

    // Construtor padrão (obrigatório pelo JPA)
    public Carro() {}

    // Construtor com parâmetros (opcional, útil para testes)
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
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}