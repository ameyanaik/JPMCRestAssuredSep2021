package basics;

import io.restassured.RestAssured;

public class Get_GitHub_Repos {

	public static void main(String[] args) {

		//Root End Point
		RestAssured.baseURI = "https://api.github.com";
		
		//Resource Path
		String resourcePath = "/users/ameyanaik/repos";
		
		//GET Method
		RestAssured.get(resourcePath).prettyPrint();
		
	}

}
