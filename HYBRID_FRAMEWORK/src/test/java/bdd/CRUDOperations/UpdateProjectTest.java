package bdd.CRUDOperations;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectTest 
{
	@Test
	public void updateProject()
	{
		baseURI="http://localhost";
		port=8084;
		
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "REBEL");
		obj.put("projectName", "MSSIONMANGAL2.0");
		obj.put("status", "Completed");
		obj.put("teamSize", 20);
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.put("/projects/TY_PROJ_1602")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}
