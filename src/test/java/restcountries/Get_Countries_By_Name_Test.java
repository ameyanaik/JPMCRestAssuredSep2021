package restcountries;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Countries_By_Name_Test {
	
	@Test
	public void testNumberOfCountries() {
		
		int expected = 6;
		
		Response r = getCountriesByName("united");
		
		//List<String> listofCountries = r.jsonPath().getList(".");
		
		int actual = r.jsonPath().getList(".").size(); 
		
		Assert.assertEquals(actual, expected);
		
	}

	private Response getCountriesByName(String partialcountryname) {
		
		String baseurl = "https://restcountries.eu/";
		String resourcePath = "rest/v2/name/{name}";
		
		RestAssured.baseURI = baseurl;
		
		return RestAssured
				.given()
					.pathParam("name", partialcountryname)
					.relaxedHTTPSValidation()
				.when()
					.get(resourcePath)
				.then()
					.log().all()
					.extract().response();
	}
}
