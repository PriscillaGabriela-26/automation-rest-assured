package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;


public class TestsExample2 {

// annotate with TestNG	
@Test	

//create a function
public void test_1() {
 
	Response response =	get("https://reqres.in/api/users?page=2"); // here I don't need to use more RestAssure
	
	//syso ctrl+enter and show automatically all System.out.println
	
	// store response and print response data
	System.out.println(response.getStatusCode());
	System.out.println(response.getTime());
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusLine());
	System.out.println(response.getHeader("content-type"));
	
	// test case to compare status code is the correct
	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 200);
	
	//
	
}

@Test
public void test_2() {
	
	baseURI = "https://reqres.in/api";
	given().
 	  get("/users?page=2").
 	then().
 	  statusCode(200).
 	  body("data[1].id", equalTo(8))// you can use https://jsonpathfinder.com/
 	 .log().all();
}
	
}
