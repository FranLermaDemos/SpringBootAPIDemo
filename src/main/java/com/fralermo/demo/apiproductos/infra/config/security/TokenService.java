package com.fralermo.demo.apiproductos.infra.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class TokenService {

	@Value("${security.jwt.token.secret-key:secret-key}")
	private String secretKey;
	
    public String crearToken() throws Exception {
		try {
			Date now = new Date();
			Date validity = new Date(now.getTime() + 3600000); // 1 HORA
			
			Algorithm algorithm = Algorithm.HMAC256(secretKey);
			
			return JWT
				.create().withIssuedAt(now)
				.withExpiresAt(validity)
				.sign(algorithm);
			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}		
    }
    
    public Authentication validarToken(String token) throws Exception {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secretKey);
			JWTVerifier verifier = JWT.require(algorithm).build();
			verifier.verify(token);
			
			return new UsernamePasswordAuthenticationToken(null, null, null);
		} catch (Exception e) {
			throw new AccessDeniedException("Token expirado");
		}
	}
	
}

