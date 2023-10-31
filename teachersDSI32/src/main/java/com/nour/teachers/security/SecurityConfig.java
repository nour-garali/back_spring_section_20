package com.nour.teachers.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import
org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
{
http.csrf().disable()
 .sessionManagement()
 .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
 .authorizeHttpRequests()
//consulter tous les produits
.requestMatchers("/api/all/**").hasAnyAuthority("ADMIN","USER")
//consulter un produit par son id
.requestMatchers(HttpMethod.GET,"/api/getbyid/**")
.hasAnyAuthority("ADMIN","USER")

//ajouter un nouveau produit
.requestMatchers(HttpMethod.POST,"/api/addEns/**").hasAnyAuthority("ADMIN")
//modifier un produit
.requestMatchers(HttpMethod.PUT,"/api/updateEns/**").hasAuthority("ADMIN")
//supprimer un produit
.requestMatchers(HttpMethod.DELETE,"/api/delEns/**").hasAuthority("ADMIN")
.anyRequest().authenticated().and()
.addFilterBefore(new
JWTAuthorizationFilter(),BasicAuthenticationFilter.class);
return http.build();
}}