package com.fralermo.demo.apiproductos.infra.adapter.rest;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fralermo.demo.apiproductos.domain.exception.ProductNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ProductAPIExceptionHandler {

	
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex) {
    	return new ResponseEntity<>(getBody(HttpStatus.BAD_REQUEST, ex, ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception ex) {
        return new ResponseEntity<>(getBody(HttpStatus.INTERNAL_SERVER_ERROR, ex, ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public Map<String, Object> getBody(HttpStatus status, Exception ex, String message) {

        log.error(message, ex);

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", message);
        body.put("timestamp", new Date());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("exception", ex.toString());

        Throwable cause = ex.getCause();
        if (cause != null) {
            body.put("exceptionCause", ex.getCause().toString());
        }
        return body;
    }
	
}
