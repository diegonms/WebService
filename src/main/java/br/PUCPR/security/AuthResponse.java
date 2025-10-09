package br.PUCPR.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class AuthResponse {

    private String email;
    private String token;
    private Date expires;

}
