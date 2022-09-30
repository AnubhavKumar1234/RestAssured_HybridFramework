package GenericLibraries;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BaseAPIClassWithSpecBuilders 
{
	public DatabaseLibrary dbLib=new DatabaseLibrary();
	public JavaLibrary jLib=new JavaLibrary();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();
	public RequestSpecification requestSpec;
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		dbLib.connectToDB();
		Reporter.log("******db connection successful******",true);
//		request spec builder is a class in rest assured library used to store common actionsrelated to request
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri(IConstantsLibrary.appUrl);
		builder.setPort(IConstantsLibrary.appPort);
		builder.setContentType(ContentType.JSON);
		 requestSpec = builder.build();
	}
	@AfterSuite
	public void asConfig() throws SQLException
	{
		dbLib.closeDB();
		Reporter.log("******connnection closed******",true);
//		response spec builder is a class in rest assured library used to store common actionsrelated to response
		ResponseSpecBuilder builder=new ResponseSpecBuilder();
		ResponseSpecBuilder responseSpec = builder.log(null);
		
		
	}
	

}
