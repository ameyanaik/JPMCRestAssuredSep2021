package auth;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import trello.common.TrelloBase;
import trello.common.Utilities;

public class OAuth2Example {
	
	
	@Test
	public void testOAuth2() throws FileNotFoundException, IOException {
		
		String authHeader = "OAuth oauth_consumer_key=\""
							+Utilities.getProperty("trellokey")+
							"\", oauth_token=\""
							+Utilities.getProperty
							("trellotoken")+"\"";
		
		
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
