package ResponseValidation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation 
{
	@Test
	public void staticResponse()
	{
		
		baseURI="http://localhost";
		port=8084;
		
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "Rajesh");
		obj.put("projectName", "MISSION3.0");
		obj.put("status", "On Going");
		obj.put("teamSize", 30);
		
		String expData="MISSION3.0";
		
		
		Response resp = given()
		 .body(obj)
		 .contentType(ContentType.JSON)
		.when()
		  .post("/addProject");
		
		String actData = resp.jsonPath().get("projectName");
		Assert.assertEquals(actData,expData);
	

	}

}
