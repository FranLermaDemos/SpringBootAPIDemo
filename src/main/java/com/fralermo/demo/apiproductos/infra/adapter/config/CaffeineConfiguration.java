package com.fralermo.demo.apiproductos.infra.adapter.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@EnableCaching
@Configuration
public class CaffeineConfiguration {

	@SuppressWarnings("rawtypes")
	@Bean
	public Caffeine caffeineConfig() {
	    return Caffeine.newBuilder().expireAfterWrite(60, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public CacheManager cacheManager(Caffeine caffeine) {
	    CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
	    caffeineCacheManager.setCaffeine(caffeine);
	    return caffeineCacheManager;
	}
	
}
