package openweathermap;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_Get_Weather_By_City_TestNG {
	
	@Test
	public void testWeatherForNewDelhi() {
		
		String expected = "Cloudy";
		Response r = getWeatherByCity("New Delhi");
		String actual = r.jsonPath().getString("weather[0].main");
		
		Assert.assertEquals(actual, expected);
	}
	
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI = "https://api.openweathermap.org";
	}
	
	
	//Reusable Methods
	
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
