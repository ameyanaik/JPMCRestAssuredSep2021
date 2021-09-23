package trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import trello.functionality.Functionality;

public class Create_New_Board_Test {
	
	@Test
	public void testCreationOfNewBoard() {
		
		Response r = Functionality.createBoard("Board_11");
		Assert.assertNotNull(r);
		Assert.assertTrue(r.statusCode() == 200);
		
	}

}
