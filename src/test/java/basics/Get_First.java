package basics;

import io.restassured.RestAssured;

public class Get_First {

	public static void main(String[] args) {
		
		RestAssured.get("https://httpbin.org/get").prettyPrint();
		
	}

}
