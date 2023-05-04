package com.trackingsys.stocktrackingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager configAuthentication(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic()
                .and()
                .authorizeHttpRequests()
                    //.requestMatchers("/login").permitAll()
                    .requestMatchers("/orders").authenticated()
                    .requestMatchers(HttpMethod.POST,"/users/**").hasRole("USER")
                    .requestMatchers(HttpMethod.GET,"/users/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
        return http.build();
    }
}
