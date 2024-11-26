package com.fralermo.demo.apiproductos.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RegionTax {
	
	private Long taxId;
	private TaxType taxType;
	private BigDecimal taxPercentage;
	
}
