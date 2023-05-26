package demo;

import java.util.HashMap;
import java.util.UUID;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BearerTokenDemo {
	
	HashMap<String, String> map = new HashMap<>();
	UUID uuid = UUID.randomUUID();
	
	@BeforeTest
	public void createPayLoad() {
		map.put("name", "Rajesh");
		map.put("email", uuid + "@yahoo.com");
		map.put("gender", "male");
		map.put("status", "active");
		
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users";
	}
	
	@Test
	public void createResource() {
		RestAssured
			.given()
				.contentType("application/json")
			.body(map)
			.header("Authorization", "Bearer        and you write your bearer code")
		.when()
			.post()
		.then()
			.statusCode(201)
			.log().all();
		
	}

}
