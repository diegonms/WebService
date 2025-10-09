package br.PUCPR.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    private Integer id;

    @NotNull(message = "NAME_REQUIRED")
    @NotBlank(message = "NAME_REQUIRED")
    private String nome;

    @Email
    @NotBlank(message = "EMAIL_REQUIRED")
    private String email;


}
