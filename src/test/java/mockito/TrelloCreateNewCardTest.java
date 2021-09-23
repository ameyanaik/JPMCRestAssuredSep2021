package mockito;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import trello.common.TrelloBase;
import trello.functionality.Functionality;

public class TrelloCreateNewCardTest extends TrelloBase{
	
	@Spy
	Functionality feature;
	
	@BeforeTest
	public void setUpMocks() {
		
		//feature = Mockito.mock(Functionality.class);
		MockitoAnnotations.openMocks(this);
		Mockito.when(feature.getBoardID_mock("Board_1")).thenReturn("l6QrkBSy");
	}
	
	@Test
	public void testCreationOfNewCard() {
		String boardid = feature.getBoardID_mock("Board_1");
		String listid = feature.getToDOListID_mock(boardid);
		
		System.out.println("List id is:" +listid);
		Response r = Functionality.createNewCard(listid, "RestAssured_Mocking", "This is Created by Mocking Board ID");
		Assert.assertEquals(r.statusCode(), 200);
	}

}
