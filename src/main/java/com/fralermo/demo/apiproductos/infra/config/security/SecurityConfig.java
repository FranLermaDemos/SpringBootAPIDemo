package com.fralermo.demo.apiproductos.infra.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private CustomAuthenticationEntryPoint autenticacionEntrada;
	
	@Autowired
	private CustomOncePerRequestFilter customRequestFilter;
	
	@Bean
	SecurityFilterChain securityFilterChainOwn(HttpSecurity http) throws Exception {
		http
			.exceptionHandling(handling -> handling.authenticationEntryPoint(autenticacionEntrada))
			.addFilterBefore(customRequestFilter, BasicAuthenticationFilter.class)
			.csrf(csrf -> csrf.disable())
			.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
			.authorizeHttpRequests(requests -> {
				requests
					.requestMatchers("/getToken/**").permitAll()
					.requestMatchers("/h2-console/**").permitAll();
				requests.anyRequest().authenticated();
			});
		
		return http.build();
	}
	
	
}
