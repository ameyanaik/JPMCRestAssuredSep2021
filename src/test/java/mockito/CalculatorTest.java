package mockito;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.Calculator;

public class CalculatorTest {
	
	Calculator calc;
	
	@BeforeTest
	public void setUpMocks() {
		//Calculator calc = new Calculator();
		
		//Step 1 for Mocking
		calc = Mockito.mock(Calculator.class);
		//Step 2
		Mockito.when(calc.add(2, 3)).thenReturn(5);
		Mockito.when(calc.subtract(10, 5)).thenReturn(5);
	}
	
	@Test
	public void testAddition() {
		
		int result = calc.add(2, 3);
		Assert.assertEquals(result, 5);
		
		result = calc.subtract(10, 5);
		Assert.assertEquals(result, 5);
		
	}

}
