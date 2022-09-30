package basic_CRUDOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest 
{
	@Test
	public void createProjectTest()
	{
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "Singh");
		obj.put("projectName", "C-SDET39.03");
		obj.put("status", "On Going");
		obj.put("teamSize", 20);
		
		RequestSpecification request= RestAssured.given();
		 request.body(obj);
		 request.contentType(ContentType.JSON);
		 
		 Response resp = request.post("http://localhost:8084/addProject");
		 
		 System.out.println(resp.getContentType());
		 System.out.println(resp.getStatusCode());
		 System.out.println(resp.getTime());
		 
		 System.out.println(resp.asString());
		 System.out.println(resp.prettyPrint());
		 System.out.println(resp.prettyPeek());
		 ValidatableResponse validate = resp.then();
		 
		 System.out.println(validate.log().all());
		 
		
		
	}
	

}
