package RequestChaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import POJOLibraries.ProjectLibraries;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateGetAndDelete 
{
	@Test
	public void createGetAndDeleteOperation()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		Random ran= new Random();
		ProjectLibraries pLib = new ProjectLibraries("Ayush", "Central"+ran.nextInt(),"Created",20);
		
		Response resp = given()
		.body(pLib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
	String	projectID=resp.jsonPath().get("projectId");
	
	System.out.println(projectID);
	given()
	.pathParam("pid",projectID)
	.when()
//	.get("/projects/"+projectID)
	.get("/projects/{pid}");
	given()
	.pathParam("pid",projectID)
	.when()
	.delete("/projects/{pid}")
	.then()
	.assertThat().statusCode(204).log().all();
		
		
	}

}
