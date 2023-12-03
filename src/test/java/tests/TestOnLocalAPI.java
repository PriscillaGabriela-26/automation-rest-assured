package tests;

import org.json.simple.JSONObject; //This line imports a class called JSONObject from the json.simple package. This class allows you to create and manipulate JSON objects in Java. JSON (JavaScript Object Notation) is a data interchange format that is commonly used for APIs.
import org.testng.annotations.Test; //This line imports the @Test annotation from the TestNG testing framework. TestNG is a testing framework inspired by JUnit and NUnit but introducing new functionalities like flexible test configuration and parallel test execution.

import io.restassured.http.ContentType;//This line imports the ContentType class from the Rest Assured library. ContentType is an enumeration that represents different types of content types that can be sent or received in HTTP requests and responses. For example, ContentType.JSON represents JSON content type.

import static io.restassured.RestAssured.*;//This line imports all static methods from the RestAssured class. Rest Assured is a Java library that provides a domain-specific language (DSL) for writing API tests. It simplifies the process of sending HTTP requests and validating responses.

public class TestOnLocalAPI {
	
    @Test
	public void get() {
		
		baseURI = "http://localhost:3000/";
		
		            //endPoint
		given().get("/users").then().statusCode(200).log().all();
	}
	
	
	//@Test
	public void post() {
    // with this method we will add a new register in the "users" API http://localhost:3000/users	

	JSONObject request = new JSONObject();
	
	request.put("firstName", "Monica"); //key , value
	request.put("LastName", "Concha");
	request.put("subjectId", "5");
	
	baseURI= "http://localhost:3000/";
	
	given()
	 .contentType(ContentType.JSON)
	 .accept(ContentType.JSON)
	 .body(request.toJSONString())
	.when()
	 .post("/users")   // In the context of APIs, the "POST" method is used to submit data to be processed to a specified resource.
	.then()          //Returns response and validate 
	 .statusCode(201);
		
	}
	
			
	//@Test
	public void put() {
	    // with this method we will edit a current register in the "users" API http://localhost:3000/users
		//this line is like a title for a special section in your notebook.
		

		JSONObject request = new JSONObject(); // create a special note in your notebook called "request" 
		
		request.put("firstName", "Bri");      // this note will contain specific details you want to send
		request.put("LastName", "Cuzcano");
		request.put("subjectId", "2");
		
		baseURI= "http://localhost:3000/"; // where it should be send the message
		
		given()
		 .contentType(ContentType.JSON) // we are sending a message, the information is in JSON format
		 .accept(ContentType.JSON)      // we are want to receive the reply in the same language JSON
		 .body(request.toJSONString())  // we are putting a message  that is JSON format	 
		.when()
		 .put("/users/4")               //   Specify the API endpoint you want to test  //Then the API is triggered with specific method (example PUT) and we're going to edit (or change) some information in the 'users' API - In the context of APIs, the "PUT" method is used to update an existing resource or create a new resource if it does not exist at a specific URL (Uniform Resource Locator)
		.then()
		 .statusCode(200);              // then wait the response and do the validation like example status code 200
			
		}

	
	//@Test
	public void patch() {
	    // with this method we will edit a current register in the "users" API http://localhost:3000/users
		

		JSONObject request = new JSONObject();
		
		request.put("LastName", "Concha");
		
		baseURI= "http://localhost:3000/";
		
		given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(request.toJSONString())
		.when()
		 .patch("/users/4") // specify what user id you want to modify  //In the context of APIs (Application Programming Interfaces), including RESTful APIs, "PATCH" is a HTTP method that is used to partially update a resource on the server.
		.then()
		 .statusCode(200);
			
		}
	
	
	//@Test
	public void delete() {
	 baseURI = "http://localhost:3000";
	 
	 when().delete("users/4").then().statusCode(200);
	}
}
