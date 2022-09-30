package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDes.StudentDetails;

public class ArraySerialization 
{
	@Test
	public void SerializationTest() throws JsonGenerationException, JsonMappingException, IOException 
	{
	
	int[] arr = {98456,78688};
	String[] name= {"Anubhav","Singh"};
	String[] Email= {"kumaranubhav@847gmail.com","King@123.com","vision@234"};

	StudentDetails sdt=new StudentDetails(124,name, arr, Email,"Bangalore");
	
	ObjectMapper obj = new ObjectMapper();
	obj.writeValue(new File(".\\Array.json"), sdt);
	}

}
