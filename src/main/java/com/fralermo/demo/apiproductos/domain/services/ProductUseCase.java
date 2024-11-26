package com.fralermo.demo.apiproductos.domain.services;

import java.util.Optional;

import com.fralermo.demo.apiproductos.domain.model.Product;

public interface ProductUseCase {

	public Optional<Product> findById(Long productId);
	
}
