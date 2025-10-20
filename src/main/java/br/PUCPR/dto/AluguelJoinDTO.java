// AluguelJoinDTO.java
package br.PUCPR.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

@Setter
@Getter
public class AluguelJoinDTO {
    private Long idAluguel;
    private String dataInicio;
    private String dataFim;
    private String status;
    private String valorTotal;

    // Dados do Carro
    private Long carroId;
    private String carroModelo;
    private String carroMarca;
    private String carroPlaca;

    // Dados do Cliente
    private Long clienteId;
    private String clienteNome;
    private String clienteCpf;


    public AluguelJoinDTO(Long idAluguel, String dataInicio, String dataFim, String status,
                          String valorTotal, Long carroId, String carroModelo, String carroMarca,
                          String carroPlaca, Long clienteId, String clienteNome, String clienteCpf) {
        this.idAluguel = idAluguel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.valorTotal = valorTotal;
        this.carroId = carroId;
        this.carroModelo = carroModelo;
        this.carroMarca = carroMarca;
        this.carroPlaca = carroPlaca;
        this.clienteId = clienteId;
        this.clienteNome = clienteNome;
        this.clienteCpf = clienteCpf;
    }
}