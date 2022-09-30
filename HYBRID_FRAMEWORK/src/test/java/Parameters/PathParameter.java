package Parameters;

import static  io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameter 
{
	@Test
	public void pathParameter()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.pathParam("pjid","TY_PROJ_1204")
		.when()
		.get("/projects/{pjid}")
		.then().assertThat().statusCode(200).log().all();
	}

}
