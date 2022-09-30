package Authentications;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BearerToken 
{
	@Test
	public void bearerToken()
	{
		baseURI="https://api.github.com";
		
		JSONObject jobj=new JSONObject();
		jobj.put("name","SDET-REST");
		jobj.put("description","HybridFrwk");
		
		
		given()
		.auth()
		.oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("/user/repos")
		.then()
		.log().all();
	}

}
