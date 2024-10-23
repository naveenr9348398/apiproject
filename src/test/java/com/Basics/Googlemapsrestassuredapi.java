package com.Basics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.files.payload;
import com.files.reusablemthods;

public class Googlemapsrestassuredapi {
	
	    @Test
		public void rpi() throws IOException {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	String response =	given().log().all()
		.queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(new String (Files.readAllBytes(Path.of("C:\\Users\\navee\\eclipse-workspace\\Restassuredpractice1\\externaljson\\api.json"))))
		
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("status",equalTo("OK"))
		 .header("Connection", "Keep-Alive").extract().response().asString();
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
	String placeid =	js.getString("place_id");
	System.out.println(placeid);
	
	//update place with new address
	String newaddr ="ffkfkfk"; 
	
	given()
	.queryParam("key", "qaclick123")
	.queryParam("place_id", placeid)
	.body("{\r\n"
			+ "\"place_id\":\""+placeid+"\",\r\n"
			+ "\"address\":\""+newaddr+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}")
	
	.when().put("/maps/api/place/update/json")
	.then().log().all().body("msg", equalTo("Address successfully updated"));
	
	
	//get place to validate if new address is present
String getresponse =	given()
	.queryParam("key", "qaclick123")
	.queryParam("place_id", placeid)
	
	
	.when().get("/maps/api/place/get/json")
	.then().assertThat().statusCode(200)
	.log().all().extract().response().asString();
	
JsonPath js1 =	reusablemthods.rawtojson(getresponse);
String updateadress =	js1.getString("address");
Assert.assertEquals(updateadress, newaddr);
	
	
	
	
	
	
	}

}
