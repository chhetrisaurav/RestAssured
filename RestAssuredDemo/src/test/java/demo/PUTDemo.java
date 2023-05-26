package demo;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PUTDemo {
	
HashMap<String, String> map = new HashMap<>();
	
	@BeforeTest
	public void createPayLoad() {
		map.put("name", "Saurab");
		map.put("job", "Open");
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users/470";
	}
	
	@Test
	public void updateResource() {
		RestAssured
			.given()
				.contentType("application/json")
				.body(map)
			.when()
				.put()
			.then()
				.statusCode(200)
				.log().all();
		
	}

}
