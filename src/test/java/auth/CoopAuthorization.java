package auth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CoopAuthorization {
	
	public static String getToken() {
		
		String clientID = "JPMCRestAssured";
		String clientSecret = "0f156703c48cdf7e05baac1f235e5879";
		
		RestAssured.baseURI = "http://coop.apps.symfonycasts.com";
		
		return RestAssured
			.given()
				.formParam("client_id", clientID)
				.formParam("client_secret", clientSecret)
				.formParam("grant_type", "client_credentials")
			.when()
				.post("/token")
			.then()
				.extract().response().jsonPath().getString("access_token");
		
	}

}
