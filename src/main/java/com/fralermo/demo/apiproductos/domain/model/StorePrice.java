package com.fralermo.demo.apiproductos.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class StorePrice {

	private BigDecimal price;
	private Store store;
	
}
