package basics;

import java.util.Iterator;
import java.util.List;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class Test_Get_Countries_By_Name_And_List_All {

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
		
		
		//1. Print All Countries
		System.out.println("List of Countries: "+r.jsonPath().getList("name"));
		
		List<String> listofcountries = r.jsonPath().getList("name");
		
		for (String country : listofcountries) {
			System.out.println(country);
		}
		
		//2. Traverse over all countries
		
		System.out.println("Second Object is: "+r.jsonPath().getString("[1]"));
		
		String s1 = r.jsonPath().getString("");
		
		System.out.println("Response as String using JsonPath: "+s1);
		
		System.out.println("Response as String using asString: "+r.asString());
		
		JSONArray jA = new JSONArray(r.asString());
		
		System.out.println("Response Json Array: "+jA);
		
		Iterator<?> i = jA.iterator();
		
		while(i.hasNext()) {
//			Object o = i.next();
//			System.out.println(o);
			JSONObject jO = new JSONObject(i.next().toString());
			System.out.println(jO.get("name"));
			//System.out.println(jO.toString(4)); //PRETTY PRINT
		}
		
	}

}
