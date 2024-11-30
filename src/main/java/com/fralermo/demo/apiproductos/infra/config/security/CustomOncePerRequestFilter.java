package com.fralermo.demo.apiproductos.infra.config.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomOncePerRequestFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;
	
	@SuppressWarnings("null")
	@Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try {
                SecurityContextHolder.getContext().setAuthentication(
                		tokenService.validarToken(token));
                
            } catch (AccessDeniedException e) { // TOKEN EXPIRADO
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpServletResponse.getWriter().write("Token expirado");
                return;
                
            } catch (RuntimeException e) { // EXCEPCIONES GENERALES
                SecurityContextHolder.clearContext();
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                httpServletResponse.getWriter().write("Error en la autenticación");
                return;
                
            } catch (Exception e) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                httpServletResponse.getWriter().write("Error inesperado");
                return;
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}

