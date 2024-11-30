package com.fralermo.demo.apiproductos.domain.exception;

public class ProductNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String message) {
        super(message);
    }
}
