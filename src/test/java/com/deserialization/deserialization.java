package com.deserialization;

import org.testng.annotations.Test;

import com.pojo.gmapsrequestbody;
import com.pojo.location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class deserialization {
	 
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
		
		
		
		
		
		RestAssured.baseURI ="https://rahulshettyacademy.com";
	String resp =    given().log().all()
	    .queryParam("key", "qaclick123")
	    .body(gm)
	    
	    .when().post("/maps/api/place/add/json")
	    .then().assertThat().statusCode(200).extract().response().asString();
	
   	System.out.println(resp);
   	System.out.println("fvifnncfn");
	System.out.println("fvifnncfnmvmvj");
	System.out.println("fviffjdfj");
	System.out.println("fvifnrmrjrj");
	System.out.println("fvifnrmrjrj");
	System.out.println("fvifnrmrjrj");
	System.out.println("fvifnrmrjrj");
	System.out.println("fvifnrmrjrj");
	
	}

}
