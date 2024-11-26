package com.fralermo.demo.apiproductos.infra.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fralermo.demo.apiproductos.domain.model.Product;
import com.fralermo.demo.apiproductos.domain.services.ProductUseCase;

@RestController
public class ProductAPIController {

	
	@Autowired
	private ProductUseCase productUseCase;
	
	@GetMapping("/api/product/{id}")
	public Product findById(@PathVariable Long id) {
		return this.productUseCase.findById(id).orElse(null);
	}
	
}
