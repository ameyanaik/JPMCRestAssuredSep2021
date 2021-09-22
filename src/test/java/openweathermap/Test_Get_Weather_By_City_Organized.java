package openweathermap;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_Get_Weather_By_City_Organized {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://api.openweathermap.org";
		
		printWeather(getWeatherByCity("New Delhi"));
		
		printWeather(getWeatherByCity("Mumbai"));
		
	}
	
	public static Response getWeatherByCity(String cityname) {
		return RestAssured
			.given()
				.queryParam("q", cityname)
				.queryParam("appid", "63e698077095642363b2ff3af81ba3ae")
			.when()
				.get("/data/2.5/weather")
			.then()
				.extract().response();
	}
	
	public static void printWeather(Response r) {
		System.out.println(r.jsonPath().getString("weather[0].main"));
	}	
}
