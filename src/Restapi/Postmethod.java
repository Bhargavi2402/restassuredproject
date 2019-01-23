package Restapi;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Postmethod {

	@Test
	public void Registrationsuccess(){
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestparms = new JSONObject();
		requestparms.put("Firstname", "Bhargavi");
		requestparms.put("lastname", "reddy");
		requestparms.put("Username", "rbharga1");
		requestparms.put("password", "abc123");
		
		request.header("Content type", "application/json");
		request.body(requestparms.toJSONString());
		Response response = request.post("/register");
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, "201");
		String successcode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successcode, "OPERATION_SUCCESS","correct successcode is returned");
	
	}
	@Test
	public void Registrationfailure(){
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestparms = new JSONObject();
		requestparms.put("Firstname", "Bhargavi");
		requestparms.put("lastname", "reddy");
		requestparms.put("Username", "rbharga1");
		requestparms.put("password", "abc123");
		
		//request.header("Content type", "application/json");
		request.body(requestparms.toJSONString());
		Response response = request.get("/register");
		int statuscode = response.getStatusCode();
		System.out.println("status code"+statuscode);
		System.out.println("response body"+response.body().asString());
	
	}
	
	
}
