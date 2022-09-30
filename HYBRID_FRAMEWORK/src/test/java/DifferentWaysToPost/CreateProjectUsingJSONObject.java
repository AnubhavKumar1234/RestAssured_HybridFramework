package DifferentWaysToPost;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJSONObject 
{
	@Test
	public void createProject()
	{
		Random ran=new Random();
		int random = ran.nextInt();
		
		baseURI="http://localhost";
		port=8084;
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "LIger");
		obj.put("projectName", "DarkKing"+random);
		obj.put("status", "Created");
		obj.put("teamSize", 40);
		
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
