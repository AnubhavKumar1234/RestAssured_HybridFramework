package DifferentWaysToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingHashMap 
{
	@Test
	public void createProject()
	{
		baseURI="http://localhost";
		port=8084;
		HashMap map=new HashMap();
		map.put("createdBy","MystryBoy");
		map.put("projectName","Venom");
		map.put("status","Created");
		map.put("teamSize",50);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
