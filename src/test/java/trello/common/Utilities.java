package trello.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utilities {
	
	public static String getProperty(String key) throws FileNotFoundException, IOException {
		
		FileReader reader = new FileReader("src/test/java/trello/resources/config.properties");
		Properties p = new Properties();
		p.load(reader);
		String value = p.getProperty(key);
		
		return value;
	}
}
