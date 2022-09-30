package DataDrivenTestingRestAssured;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POJOLibraries.ProjectLibraries;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjectWithDiffData 

{
	
	@Test(dataProvider = "getData")
	public void createProject(String createdBy, String projectName, String status, int teamSize)
	{ 
		
		//Prerequisties
		Random ran= new Random();
		ProjectLibraries pLib = new ProjectLibraries(createdBy, projectName+ran.nextInt(), status, teamSize);
		baseURI = "http://localhost";
		port = 8084;
		
		
		given()
		 .body(pLib)
		 .contentType(ContentType.JSON)
	   
		//Actions
		.when()
		 .post("/addProject")
		 
		//Validation
		.then().log().all();
		
		
	}
	
	@DataProvider(name = "getData")
	public Object[][] data()
	{
		Object[][] data = new Object[10][4];
		
		data[0][0] = "Chetna";
		data[0][1] = "DELL2.0";
		data[0][2] = "Completed";
		data[0][3] = 15;
		
		data[1][0] = "Shyam";
		data[1][1] = "HP2.0";
		data[1][2] = "Created";
		data[1][3] = 10;
		
		data[2][0] = "Ram";
		data[2][1] = "Dreamvision";
		data[2][2] = "On Going";
		data[2][3] = 30;
		
		data[3][0] = "Sneha";
		data[3][1] = "Strugglers2.0";
		data[3][2] = "On Going";
		data[3][3] = 30;
		
		data[4][0] = "Anubhav";
		data[4][1] = "TheVlogYatra";
		data[4][2] = "On Going";
		data[4][3] = 30;
		
		data[5][0] = "Monika";
		data[5][1] = "DataMAKER";
		data[5][2] = "On Going";
		data[5][3] = 20;
		
		data[6][0] = "Radha";
		data[6][1] = "Vrindawan";
		data[6][2] = "On Going";
		data[6][3] = 30;
		
		data[7][0] = "Bhavya";
		data[7][1] = "DreamChaser";
		data[7][2] = "On Going";
		data[7][3] = 30;
		
		data[8][0] = "Komal";
		data[8][1] = "visionCreater";
		data[8][2] = "On Going";
		data[8][3] = 50;
		
		data[9][0] = "Mohan";
		data[9][1] = "DreamMaker";
		data[9][2] = "On Going";
		data[9][3] = 40;
		
		
		return data;
	}

}
