package com.files;

import org.testng.annotations.Test;

import com.Basics.Googlemapsrestassuredapi;

public class payload extends Googlemapsrestassuredapi {
	
	public static String addplacepayload() {
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -56.38455434,\r\n"
				+ "    \"lng\": 40.05948578\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Bigboss house\",\r\n"
				+ "  \"phone_number\": \"(+91) 05830295893095\",\r\n"
				+ "  \"address\": \"address bar super iot it\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"green park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"English-IN\"\r\n"
				+ "}";
	}
	
	public static String complexjsonbody() {
		return "{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 1250,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "  {\r\n"
				+ "\r\n"
				+ "\"title\": \"api testing\",\r\n"
				+ "\r\n"
				+ "\"price\": 34,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}";
	}
	
	public static String addlibraryrequestpayload(String isbn, String aisle) {
		String payload = "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}";
		return payload;
	}
	
	public static String deletebody(String bookid) {
		return "{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+bookid+"\"\r\n"
				+ " \r\n"
				+ "} \r\n"
				+ "";
	}
	
	
	
	
	
	

	}


