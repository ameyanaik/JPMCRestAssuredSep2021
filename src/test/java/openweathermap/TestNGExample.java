package openweathermap;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class TestNGExample {
	
	
	@Test
	public void testOne() {
		System.out.println("Inside Test One");
	}
	
	@Test
	public void testTwo() {
		System.out.println("Inside Test Two");
	}
	
	@BeforeTest
	public void setUp() {
		System.out.println("Inside Before Test");
	}
	
	@BeforeMethod
	public void setUpBeforeMethod() {
		System.out.println("Inside Before Method");
	}
}
	
	
//	@BeforeSuite
//  @BeforeTest
//	@BeforeMethod
//	@Test
//	@AfterMethod
//	@AfterTest
//	@AfterSuite
	
