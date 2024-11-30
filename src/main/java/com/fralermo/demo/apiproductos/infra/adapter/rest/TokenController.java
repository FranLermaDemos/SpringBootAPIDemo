package com.fralermo.demo.apiproductos.infra.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fralermo.demo.apiproductos.infra.config.security.TokenService;

@RestController
@RequestMapping("/getToken")
public class TokenController {
	
	@Autowired private TokenService tokenService;
	
	@GetMapping("/")
    public ResponseEntity<String> obtenerToken() throws Exception {
		String token = tokenService.crearToken();

		if(token != null) {
			return ResponseEntity.ok().body(token);
		} else {
			return ResponseEntity.badRequest().body("Error no controlado al generar token");
		}		
    }
}
