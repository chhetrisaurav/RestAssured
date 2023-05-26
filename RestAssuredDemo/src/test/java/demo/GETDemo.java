package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GETDemo {
	
	@Test
	public void getAllCountries() {
		RestAssured
			.when()
				.get("https://restcountries.com/#endpoints-all")
			.then()
				.assertThat()
				.statusCode(200)
				.log().all();
			
	}

}
