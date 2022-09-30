package basic_CRUDOperations;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectsTest 
{
	@Test
	public void getAllProjects()
	{
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		int expectstatus=200;
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(actstatus, expectstatus);
		
	}

}
