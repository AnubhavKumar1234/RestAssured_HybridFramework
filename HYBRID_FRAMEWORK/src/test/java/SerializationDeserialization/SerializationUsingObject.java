package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDes.EmpDetailsObject;
import practice_POJO_SerDes.Spouse;

public class SerializationUsingObject 
{
	@Test
	public  void SerializationUsingObjectTest() throws JsonGenerationException, JsonMappingException, IOException {
			
			int[] arr = {1234,12345};
			Spouse spouse = new Spouse("king", "forza", 123);
			
			EmpDetailsObject e3 = new EmpDetailsObject(3, "AnubhavSingh", arr, spouse, "banglore");
			
			ObjectMapper obj = new ObjectMapper();
			obj.writeValue(new File("./SampleObject.json"), e3);
		}

}
