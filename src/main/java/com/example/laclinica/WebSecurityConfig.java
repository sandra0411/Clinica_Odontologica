package com.example.laclinica;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/index.html").hasRole("USER")
                .antMatchers("/turnoAlta.html").hasRole("USER")
                .antMatchers("/turnosList.html").hasRole("USER")
                .antMatchers("/pacienteAlta.html").hasRole("ADMIN")
                .antMatchers("/pacientesList.html").hasRole("ADMIN")
                .antMatchers("/odontologoAlta.html").hasRole("ADMIN")
                .antMatchers("/odontologosList.html").hasRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .and()
                .logout();
    }

}
