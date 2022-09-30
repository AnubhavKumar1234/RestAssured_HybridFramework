package basic_CRUDOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest 
{
	@Test
	public void updateProject()
	{
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "KING");
		obj.put("projectName", "C-SDET39.03");
		obj.put("status", "Completed");
		obj.put("teamSize", 20);
		
		RequestSpecification req = RestAssured.given();
		req.body(obj);
		req.contentType(ContentType.JSON);
		Response res = req.put("http://localhost:8084/projects/TY_PROJ_1402");
		
		System.out.println(res.statusCode());
		System.out.println(res.getBody());
	}

}
