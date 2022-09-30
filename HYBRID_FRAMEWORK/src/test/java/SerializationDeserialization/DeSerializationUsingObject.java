package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDes.EmpDetailsObject;

public class DeSerializationUsingObject 
{
	@Test
	public void deserializationUsingObjectTest() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper obj = new ObjectMapper();
		EmpDetailsObject s = obj.readValue(new File("./SampleObject.json"),EmpDetailsObject.class);
		System.out.println(s.getAddress());
		System.out.println(s.getName());
		System.out.println(s.getSpouse());
	}

}
