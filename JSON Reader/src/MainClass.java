import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
public class MainClass {
	// This code reads from a JSON File
	public static void main(String[] args) {
		try {
			File file = new File("example.json");
			FileReader fr = new FileReader(file);
			BufferedReader bfr = new BufferedReader(fr);
			String jsonString = "";
			while (bfr.ready()) {
				jsonString += bfr.readLine();
			}
			
			JSONParser parser = new JSONParser();
			
			JSONObject rootObject = (JSONObject) parser.parse(jsonString); // we know that the root element of our file is a JSON Object that why parsing the result to JSONObject
			
			JSONArray hobbies = (JSONArray) rootObject.get("hobbies");
			JSONArray favBooks = (JSONArray) rootObject.get("fav_books");
			
			System.out.println("name: " + rootObject.get("first_name") + " " + rootObject.get("last_name"));
			System.out.println("hoby: " + hobbies.get(0));
			
			for (int i = 0; i < favBooks.size(); i++) {
				JSONObject favBook = (JSONObject) favBooks.get(i);
				System.out.println(favBook.get("name") + " by " + favBook.get("author"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
