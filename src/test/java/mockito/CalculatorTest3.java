package mockito;

import java.util.ArrayList;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.Calculator;

public class CalculatorTest3 {
	
	@Mock
	Calculator calc;
	
	@Mock
	ArrayList<String> myarray;
	
	@BeforeTest
	public void setUpMocks() {
		
		MockitoAnnotations.openMocks(this);
		
		Mockito.when(calc.add(Mockito.anyInt(), Mockito.anyInt())).thenReturn(100);
		
		Mockito.when(myarray.add("Ameya")).thenReturn(true);
	}
	
	@Test
	public void testAddition() {
		
		int result = calc.add(2, 3);
		//Assert.assertEquals(result, 5);
		
		result = calc.subtract(10, 5);
		Assert.assertEquals(result, 5);
		
		result = calc.add(20, 80);
		Assert.assertEquals(result, 100);
		
		Assert.assertTrue(myarray.add("Ameya"));
		
	}

}
