package ResponseValidation;

import static  io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResponseTimeValidation 
{
	@Test
	public void responseTimeV()
	{
		baseURI="http://localhost";
		port=8084;
		
		
	          when()
				.get("/projects")
				.then()
				.assertThat().time(Matchers.lessThan(700L));
		
//		System.out.println(resp.getTime());
	}

}
