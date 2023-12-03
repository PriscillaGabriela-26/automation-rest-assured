package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestsExamples { // CLASS

// annotate with TestNG	
@Test	

//create a function
public void test_1() { // METHOD
 
	Response response =	RestAssured.get("https://reqres.in/api/users?page=2");
	
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

	
}
