package Authentications;

import static  io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuthenticatons 
{
	@Test
	public void basicAuthenticatons()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
		.auth()
		.basic("rmgyantra", "rmgy@9999")
		.when()
		.get("/login")
		.then().log().all();
	}
	
	@Test
	public void digestiveAuthenticatons()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
		.auth()
		.digest("rmgyantra", "rmgy@9999")
		.when()
		.get("/login")
		.then().log().all();
	}
	
	@Test
	public void preemptiveAuthenticatons()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
		.auth()
		.preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("/login")
		.then().log().all();
	}

}
