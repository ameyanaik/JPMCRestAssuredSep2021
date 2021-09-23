package mockito;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.Calculator;

public class CalculatorTest2 {
	
	@Mock
	Calculator calc;
	
	@BeforeTest
	public void setUpMocks() {
		
		Mockito.when(calc.add(Mockito.anyInt(), Mockito.anyInt())).thenReturn(100);
	}
	
	@Test
	public void testAddition() {
		
		int result = calc.add(2, 3);
		Assert.assertEquals(result, 5);
		
		result = calc.subtract(10, 5);
		Assert.assertEquals(result, 5);
		
		result = calc.add(20, 80);
		Assert.assertEquals(result, 100);
		
	}

}
