package trello;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Create_Card_Test extends TrelloBase{
	
	@Test
	public void testCreationOfCardInANewBoard() {
		
		//1. Create a New Board and Get its ID
		Response r = Functionality.createBoard("Board_31");
		String boardid = r.jsonPath().getString("id");
		
		//2. Get ID of the ToDO List of the above Board
		String listID = Functionality.getToDOListID(boardid);
		
		//3. Create a new Card in the above list
		r = Functionality.createNewCard(listID, "RestAssured_1", "This is my first Card from Rest Assured");
		Assert.assertEquals(r.statusCode(), 200);
		
	}
	
//	@AfterMethod
//	public void cleanUp() {
//		r = null;
//		Functionality.deleteCards()
//	}

}
