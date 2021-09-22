package basics;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class Get_GitHub_Repos_Organized_Headers {

	public static void main(String[] args) {

		//Root End Point
		RestAssured.baseURI = "https://api.github.com";
		
		//Resource Path
		String resourcePath = "/users/{username}/repos";
		
		//GET Method
		RestAssured
			//prerequisites //arrange
			.given()
				//.proxy("http1.oh.bankone.net", 8080)
				.header("accept", "application/vnd.github.v3+json") //header recommended by github
				.header("My_Header_1","My_Header_Value_1") //custom header ignored by GitHub
				.queryParam("sort", "created")
				.pathParam("username", "ameyanaik")
				.header("Content-Type", "application/json")
			
			//actions		 //act
			.when()
				.get(resourcePath)
			
			//assertions	//assert
			.then()
				.log().everything()
				.assertThat().statusCode(200)
				.assertThat().body("[1].name", Matchers.equalToIgnoringCase("JPMCRestAssured"));
	}
}
