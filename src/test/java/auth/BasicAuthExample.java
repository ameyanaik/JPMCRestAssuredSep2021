package auth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicAuthExample {
	
	@Test
	public void testBasicAuthOfPostman() {
		
		RestAssured.baseURI = "http://postman-echo.com";
		
		String path = "/basic-auth";
		
//		RestAssured
//			.given()
//				.auth()
//					.preemptive()
//					.basic("postman", "password")
//					.log().headers()
//			.when()
//				.get(path)
//			.then()
//				.log().all();
		
		RestAssured
		.given()
			.header("Authorization","Basic cG9zdG1hbjpwYXNzd29yZA==")
		.when()
			.get(path)
		.then()
			.log().all();
		
	}

}
