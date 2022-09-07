package com.ashop.shop.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user")
                .password("$2a$10$qnNUAz3JqBlQK/QLdgzUeOIAUOw88MuYw/am7XF49Z3xuFTWJaCm2")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("$2a$10$eKITRbXD5yDlZtoTrZXIk.2c.Aulbj1rGDIsza6oEF2V/Ux6Dd15y")
                .roles("ADMIN")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
//                .antMatchers("/add").hasAnyRole( "ADMIN")
                .antMatchers("/edit/*", "/delete/*","/add").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}