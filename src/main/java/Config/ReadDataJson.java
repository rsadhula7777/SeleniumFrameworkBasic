package Config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataJson {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub

		JSONParser jsonparser = new JSONParser();

		FileReader reader = new FileReader(".\\src\\main\\resources\\Employee.json");

		Object obj = jsonparser.parse(reader);
		JSONObject empjsonobject = (JSONObject) obj;
		
		String fname=(String) empjsonobject.get("firstName");
		String lname=(String) empjsonobject.get("lastName");
		
		System.out.println("First Name "+fname);
		System.out.println("First Name "+lname);
		
		JSONArray array=(JSONArray) empjsonobject.get("address");
		
		for(int i=0;i<array.size();i++){
			
			JSONObject address=(JSONObject)array.get(i);
			String street=(String)address.get("streetAddress");
			String City=(String)address.get("city");
			String Postal=(String)address.get("postalCode");
			
			System.out.println("Address of "+i+"is.....");
			System.out.println("street of "+street);
			System.out.println("city of "+City);
			System.out.println("postal of "+Postal);
		}
		
		

	}

}
