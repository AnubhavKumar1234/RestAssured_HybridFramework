package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDes.EmployeeDetails;

public class Serialization 
{
	@Test
	public void SerializationTest() throws JsonGenerationException, JsonMappingException, IOException
	{
		EmployeeDetails emp=new EmployeeDetails("Anubhav",24568,"TY456","d@ty.com",true);
		
		ObjectMapper obj=new ObjectMapper();
		
		obj.writeValue(new File(".\\Emp.json"), emp);
		
		
	}

}
