package com.minhaempresa.spring.application.resources;

import com.minhaempresa.spring.application.dtos.TokenDTO;
import com.minhaempresa.spring.application.dtos.UsuarioDTO;
import com.minhaempresa.spring.application.services.JwtService;
import com.minhaempresa.spring.application.services.JwtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserResource {

    @Autowired
    JwtServiceImpl jwtService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody UsuarioDTO usuarioDTO) {
            //implementar a autenticação do usuário...

            String token = jwtService.buildToken(usuarioDTO);
            TokenDTO tokenDTO = new TokenDTO(usuarioDTO.getUser(), token);
            return ResponseEntity.ok(tokenDTO);
    }
}
