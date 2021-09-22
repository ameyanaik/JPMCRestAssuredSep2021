package trello;

import io.restassured.RestAssured;

public class TrelloBase {
	
	public TrelloBase() {
		System.out.println("Hello From Constructor");
		RestAssured.baseURI = "https://api.trello.com";
	}

}
