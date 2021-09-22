package trello;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Delete_Board_Test extends TrelloBase {
	
	@Test
	public void testDeleteBoard() {
		String boardid;
		String boardname = "Board_11";
		
		boardid = Functionality.getBoardID(boardname);
		
		System.out.println(boardid);
		
		Response r = Functionality.deleteBoard(boardid);
		
		Assert.assertEquals(r.statusCode(), 200);
		
	}

}
