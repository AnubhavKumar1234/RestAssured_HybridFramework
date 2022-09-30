package Authentications;

import org.testng.annotations.Test;

import Parameters.FormParameter;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0Authentication 
{
	@Test
	public void oauth2Auth()
	{
		baseURI="http://coop.apps.symfonycasts.com";
		
 Response resp = given()
		  .formParam("client_id", "Anubhav2.0")
		  .formParam("client_secret","48cb2b977171715a3b655321e932667f")
		  .formParam("grant_type", "client_credentials")
		  .formParam("redirect_uri","http://ak.com")
		  .formParam("code","authorization_code")
		
		  .when()
		  .post("/token");
 
  String  token=resp.jsonPath().get("access_token");
  System.out.println(token);
  
  
  given()
  .pathParam("USER_ID",3854)
  .auth()
  .oauth2(token)
  .when()
  .post("/api/{USER_ID}/eggs-collect")
  .then().log().all();
		
	}

}
