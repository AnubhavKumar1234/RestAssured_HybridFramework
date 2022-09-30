package DifferentWaysToPost;

import org.testng.annotations.Test;

import POJOLibraries.ProjectLibraries;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectUsingPOJO 
{
	@Test
	public void createProject()
	{
		baseURI="http://localhost";
		port=8084;
		Random ran=new Random();
		ProjectLibraries plib=new ProjectLibraries("Abhinav","HOTELVISION"+ran.nextInt(100) ,"Created" ,20 );
		
		
		given()
		.body(plib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}

}
