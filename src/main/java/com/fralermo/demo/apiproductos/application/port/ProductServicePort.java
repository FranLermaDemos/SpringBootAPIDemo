package com.fralermo.demo.apiproductos.application.port;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fralermo.demo.apiproductos.domain.exception.ProductNotFoundException;
import com.fralermo.demo.apiproductos.domain.model.Product;
import com.fralermo.demo.apiproductos.domain.services.ProductUseCase;
import com.fralermo.demo.apiproductos.infra.adapter.persistence.repository.JpaProductRepository;
import com.fralermo.demo.apiproductos.infra.mapper.ProductMapper;

@Service
public class ProductServicePort implements ProductUseCase {

	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private JpaProductRepository repository;
	
	@Override
	@Cacheable("ProductCache")
	public Optional<Product> findById(Long productId) throws ProductNotFoundException {
		return Optional.ofNullable(this.repository.findById(productId)
				.map(productMapper::toModel)
				.orElseThrow(() -> new ProductNotFoundException("Producto "+productId+" no encontrado")));
	}

}
