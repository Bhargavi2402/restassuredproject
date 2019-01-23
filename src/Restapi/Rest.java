package Restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Rest {
  @Test
 public void restapitest() {
	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	  RequestSpecification httprequest = RestAssured.given();
	  Response response = httprequest.request(Method.GET, "/Hyderabad");
	  String responsebody = response.getBody().asString();
	  int responsecode = response.getStatusCode();
	  System.out.println("response body" +responsebody);
	  System.out.println("status code"+responsecode);
  }
  @Test
  public void restapistatuscode() {
 	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
 	  RequestSpecification httprequest = RestAssured.given();
 	  Response response = httprequest.get("/Hyderabad");
 	  int responsecode = response.getStatusCode();
 	  Assert.assertEquals(responsecode, 200, "correct status code returned");
   }
  @Test
  public void restapierrostatuscode() {
 	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
 	  RequestSpecification httprequest = RestAssured.given();
 	  Response response = httprequest.get("93993000303");
 	  int responsecode = response.getStatusCode();
 	  Assert.assertEquals(responsecode, 400, "correct status code is not returned");
   }
  @Test
  public void restapistatusline() {
 	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
 	  RequestSpecification httprequest = RestAssured.given();
 	  Response response = httprequest.get("/Hyderabad");
 	  String statusline = response.getStatusLine();
 	  Assert.assertEquals(statusline, "HTTP/1.1 200 OK","correct status code returned");
   }
  @Test
  public void weathermessagebody() {
 	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
 	  RequestSpecification httprequest = RestAssured.given();
 	  Response response = httprequest.get("/Hyderabad");
 	  ResponseBody responsebody = response.getBody();
 	  String body = responsebody.asString();
 	  Assert.assertEquals(body.contains("Hyderabad"),true,"expected city is coming in the response");
   }
  @Test
  public void cityjsonvalidation() {
 	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
 	  RequestSpecification httprequest = RestAssured.given();
 	  Response response = httprequest.get("/Hyderabad");
 	 JsonPath jsonpathevaluate = response.jsonPath();
 	 String city = jsonpathevaluate.get("city");
 	 System.out.println("city revceived from response"+city);
 	  Assert.assertEquals(city,"Hyderabad","expected city is coming in the response");
   }
}
