
package com.Basics;

import org.testng.annotations.Test;

import com.files.payload;

import io.restassured.path.json.JsonPath;

public class complexjsonparse {
	
	@Test
	public void compleeeex() {
	//print no of courses returned by API
		JsonPath js = new JsonPath(payload.complexjsonbody());
	int coursecount =	js.getInt("courses.size()");
	System.out.println(coursecount);
	
	//print purchase amount
int purchaseamount =	js.getInt("dashboard.purchaseAmount");
	System.out.println(purchaseamount);
	
	//print title of first course
String firstcourse =	js.getString("courses[0].title");
	System.out.println(firstcourse);
	
	//print all course titles and their respective prices
	for(int i=0;i<coursecount;i++) {
String courses = js.getString("courses["+i+"].title");
String price = js.getString("courses["+i+"].price");
System.out.println(courses);
System.out.println(price);
	}
	//print no of copies sold by cypress course
	for(int i=0;i<coursecount;i++) {
String coursetitles =		js.get("courses["+i+"].title");
		
		if(coursetitles.equalsIgnoreCase("Cypress")) {
	String copies =		js.getString("courses["+i+"].copies");
	System.out.println(copies);
	break;
		}
	}
	
	
	
	
	
	
	}

}
