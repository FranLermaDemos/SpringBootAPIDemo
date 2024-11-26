package com.fralermo.demo.apiproductos.domain.model;

import java.util.List;

import lombok.Data;

@Data
public class Product {

	private Long id;
	private String description;
	
	private List<StorePrice> prices;
	private List<RegionTax> taxes;
	
}
