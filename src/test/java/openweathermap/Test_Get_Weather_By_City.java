package openweathermap;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class Test_Get_Weather_By_City {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://api.openweathermap.org";
		
		RestAssured
			.given()
				.queryParam("q", "New Delhi")
				.queryParam("appid", "63e698077095642363b2ff3af81ba3ae")
			.when()
				.get("/data/2.5/weather")
			.then()
				.log().body()
				.assertThat().body("weather[0].main", Matchers.equalTo("Mist"));
		
		
		String s = RestAssured
			.given()
				.queryParam("q", "New Delhi")
				.queryParam("appid", "63e698077095642363b2ff3af81ba3ae")
			.when()
				.get("/data/2.5/weather")
			.then()
				.extract().response().jsonPath().getString("weather[0].main");
		
		System.out.println(s);
		
	}
	
}
