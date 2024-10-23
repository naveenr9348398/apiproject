package com.graphql;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert; 

public class queries {
	
	public static void main(String[] args) {
		int charid = 9905;
	String response =	given().header("Content-Type","application/json")
		.body("{\"query\":\"query($locationId:Int!,$characterId:Int!){\\n  location(locationId:$locationId){\\n    id\\n    name\\n    type\\n    dimension\\n  }\\n  \\n  character(characterId:$characterId){\\n    id\\n    name\\n    type\\n    status\\n    species\\n  }\\n  \\n  episode(episodeId:11116){\\n    id\\n    name\\n    air_date\\n    episode\\n  }\\n  \\n  locations(filters:{name:\\\"USA\\\"}){\\n    info{\\n      count\\n    }\\n  }\\n  \\n  episodes(filters:{name:\\\"the beginning of the end\\\",episode:\\\"4x01\\\"}){\\n    info{\\n      count\\n    }\\n    result{\\n      id\\n      name\\n      air_date\\n      episode\\n      characters{\\n        id\\n        name\\n        \\n      }\\n      created\\n    }\\n  }\\n  \\n}\",\"variables\":{\"locationId\":14729,\"characterId\":"+charid+"}}")

        .when().post("https://rahulshettyacademy.com/gq/graphql?")
        .then().extract().response().asString();
	
	System.out.println(response);
	JsonPath js = new JsonPath(response);
String name =	js.get("data.location.name");
Assert.assertEquals(name, "USA");
	}
}
