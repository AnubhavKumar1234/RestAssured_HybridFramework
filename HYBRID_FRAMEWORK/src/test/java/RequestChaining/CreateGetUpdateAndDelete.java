package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.testng.annotations.Test;

import POJOLibraries.ProjectLibraries;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateGetUpdateAndDelete 
{
	@Test
	public void createGetAndDelete()
	{
	baseURI = "http://localhost";
	port = 8084;
	
	Random ran= new Random();
	ProjectLibraries pLib = new ProjectLibraries("Pariniti", "Greenpark"+ran.nextInt(),"Created",10);
	
	Response resp = given()
	.body(pLib)
	.contentType(ContentType.JSON)
	.when()
	.post("/addProject");
	
String	projectID=resp.jsonPath().get("projectId");

System.out.println(projectID);

pLib.setStatus("On Going");
given()
.body(pLib)
.contentType(ContentType.JSON)
.pathParam("pid", projectID)
.when()
.put("/projects/{pid}")
.then()
.assertThat().statusCode(200)
.log().all();
given()
.pathParam("pid",projectID)
.when()
//.get("/projects/"+projectID)
.get("/projects/{pid}");


given()
.pathParam("pid",projectID)
.when()
.delete("/projects/{pid}")
.then()
.assertThat().statusCode(204).log().all();




	}

}
