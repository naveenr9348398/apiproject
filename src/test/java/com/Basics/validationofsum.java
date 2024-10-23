package com.Basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.files.payload;

import io.restassured.path.json.JsonPath;

public class validationofsum {

	@Test
	public void validation() {
		int sum =0;
		JsonPath js = new JsonPath(payload.complexjsonbody());
int count =		js.getInt("courses.size()");
for(int i=0;i<count;i++) {
int price =	js.getInt("courses["+i+"].price");
int copies =	js.getInt("courses["+i+"].copies");
int amount = copies*price;
System.out.println(amount);
sum = sum+amount;
}
System.out.println(sum);
int purchamount =js.getInt("dashboard.purchaseAmount");
Assert.assertEquals(sum, purchamount);









	}
}
