package trello.functionality;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import trello.common.TrelloBase;

public class Functionality extends TrelloBase{

	public static Response createBoard(String boardname) {
		
//		if(!verifyBoardNameForUniqueness(boardname)) {
//			boardname = boardname + createrandomstring()
//			System.out.println("Board name is not unique. Please reexecute with unique name.");
//			throw Expection()
			
//		}		
		
		String path = "/1/boards/";

		return RestAssured
			.given()
				.spec(commonspec)
				.queryParam("name", boardname)
			.when()
				.post(path)
			.then()
				//.log().all()
				.extract().response();
		
	}

	public static List<String> getAllBoards() {
		List<String> boardnames = new ArrayList<>();
		
		String path = "/1/members/{id}/boards";
		
		boardnames = RestAssured
		.given()
			//.header("Content-Type", "application/json")
			.spec(commonspec)
			.pathParam("id", "ameyanaik4")
		.when()
			.get(path)
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
			if(map.get("name").equals(boardname)) {
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
			//.log().all()
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

	public static String getToDOListID(String boardid) {
		
		String path = "/1/boards/{id}/lists";
		String todolistid = null;
		
		Response r = RestAssured
			.given()
				.spec(commonspec)
				.pathParam("id", boardid)
			.when()
				.get(path)
			.then()
				.extract().response();
		
		List<Map<String,?>> maps = r.jsonPath().getList("");
		
		for (Map<String, ?> map : maps) {
			if(map.get("name").equals("To Do")) {
				todolistid = (String) map.get("id");
			}
		}
		System.out.println("To DO List ID is: "+todolistid);
		
		return todolistid;
	}

	public static Response createNewCard(String todoidlist, String summary, String description) {

		String path = "/1/cards";
		
//		String payload = "{\n"
//				+ "	\"name\":\""+summary+"\",\n"
//				+ "	\"desc\":\""+description+"\"\n"
//				+ "}";
		
		JSONObject payload = new JSONObject();
		payload.put("name", summary);
		payload.put("desc", description);
		
		
		return RestAssured
			.given()
				.spec(commonspec)
				.queryParam("idList", todoidlist)
				.body(payload.toString())
			.when()
				.post(path)
			.then()
				.extract().response();
		
		
		
	}
}
