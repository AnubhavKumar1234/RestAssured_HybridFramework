package ResponseValidation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationGet 
{
	@Test
	public void staticResponseGet()
	{
		String expData = "TY_PROJ_004";
		baseURI="http://localhost";
		port=8084;
		
		
		Response resp= when()
				.get("/projects");
		
		String actData = resp.jsonPath().get("[3].ProjectId");
		Assert.assertEquals(actData,expData);
		
		
		resp.then().log().all();
		
	}

}
