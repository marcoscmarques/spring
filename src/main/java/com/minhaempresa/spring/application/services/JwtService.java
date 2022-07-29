package com.minhaempresa.spring.application.services;

import com.minhaempresa.spring.application.dtos.UsuarioDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

public interface JwtService {
    String buildToken(UsuarioDTO usuarioDTO);

    //são as informações que tem no token
    Claims getClaims(String token) throws ExpiredJwtException;

    boolean isValidToken(String token);

    String getLogin(String token);
}
