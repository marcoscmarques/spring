package com.minhaempresa.spring.application.filter;

import com.minhaempresa.spring.application.services.JwtService;
import com.minhaempresa.spring.application.services.SecurityUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
    intercepta uma requisição para decodificar o token e colocar o usuário do token no contexto do spring security
*/
public class JwtTokenFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    private SecurityUserDetailsService securityUserDetailsService;

    public JwtTokenFilter(JwtService jwtService, SecurityUserDetailsService securityUserDetailsService) {
        this.jwtService = jwtService;
        this.securityUserDetailsService = securityUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        //Padrão Bearer 3er4r5565YT655...
        if(authorization != null && authorization.startsWith("Bearer")) {
            String token = authorization.split(" ")[1];
            boolean isValidToken = jwtService.isValidToken(token);
            if(isValidToken) {
                String login = jwtService.getLogin(token);
                UserDetails userDetails = securityUserDetailsService.loadUserByUsername(login);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,//usuario que está logado
                                null,//credentials
                                userDetails.getAuthorities()//permissões de usuário
                        );
                usernamePasswordAuthenticationToken.
                        setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
        }

        filterChain.doFilter(request, response);
    }
}
