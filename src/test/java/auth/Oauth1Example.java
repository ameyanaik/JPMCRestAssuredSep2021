package auth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Oauth1Example {
	
	@Test
	public void testOauth1Postman() {
		
		RestAssured.baseURI = "http://postman-echo.com";
		
		String path = "/oauth1";
		
		RestAssured
			.given()
				.auth()
					.oauth("RKCGzna7bv9YD57c", "D+EdQ-gs$-%@2Nu7", "", "")
			.when()
				.get(path)
			.then()
				.log().all();
	}

}
