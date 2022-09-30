package bdd.CRUDOperations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjectsTest 
{
	@Test
	public void getAllProjects()
	{
		baseURI="http://localhost";
		port=8084;
		
		
		when().get("/projects")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}
