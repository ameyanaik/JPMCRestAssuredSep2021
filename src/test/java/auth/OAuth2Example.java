package auth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import trello.common.TrelloBase;

public class OAuth2Example {
	
	String authHeader = "OAuth oauth_consumer_key=\"2b1a625928ec953e7723375d93f8a51d\", oauth_token=\"654bd7b2c61f3d7b98b07c05e4f461262258727c8c3f4c30d51e58b349d4e808\"";
	
	@Test
	public void testOAuth2() {
		
		RestAssured.baseURI = "https://api.trello.com";
		String path = "/1/members/{id}/boards";
		
		RestAssured
			.given()
				.header("Authorization",authHeader)
				.pathParam("id", "me")
			.when()
				.get(path)
			.then()
				.log().all();
	}
}
