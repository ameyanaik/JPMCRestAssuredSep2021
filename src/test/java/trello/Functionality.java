package trello;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Functionality extends TrelloBase{

	public static Response createBoard(String boardname) {
		
		
		String path = "/1/boards/";

		return RestAssured
			.given()
				.spec(commonspec)
				.queryParam("name", boardname)
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
			.spec(commonspec)
		.when()
			.get("/1/members/me/boards")
		.then()
			.log().all()
			.extract().response().jsonPath().getList("name");
		
		System.out.println(boardnames);
		
		return boardnames;
	}

	public static String getBoardID(String boardname) {
		String boardid = null;
		
		Response r = getAllBoardsResponses();
		
		//$ - means start from the very top of the response
		//"" - means start from he very top of the response
		//. - means start from he very top of the response
		List<Map<String,?>> maps = r.jsonPath().getList("");
		
		for (Map<String, ?> map : maps) {
			if(map.get("name").equals("Board_11")) {
				boardid = (String) map.get("id");
			}
		}
		
		return boardid;
	}

	private static Response getAllBoardsResponses() {
		
		return RestAssured
		.given()
			//.header("Content-Type", "application/json")
			.spec(commonspec)
		.when()
			.get("/1/members/me/boards")
		.then()
			.log().all()
			.extract().response();
	}

	public static Response deleteBoard(String boardid) {
		
		String path = "/1/boards/{id}";
		
		return RestAssured
				.given()
					.pathParam("id", boardid)
					.spec(commonspec)
				.when()
					.delete(path)
				.then()
					.extract().response();
		
	}
}
