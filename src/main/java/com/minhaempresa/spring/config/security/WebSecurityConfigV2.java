package com.minhaempresa.spring.config.security;
/*
import com.minhaempresa.spring.application.filter.JwtTokenFilter;
import com.minhaempresa.spring.application.services.JwtService;
import com.minhaempresa.spring.application.services.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;
import java.util.List;
*/
//@Configuration
public class WebSecurityConfigV2 {
/*
    @Autowired
    SecurityUserDetailsService securityUserDetailsService;
    @Autowired
    private JwtService jwtService;

    //@Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

    //@Bean
    public JwtTokenFilter jwtTokenFilter() {
        return  new JwtTokenFilter(jwtService, securityUserDetailsService);
    }

   //@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable() //desabilitado porque não vou disponibilizar uma aplicação web junto com o sring.
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user/authenticate").permitAll()//permite acesso sem autenticação
                .antMatchers(HttpMethod.GET, "/restful/**").permitAll()
                //.antMatchers(HttpMethod.POST, "/requests").hasRole("ADMIN")//GRUPO ADMIN, RH, ETC.
                //.antMatchers(HttpMethod.POST, "/requests").hasAuthority("FAZER_PEDIDO")
                .anyRequest().authenticated() //exige autenticação
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)// não guarda estado de sessão
                .and()
                .addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    //@Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        List<String> all = Arrays.asList("*");

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedMethods(all);
        corsConfiguration.setAllowedHeaders(all);
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOriginPatterns(all);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        CorsFilter corsfilter = new CorsFilter(source);
        FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<>(corsfilter);
        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filter;
    }

 */
}
