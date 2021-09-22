package trello;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Get_All_Boards_For_A_User_Test extends TrelloBase{
	
	@Test
	public void testBoardsForAUser() {
		
		List<String> boardnames = Functionality.getAllBoards();
	
		Assert.assertTrue(boardnames.contains("Board_11"));
		
		List<String> expected = new ArrayList<String>();
		expected.add("Board44");
		expected.add("Board_1");
		expected.add("Board_11");
		
		Assert.assertEquals(boardnames, expected);
		
	}

}
