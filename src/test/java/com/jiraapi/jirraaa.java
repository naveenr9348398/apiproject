package com.jiraapi;

import org.testng.annotations.Test;

import com.files.reusablemthods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class jirraaa {
	
	@Test
	public void jiraaapicalls() {
		
		RestAssured.baseURI = "https://naveenjiraa.atlassian.net/";
	String getresp =	given()
		.header("Content-Type","application/json")
		.header("Authorization","Basic bmF2ZWVuMDcwNDk5QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBFeGdYdGdqWkcyTk5XR3dSVHloUW5URlBiSldBMVR3d0Q5SUF5blAycXBXZzlIdTBYOTRfMThUUWZEMGtOaGpvVFpwSy1RdF93MmFFN0hfaWdDZkJpcl9JVWF0ZHhPcUVFWWZHNkpnWk9Xd0dSU2JGbFhnSFVFYl9FX1NSR25BMlUzRHA5Ykdody1pdld0WERUbV9Yck1ZdkYya0xrbl8tNFBvcEI0QVF2Nlk9REFERTIwNzQ=")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"website links not working in website code\",\r\n"
				+ "       \"description\": \"Crainer is an idiot for mocking jelly and kweb\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}").log().all()
		
		.when().post("rest/api/2/issue")
		.then().assertThat().statusCode(201).extract().response().asString();
		System.out.println(getresp);
JsonPath js =		reusablemthods.rawtojson(getresp);
String id =	js.getString("id");
System.out.println(id);

given()
.header("X-Atlassian-Token","no-check").pathParam("key", id)
.header("Authorization", "Basic bmF2ZWVuMDcwNDk5QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBFeGdYdGdqWkcyTk5XR3dSVHloUW5URlBiSldBMVR3d0Q5SUF5blAycXBXZzlIdTBYOTRfMThUUWZEMGtOaGpvVFpwSy1RdF93MmFFN0hfaWdDZkJpcl9JVWF0ZHhPcUVFWWZHNkpnWk9Xd0dSU2JGbFhnSFVFYl9FX1NSR25BMlUzRHA5Ykdody1pdld0WERUbV9Yck1ZdkYya0xrbl8tNFBvcEI0QVF2Nlk9REFERTIwNzQ=")
.multiPart("file",new File("C:\\Users\\navee\\eclipse-workspace\\Restassuredpractice1\\jpgfiles\\Screenshot 2024-10-08 095600.png"))
.log().all()
.when().post("rest/api/3/issue/{key}/attachments")
.then().assertThat().statusCode(200);


	}

}
