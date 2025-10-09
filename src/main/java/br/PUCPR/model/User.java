package br.PUCPR.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FUNCIONARIO")
public class User {

    @Id
    @Column(name = "ID_FUNCIONARIO")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String password;

    @Column(name = "CARGO")
    private String cargo;
}
