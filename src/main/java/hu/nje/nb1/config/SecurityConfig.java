package hu.nje.nb1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // MINDENT engedünk
                )
                .csrf(csrf -> csrf.disable())  // egyszerűség kedvéért kikapcsoljuk
                .formLogin(login -> login.disable()); // login kikapcsolva

        return http.build();
    }
}
