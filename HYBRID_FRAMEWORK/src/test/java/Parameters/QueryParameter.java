package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter 
{
	
	@Test
	public void queryParameter()
	{
		baseURI = "http://reqres.in";
		
		given()
		.queryParam("page",2)
		.when()
		.get("/api/users")
		.then()
		.assertThat().statusCode(200).log().all();
	}

}
