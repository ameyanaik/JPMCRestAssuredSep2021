package trello;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Functionality extends TrelloBase{

	public static Response createBoard(String boardname) {
		
		
		String path = "/1/boards/";

		return RestAssured
			.given()
				//.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.queryParam("name", boardname)
				.queryParam("key", "2b1a625928ec953e7723375d93f8a51d")
				.queryParam("token", "654bd7b2c61f3d7b98b07c05e4f461262258727c8c3f4c30d51e58b349d4e808")
			.when()
				.post(path)
			.then()
				.log().all()
				.extract().response();
		
	}

	public static List<String> getAllBoards() {
		List<String> boardnames = new ArrayList<>();
		
		boardnames = RestAssured
		.given()
			//.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.queryParam("key", "2b1a625928ec953e7723375d93f8a51d")
			.queryParam("token", "654bd7b2c61f3d7b98b07c05e4f461262258727c8c3f4c30d51e58b349d4e808")
		.when()
			.get("/1/members/me/boards")
		.then()
			//.log().all()
			.extract().response().jsonPath().getList("name");
		
		System.out.println(boardnames);
		
		return boardnames;
	}
}
