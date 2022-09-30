package End2EndScenario;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericLibraries.BaseAPIClass;
import GenericLibraries.BaseAPIClassWithSpecBuilders;
import GenericLibraries.EndPointsLibrary;
import GenericLibraries.IConstantsLibrary;
import POJOLibraries.ProjectLibraries;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateProjectAndVerifyInDB extends BaseAPIClassWithSpecBuilders
{
	@Test
	public void createProject() throws SQLException
	{
		ProjectLibraries plib=new ProjectLibraries("Khusi","HLVISION"+jLib.getRandomNumber() ,"Created" ,20 );
		
		Response resp = given()
				.spec(requestSpec)
		        .body(plib)
//		  .contentType(ContentType.JSON)
		  
		       .when()
		       .post(EndPointsLibrary.createProject);
		resp.then().log().all();
		
		String expData = rLib.getJsonData(resp,"projectId");
		System.out.println(expData);
		
		String query="select * from project;";
		String actData = dbLib.executeQueryAndReturnData(query, 1, expData);
		Assert.assertEquals(actData,expData);
		
	}

}
