package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation 
{
	@Test
	public void dynamicResponseV()
	{
		baseURI="http://localhost";
		port=8084;
		
		String expData = "TY_PROJ_003";
		
		Response res = when()
		.get("/projects");
		
		boolean flag=false;
		
		List<String> list= res.jsonPath().get("projectId");
		System.out.println(list);
		
		for(String actData:list)
		{
			if(actData.equalsIgnoreCase(expData))
			{
				System.out.println(actData);
				flag=true;
				break;
			}
		}
		
		Assert.assertTrue(flag);
		
//		if(flag)
//		{
//			System.out.println("Paased");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
		
	}

}
