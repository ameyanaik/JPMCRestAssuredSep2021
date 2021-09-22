package basics;

import io.restassured.RestAssured;

public class Get_GitHub_Repos_Organized {

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
				.queryParam("sort", "created")
				.pathParam("username", "ameyanaik")
			
			//actions		 //act
			.when()
				.get(resourcePath)
			
			//assertions	//assert
			.then()
				.extract().response().prettyPrint();
		
	}

}
