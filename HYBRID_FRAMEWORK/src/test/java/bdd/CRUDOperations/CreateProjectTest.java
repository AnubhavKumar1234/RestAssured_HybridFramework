package bdd.CRUDOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest 
{
	@Test
	public void createProject()
	{
		baseURI="http://localhost";
		port=8084;
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "REBEL");
		obj.put("projectName", "MSSIONMANGAL2.0");
		obj.put("status", "On Going");
		obj.put("teamSize", 30);
		
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then().assertThat().statusCode(201)
		.log().all();
		
		
	}
	

}
