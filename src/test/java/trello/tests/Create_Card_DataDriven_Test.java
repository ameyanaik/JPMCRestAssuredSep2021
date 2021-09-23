package trello.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import trello.common.ExcelReader;
import trello.common.TrelloBase;
import trello.functionality.Functionality;

public class Create_Card_DataDriven_Test extends TrelloBase{
	
	@Test (dataProvider = "getTestDataFromExcel")
	public void testCreationOfMultipleCardsInAnExistingBoard(String boardname, String cardTitle, String cardDescription) {
		
		//1. Get Board ID from the name
		String boardid = Functionality.getBoardID(boardname);
		System.out.println(boardid);
		
		//2. Get ID of the ToDO List of the above Board
		String listID = Functionality.getToDOListID(boardid);
		
		//3. Create a new Card in the above list
		Response r = Functionality.createNewCard(listID, cardTitle, cardDescription);
		Assert.assertEquals(r.statusCode(), 200);
	}
	
	@DataProvider
	public Object[][] getTestDataFromExcel() throws IOException {
		return ExcelReader.readExcelData("src/test/java/trello/resources/testdata.xlsx");
	}
	
}
