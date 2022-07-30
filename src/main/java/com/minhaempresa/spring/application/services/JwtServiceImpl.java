package com.minhaempresa.spring.application.services;

import com.minhaempresa.spring.application.dtos.UsuarioDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.expiration}")
    private String jwtExpiration;
    @Value("${jwt.key}")
    private String jwtKey;

    @Override
    public String buildToken(UsuarioDTO usuarioDTO) {
        long expiration = Long.valueOf(jwtExpiration);
        LocalDateTime localDateTime  = LocalDateTime.now().plusMinutes(expiration);
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        String expirationTime = localDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));

        String token = Jwts
                            .builder()
                            .setExpiration(date)
                            .setSubject(usuarioDTO.getUser())
                            .claim("expirationTime", expirationTime)
                            .signWith(SignatureAlgorithm.HS512, jwtKey)
                            .compact();
        return "Bearer " + token;
    }

    @Override
    public Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(jwtKey)
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public boolean isValidToken(String token) {
        try {
            Claims claims = getClaims(token);
            Date date = claims.getExpiration();
            LocalDateTime expiration = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            boolean dataHoraIsAfterExpiration = LocalDateTime.now().isAfter(expiration);
            return !dataHoraIsAfterExpiration;
        }catch(ExpiredJwtException e) {
            return false;
        }
    }

    @Override
    public String getLogin(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }
}
