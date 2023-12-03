package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {

	//@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		given().
	 	  get("/users?page=2"). //GET list users
	 	then().
	 	  statusCode(200).
	 	  body("data[4].first_name",equalTo("George")). // this check response - match specific name
		  body("data.first_name",hasItems("George","Rachel")); // this check response - match the some of the first name
				
		
	}
	
	
	
	
	
	@Test
	public void testPost() {
		
             //Key, Value 		
		Map<String,Object> map = new HashMap<String,Object>();
		//example how create a request but don't have Json format
		//map.put("name","Raghav");
		//map.put("job", "Teacher");
		
		//System.out.println(map);
		
		
		
		// how to transform our request to JSON
		JSONObject request = new JSONObject();
		
		//example how create a request using JSON format
		request.put("name","Gabriela");
		request.put("job", "QA");
		
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given(). //pre-requisite
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		  body(request.toJSONString()).
		when().  // action
		  post("/users").
		then().  // response verification
		  statusCode(201)
		  .log().all();
		 
	}
}
