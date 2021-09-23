package reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostExampleTest {
	
	@Test
	public void testCreateNewUser() {
	
		RestAssured.baseURI = "https://reqres.in";
		String path = "/api/users";
		
		String payload = "{\n"
				+ "    \"name\": \"morpheus\",\n"
				+ "    \"job\": \"leader\"\n"
				+ "}";
		
		RestAssured
			.given()
				.body(payload)
			.when()
				.post(path)
			.then()
				.log().body();
		
	}

}
