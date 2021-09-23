package reqres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostExampleDataDrivenTest {
	
	@Test (dataProvider = "readjsonfile")
	public void testCreateNewUser(String name, String job) {
	
		RestAssured.baseURI = "https://reqres.in";
		String path = "/api/users";
		
		JSONObject payload = new JSONObject();
		payload.put("name", name);
		payload.put("job", job);
		
		RestAssured
			.given()
				.body(payload.toString())
			.when()
				.post(path)
			.then()
				.log().body();
	}
	
	//@DataProvider
	
	@Test
	public void testJsonRead() throws IOException {
		readjsonfile();
	}
	
	@DataProvider
	public static Object[][] readjsonfile() throws IOException {
		
		String file = "src/test/java/resources/testdata.json";
		String json = new String(Files.readAllBytes(Paths.get(file)));
		System.out.println(json);
		
		JSONArray myArr = new JSONArray(json);
		
		int no_rows = myArr.length();
		int no_columns = myArr.getJSONObject(0).length();
		
		Object[][] data = new Object[no_rows][no_columns];
		
		
		for(int i=0; i<myArr.length(); i++) {
			JSONObject obj = myArr.getJSONObject(i);
			
			Iterator<String> k = obj.keys();
			
			int j = 0;
			while(k.hasNext()) {
				data[i][j] = obj.get(k.next());
			}			
		}
		
		return data;
		
	}

}
