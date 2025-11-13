package br.PUCPR.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FUNCIONARIO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FUNCIONARIO")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // aceita no request, não aparece no response
    @Column(name = "SENHA", nullable = false)
    private String password;

    @Column(name = "CARGO", nullable = false)
    private String cargo;

    @Column(name = "CREATED_AT", insertable = false, updatable = false)
    private java.sql.Timestamp createdAt;

    @Column(name = "UPDATED_AT", insertable = false, updatable = false)
    private java.sql.Timestamp updatedAt;
}
