package demo;

import java.util.HashMap;
import java.util.UUID;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Create_Update_Delete_Demo {
	
	UUID uuid = UUID.randomUUID();
	HashMap<String, String> map = new HashMap<>();
	int id;
	
	@BeforeTest
	public void createPayLoad() {
		map.put("name", "Rajesh");
		map.put("email", uuid + "@yahoo.com");
		map.put("gender", "male");
		map.put("status", "active");
		
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users";
	}
	
	@Test(priority= 0)
	public void createResource() {
		Response response = RestAssured
			.given()
				.contentType("application/json")
			.body(map)
			.header("Authorization", "Bearer        and you write your bearer code") //enter code after Bearer
		.when()
			.post()
		.then()
			.statusCode(201)
			.log().all()
			.contentType(ContentType.JSON).extract().response();
		
		JsonPath jsonPath = response.jsonPath();
		id = jsonPath.get("id");
		
	}
	
	@Test(priority = 1)
	public void verifyResource() {
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users/" + id;
		
		RestAssured
			.given()
			.contentType("application/json")
			.header("Authorization", "Bearer        and you write your bearer code"); ////enter code after Bearer
	}

	@Test (priority = 2)
	public void updateResource() {
		map.put("name", "RajeshHamal");
		map.put("email", uuid + "@yahoo.com");
		map.put("gender", "male");
		map.put("status", "active");
		
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users" + id;
		
		RestAssured
			.given()
			.contentType("application/json")
			.body(map)
			.header("Authorization", "Bearer        and you write your bearer code") ////enter code after Bearer
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test(priority = 3)
	public void deleteResource() {
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users" + id;
		
		RestAssured
			.given()
			.contentType("application/json")
			
			.header("Authorization", "Bearer        and you write your bearer code")  ////enter code after Bearer
		.when()
			.delete()
		.then()
			.statusCode(204);
	
	}
}
