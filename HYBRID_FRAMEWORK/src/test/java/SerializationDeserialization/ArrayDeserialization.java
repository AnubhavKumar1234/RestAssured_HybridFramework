package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDes.StudentDetails;

public class ArrayDeserialization 
{
	@Test
	public void deserializationTest() throws JsonParseException, JsonMappingException, IOException
	{
		
		ObjectMapper obj=new ObjectMapper();
		StudentDetails std1 = obj.readValue(new File(".\\Array.json"),StudentDetails.class);
		
		System.out.println(std1.getAddress());
		System.out.println(std1.getStdid());
	}

}
