package practice_POJO_SerDes;

public class StudentDetails {
	
	int stdid;
	String[] name;
	int[] phno;
	String[] EmailId;
	String address;
	 	
	public StudentDetails(int id, String[] name, int[] phno, String[] EmailId ,String address) 
	{
	
		this.stdid = id;
		this.name = name;
		this.phno = phno;
		this.EmailId=EmailId;
		this.address = address;
	}
	
	public StudentDetails()
	{
		
		
	}

	public int getStdid() {
		return stdid;
	}

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public int[] getPhno() {
		return phno;
	}

	public void setPhno(int[] phno) {
		this.phno = phno;
	}

	public String[] getEmailId() {
		return EmailId;
	}

	public void setEmailId(String[] emailId) {
		EmailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	
	
	
}
