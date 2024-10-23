package com.libraryapi;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.files.payload;
import com.files.reusablemthods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class libraryyapii {
	
	@Test(dataProvider = "addbooksid")
	public void getlibrary(String isbn,String aisle) {
		
		RestAssured.baseURI ="http://216.10.245.166/";
		
	String response =	given().log().all()
		.header("Content-Type","application/json")
		.body(payload.addlibraryrequestpayload(isbn,aisle))
	
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(response);
	JsonPath js =    reusablemthods.rawtojson(response);
String bookid =	js.getString("ID");
System.out.println(bookid);

RestAssured.baseURI = "http://216.10.245.166";
given().log().all().queryParam("ID", bookid)
.when().get("Library/GetBook.php")
.then().log().all();




RestAssured.baseURI = "http://216.10.245.166";
given().body(payload.deletebody(bookid))
.when().post("/Library/DeleteBook.php")
.then().log().all();




	
	}
	
	
	
	
	@DataProvider(name = "addbooksid")
	public Object[][] getisbnandisledata() {
	return	new Object[][] {{"djdjn","902883"},{"cbcndjd","9383833"},{"djdjdjnd","39383834"},{"mnxxksks","393930930"}};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
