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

/* The password inserted by the user is encripted through a BCryptPasswordEncoder.
    inside password() is the result of encription of password in class SecuredPasswordGenerator
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user")
                .password("$2a$10$Fujj3ETvkFFln9CUWp6mc.s/uhE5xvmUHoZ0ylknj2vSdGiWlrEUq")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("$2a$10$2jLy1uWU/tclpcErrwTqhOhmCFE.ps8lGecbdBLbI6K8oaZVJSWju")
                .roles("ADMIN")
        ;
    }
/*
    .anyMatchers  deny request from USER if it will try  bypass Security and digit URL Path commands like:
    /blog/{id}/edit
    /blog/remove
    /blog/add

    .formLogin , .logout allow the authentication and provided the form by spring security
 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/blog/{id}/edit", "/blog/remove","/blog/add").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .httpBasic()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
        http.cors().and().csrf().disable();
}
}