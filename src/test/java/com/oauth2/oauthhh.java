package com.oauth2;

import org.testng.annotations.Test;

import com.pojo.Webautomation;
import com.pojo.getcourseapiresponse;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class oauthhh {
	
	 
	
	@Test
	public void oauthatomation() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
	String resp =	given()
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust").log().all()
		
		.when().post("oauthapi/oauth2/resourceOwner/token")
		.then().log().all().extract().response().asString();
	     System.out.println(resp);
	     JsonPath js = new JsonPath(resp);
     String    accesstoken =	     js.getString("access_token");
	     System.out.println(accesstoken);
	     
	
	     RestAssured.baseURI ="https://rahulshettyacademy.com";
	getcourseapiresponse gc =		given().queryParam("access_token", accesstoken)
			.when().get("/oauthapi/getCourseDetails").as(getcourseapiresponse.class);
	        System.out.println(gc.getInstructor());
	        System.out.println(gc.getLinkedIn());
	        System.out.println(gc.getCourses().getWebAutomation().get(2).getCourseTitle());
	        
	      List<Webautomation> apicourse =  gc.getCourses().getWebAutomation();
	       for(int i=0;i<apicourse.size();i++) {
	    	if(   gc.getCourses().getWebAutomation().get(i).getCourseTitle().equalsIgnoreCase("Protractor")) {
	    		System.out.println(gc.getCourses().getWebAutomation().get(i).getPrice());
	    	}
	    	
	    	String expectednames[] = {"Selenium Webdriver Java","Cypress","Protractor"};
	    	
	    	ArrayList<String> actual = new ArrayList<String>();
	    	 List<Webautomation> apicourses =  gc.getCourses().getWebAutomation();
	    	for(int j=0;j<apicourses.size();j++) {
	    	actual.add(	apicourses.get(j).getCourseTitle());
	    
	    
	    	}
	    	List<String> expected =	Arrays.asList(expectednames);
	    	System.out.println(expected);
		    System.out.println(actual);
		    Assert.assertEquals(actual,expected);
	    	 
	    	
	    	
	    	   
	       }
	     
	     
	}
	

}
