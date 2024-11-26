package com.fralermo.demo.apiproductos.infra.adapter.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fralermo.demo.apiproductos.infra.adapter.persistence.entity.ProductEntity;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, Long>{
	
}
