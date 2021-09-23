package coop;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import auth.CoopAuthorization;
import io.restassured.RestAssured;
import trello.common.Utilities;

public class CoopTests {
	
	@Test
	public void testGetUserInfo() {
		
		String path = "/api/me";
		
		RestAssured.baseURI = "http://coop.apps.symfonycasts.com";
		
		RestAssured
			.given()
				.auth()
					.preemptive()
					.oauth2(CoopAuthorization.getToken())
					.log().all()
			.when()
				.get(path)
			.then()
				.log().all();		
	}
	
	@Test
	public void testCollectEggs() throws FileNotFoundException, IOException {
		
		String path = "/api/{USER_ID}/eggs-collect";
		
		RestAssured.baseURI = "http://coop.apps.symfonycasts.com";
		
		RestAssured
			.given()
				.auth()
					.preemptive()
					.oauth2(CoopAuthorization.getToken())
					.pathParam("USER_ID", Utilities.getProperty("coopuserid"))
					.log().all()
			.when()
				.post(path)
			.then()
				.log().all();		
	}

}
