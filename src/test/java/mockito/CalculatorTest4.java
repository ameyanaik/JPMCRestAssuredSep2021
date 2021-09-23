package mockito;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.Calculator;
import trello.common.Utilities;

public class CalculatorTest4 {
	
	@Spy
	Calculator calc;
	
	@Mock
	ArrayList<String> myarray;
	
	@BeforeTest
	public void setUpMocks() throws FileNotFoundException, IOException {
		
		if(Utilities.getProperty("mocks").equals("true")) {
			MockitoAnnotations.openMocks(this);
			Mockito.when(calc.add(Mockito.anyInt(), Mockito.anyInt())).thenReturn(100);
			//Mockito.when(calc.subtract(10, 5)).thenReturn(100);
			Mockito.when(myarray.add("Ameya")).thenReturn(true);
		} else {
			System.out.println("Not Mocking");
		}
	}
	
	@Test
	public void testAddition() {
		
		int result = calc.add(2, 3);
		Assert.assertEquals(result, 5);
		
		result = calc.add(20, 80);
		Assert.assertEquals(result, 100);
		
		Assert.assertTrue(myarray.add("Ameya"));
		
	}
	
	@Test
	public void testSubtraction() {
		int result = calc.subtract(10, 5);
		Assert.assertEquals(result, 5);
	}

}
