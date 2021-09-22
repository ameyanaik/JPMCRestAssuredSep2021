package basics;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_Get_Countries_By_Name {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://restcountries.eu";
		
		String resourcePath = "/rest/v2/name/{name}";
		
		Response r1 = RestAssured.get(resourcePath);
		
		Response r = RestAssured
			.given()
				.pathParam("name", "India")
			.when()
				.get(resourcePath)
			.then()
				.extract().response();
		
	
		//1. Print the Name of the First Country
		System.out.println("Name of First Country is: "+r.jsonPath().getString("[0].name"));
		
		//2. Print the Currency of Second Country
		System.out.println("Currency of Second Country is: "+r.jsonPath().getString("[1].currencies[0].name"));
		
		//3. Print the population of Second Country
		System.out.println("Population of Second Country is: "+r.jsonPath().getLong("[1].population"));
		
		//4. Verify that the Capital of second country is "New Delhi"
		RestAssured
		.given()
			.pathParam("name", "India")
		.when()
			.get(resourcePath)
		.then()
			.assertThat().body("[1].capital", Matchers.containsString("New Dalhi"));
		
		
		
		
		//Homework: Find the capital city of India and verify that it is "New Delhi" (We will learn tomorrow)
		
		
	}

}
