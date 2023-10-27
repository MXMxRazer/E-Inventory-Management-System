package com.tamrakar.api_gateway_server.discovery_service_server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{

    @Value("${eureka.username}")
    private String username;
    @Value("${eureka.password}")
    private String password;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws  Exception {

        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }
}
