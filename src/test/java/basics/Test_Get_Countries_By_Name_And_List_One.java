package basics;

import java.util.Iterator;
import java.util.List;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class Test_Get_Countries_By_Name_And_List_One {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://restcountries.eu";
		
		String resourcePath = "/rest/v2/name/{name}";
		
		Response r = RestAssured
			.given()
				.pathParam("name", "United")
			.when()
				.get(resourcePath)
			.then()
				.extract().response();
		
		
		//2. Print all details of Object 2
		
		System.out.println("Second Object is: "+r.jsonPath().getString("[1]"));
		
		System.out.println(r.jsonPath().getMap("[1]"));
		
		JSONObject jO = new JSONObject(r.jsonPath().getMap("[1]"));
		
		System.out.println(jO.toString(4));
		
		
//		JSONObject jO = new JSONObject();
//		
//		System.out.println(jO.toString(4));
//		
		
		
	}

}
