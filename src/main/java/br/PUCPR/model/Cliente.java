package br.PUCPR.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private int idCliente;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;

    //Construtor padrão (Obrigatorio pelo JPA)
    public Cliente(){}

    //Construtor com parametro
    public Cliente(String nome, String cpf, String telefone, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
}
