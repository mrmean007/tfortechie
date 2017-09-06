import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


public class Mainclass {

	public static void main(String[] args) {
		FileWriter fwriter;
		try {
			fwriter = new FileWriter(new File("example2.json"));
			BufferedWriter bfwriter = new BufferedWriter(fwriter);
			
			JSONArray jArray = new JSONArray();
			JSONObject jObject = new JSONObject();
			
			jObject.put("name", "John Mait"); //added a single entry to json object
			
			ArrayList<String> fruits = new ArrayList<String>(); // Collection of entries
			fruits.add("Apple"); // populating collection
			fruits.add("Orange");
			fruits.add("Peach");
			
			jArray.addAll(fruits);	// collection added to json array
			jArray.add(0, "Srawberry"); // a single entry added at 0 index
			
			jObject.put("fruits", jArray); // json array added to json object
			
			System.out.println(jObject.toJSONString()); // toJSONString converts JSONObject to a String
			
			bfwriter.write(jObject.toJSONString()); // save the string to the file 
			bfwriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
