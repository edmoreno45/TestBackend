package com.test.backend;

import static org.testng.Assert.assertEquals;
import org.apache.groovy.parser.antlr4.GroovyParser.AssertStmtAltContext;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestBack {

	@Test
	public void testGet() {
		baseURI = "https://api.openbrewerydb.org/breweries";
		
		String body = given()
		 	.queryParam("query","lagunitas")
		.when()
			.get("/autocomplete")
		.then()
		    .statusCode(200)
			.extract()
			.body()
			.asString();
			
		 
		System.out.println(body);
		
	}	
	
	@Test
	public void testGet1() {
		baseURI = "https://api.openbrewerydb.org/breweries";
		     ValidatableResponse  body2 = given()
		    		 .queryParam("query","lagunitas")
				.get("/{id}")
				.then()
				.statusCode(200)
			    .body("name", equalTo("Lagunitas Brewing Co"))
			    .and()
			    .body("state", equalTo("California"));
		     
		     assertEquals(body2,"Lagunitas Brewing Co");
		     assertEquals(body2, "1280 N McDowell Blvd");
		     assertEquals(body2, "7077694495");
		     
		     
		      System.out.println(body2);
	}
		

}
