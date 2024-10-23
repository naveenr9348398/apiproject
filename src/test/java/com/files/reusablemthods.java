package com.files;

import io.restassured.path.json.JsonPath;

public class reusablemthods {
	
	public static JsonPath rawtojson(String response) {
		JsonPath js1 = new JsonPath(response);
		return js1;
	}

}
