package com.deserialization;

import org.testng.annotations.Test;

import com.pojo.gmapsrequestbody;
import com.pojo.location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class reqrespspecbuilderrs {
	 
	@Test
	public void googlemaps() { 
		gmapsrequestbody gm = new gmapsrequestbody();
		gm.setAccuracy(50);
		gm.setName("joshua");
		gm.setPhone_number("(+91) 983 893 3937");
		gm.setAddress("address bar rail street");
		gm.setWebsite("http://google.com");
		gm.setLanguage("French-IN");
		
		List<String> li = new ArrayList<String>();
		li.add("shoe park");
		li.add("shop");
		gm.setTypes(li);
		location lo = new location();
		lo.setLat(-38.383494);
		lo.setLng(33.427362);
		gm.setLocation(lo);
		
		RequestSpecification req =new RequestSpecBuilder()
		.setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
	ResponseSpecification respp =	new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		
		
	RequestSpecification reqspec =    given().log().all().spec(req)
	    
	    .body(gm);
	    
String resp =	  reqspec.when().post("/maps/api/place/add/json")
	    .then().spec(respp).assertThat().statusCode(200).extract().response().asString();
	
   	System.out.println(resp);
	
	}

}
