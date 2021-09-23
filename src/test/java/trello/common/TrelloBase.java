package trello.common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TrelloBase {
	
	public static RequestSpecification commonspec;
	
//	public TrelloBase() {
//		System.out.println("Hello From Constructor");
//		//RestAssured.baseURI = "https://api.trello.com";
//		
//		commonspec = new RequestSpecBuilder()
//							.setBaseUri("https://api.trello.com")
//							.setContentType(ContentType.JSON)
//							.addQueryParam("key", "2b1a625928ec953e7723375d93f8a51d")
//							.addQueryParam("token", "654bd7b2c61f3d7b98b07c05e4f461262258727c8c3f4c30d51e58b349d4e808")
//							.build();
//	}
	
	@BeforeSuite
	public void setUp() {
		System.out.println("Hello From Before Suite");
		//RestAssured.baseURI = "https://api.trello.com";
		
		commonspec = new RequestSpecBuilder()
							.setBaseUri("https://api.trello.com")
							.setContentType(ContentType.JSON)
							.addQueryParam("key", "2b1a625928ec953e7723375d93f8a51d")
							.addQueryParam("token", "654bd7b2c61f3d7b98b07c05e4f461262258727c8c3f4c30d51e58b349d4e808")
							.build();
		
		
	}
	
//	@AfterSuite
//	public void tearDown() {
//		Functionality.deleteAllBoards();
//	}

}
