package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDes.EmployeeDetails;

public class Deserialization 
{
	@Test
	public void deserializationTest() throws JsonParseException, JsonMappingException, IOException
	{
		
		ObjectMapper obj=new ObjectMapper();
		
		EmployeeDetails emp = obj.readValue(new File(".\\Emp.json"),EmployeeDetails.class);
		
		System.out.println(emp.getEmail());
		System.out.println(emp.getName());
	}

}
