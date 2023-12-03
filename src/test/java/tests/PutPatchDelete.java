package tests;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDelete {

	@Test
	public void testPut() { // update the name of the method
		
		// how to transform our request to JSON
		JSONObject request = new JSONObject();
		
		//example how create a request using JSON format
		request.put("name","Gabriela");
		request.put("job", "QA");
		
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		  body(request.toJSONString()).
		when().
		  put("/users/2"). //specify method = put and the endpoint= https://reqres.in/api/users/2
		then().
		  statusCode(200) // also update the status code 
		  .log().all();
		 
	}
	
	
	@Test
	public void testPatch() { 
		
		// how to transform our request to JSON
		JSONObject request = new JSONObject();
		
		//example how create a request using JSON format
		request.put("name","Gab");
		request.put("job", "Automation");
		
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/";
		
		given().
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		  body(request.toJSONString()).
		when().
		  patch("api/users/2").
		then().
		  statusCode(200)  
		  .log().all();
		 
	}
	
	
	
	@Test
	public void testDelete() { 
		
				
		baseURI="https://reqres.in/";
		
		when().
		  delete("api/users/2").
		then().
		  statusCode(204)  
		  .log().all();
		 
	}
	
	
	
	
}

