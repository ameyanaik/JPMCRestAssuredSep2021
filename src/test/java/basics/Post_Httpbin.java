package basics;

import io.restassured.RestAssured;

public class Post_Httpbin {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://httpbin.org";
		
		RestAssured
			.given()
				.body("This is a POST Test")
				.log().all()
			.when()
				.post("/post")
			.then()
				//.log().all()
				.assertThat().statusCode(200);
	}
}
