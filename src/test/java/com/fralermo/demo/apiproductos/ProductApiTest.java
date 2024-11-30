package com.fralermo.demo.apiproductos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductApiTest implements InitializingBean {
	
	@LocalServerPort
	private int port;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		RestAssured.baseURI = "http://127.0.0.1:"+port;
	}
	
	@Test
	void testRestProductQuery1() throws Exception {
		
		String productId = "6";
		
		String token = RestAssured.given()
				.contentType(ContentType.JSON)
				.when()
				.get("/getToken/")
				.then()
				.extract().response().asString();
		
		
		Header headers = new Header("Authorization", "Bearer "+token);
		
		Response response = RestAssured.given()
			.contentType(ContentType.JSON)
			.header(headers)
			.when()
			.get("/api/product/"+productId)
			.then()
			.extract().response();
		
		log.info(response.asPrettyString());
		Assertions.assertEquals(200, response.statusCode());
		
		double price = response.jsonPath().getDouble("prices[0].price");
		
		Assertions.assertEquals(29.99, price);
	}
	
}
