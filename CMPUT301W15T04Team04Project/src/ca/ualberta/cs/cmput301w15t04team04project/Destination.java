package ca.ualberta.cs.cmput301w15t04team04project;



public class Destination {
	protected String destnName;
	protected String reason;


	public Destination(String name, String why) {
		// TODO Auto-generated constructor stub
		this.destnName = name;
		this.reason = why;
		
	}


	public String getDestnName() {
		return destnName;
	}


	public void setDestnName(String destnName) {
		this.destnName = destnName;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}
	
	

}
