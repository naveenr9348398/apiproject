package com.ecommerceapi;

import org.testng.annotations.Test;

import com.pojo2.createorderresponse;
import com.pojo2.createordersrequestbody;
import com.pojo2.cretaeproductresponse;
import com.pojo2.loginbody;
import com.pojo2.loginresponsebody;
import com.pojo2.orders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ecommerceappapi {
	
	@Test
	public void ecommerce() {
		//login
String mess = "Login Successfully";		
loginbody lb = new loginbody();
lb.setUserEmail("naveen.rajasekaran99@gmail.com");
lb.setUserPassword("Naveenraj@123");
		
		
RequestSpecification req =	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
	.setContentType(ContentType.JSON).build();

RequestSpecification reqspec = given().spec(req).body(lb);
loginresponsebody res = reqspec.when().post("api/ecom/auth/login").then().log().all().extract().response().as(loginresponsebody.class);
String token =res.getToken();
System.out.println(token);
String userId = res.getUserId();
System.out.println(userId);
String message = res.getMessage();
System.out.println(message);
Assert.assertEquals(mess, message);

//createproduct
String mes = "Product Added Successfully";

RequestSpecification req1 =	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
.addHeader("Authorization", token).build();

RequestSpecification createproduct =    given().spec(req1)
.formParam("productName", "HP Laptop")
.formParam("productAddedBy", userId)
.formParam("productCategory", "electronics")
.formParam("productSubCategory", "laptop")
.formParam("productPrice", "5000")
.formParam("productDescription", "hp originals")
.formParam("productFor", "Everyone")
.multiPart("productImage", new File("C:\\Users\\navee\\eclipse-workspace\\Restassuredpractice1\\jpgfiles\\Screenshot 2024-10-08 095600.png"));

 cretaeproductresponse createresp =createproduct.when().post("api/ecom/product/add-product").then().log().all().extract().response().as(cretaeproductresponse.class);
String productid =createresp.getProductId();
System.out.println(productid);
String messagee = createresp.getMessage();
System.out.println(messagee);
Assert.assertEquals(mes, messagee);

//create order
createordersrequestbody cor = new createordersrequestbody();
orders o =new orders();
o.setCountry("India");
o.setProductOrderedId(productid);

List<orders> orderss = new ArrayList<orders>();
orderss.add(o);

cor.setOrders(orderss);
 



RequestSpecification req2 =	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").setContentType(ContentType.JSON)
.addHeader("Authorization", token).build();

RequestSpecification createordspec = given().spec(req2).body(cor);
String createordres = createordspec.when().post("api/ecom/order/create-order").then().log().all().extract().response().asString();
System.out.println(createordres);



//deleteproduct
RequestSpecification req3 =	new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").setContentType(ContentType.JSON)
.addHeader("Authorization", token).build();

RequestSpecification delspec = given().pathParam("productId", productid).
spec(req3);

delspec.when().delete("api/ecom/product/delete-product/{productId}").then().log().all();

System.out.println("fvifnrmrjrj");
System.out.println("fvifnrmrjrj");
System.out.println("fvifnrmrjrj");
System.out.println("fvifnrmrjrj");
System.out.println("fvifnrmrjrj");

























	}

}
