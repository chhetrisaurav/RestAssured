package demo;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class POSTDemo {
	
	HashMap<String, String> map = new HashMap<>();
	
	@BeforeTest
	public void createPayLoad() {
		map.put("name", "Saurav");
		map.put("job", "Open");
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users";
	}
	
	@Test
	public void createResource() {
		RestAssured
		.given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201)
			.log().all();
	}

}
