package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;
import java.util.Date;

public class Claim {
	protected String claimname;
	protected Date startdate;
	protected Date enddate;
	protected String status;
	protected String description;
	protected ArrayList<Tag> taglist;
	protected ArrayList<Destination> destinations;
	protected ArrayList<Listener> listener;
	
	public Claim(String claimname) {
		// TODO Auto-generated constructor stub
		
	}

	public void removeItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	public void addTag(String string) {
		// TODO Auto-generated method stub
		
	}

	public void findTag(String string) {
		// TODO Auto-generated method stub
		
	}

	
	public void removeTag(String string) {
		// TODO Auto-generated method stub
		
	}

	public String getClaimname() {
		return claimname;
	}

	public void setClaimname(String claimname) {
		this.claimname = claimname;
	}

	public Date getStartDate() {
		return startdate;
	}

	public void setStartDate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEndDate() {
		return enddate;
	}

	public void setEndDate(Date enddate) {
		this.enddate = enddate;
	}

	public void setDescription(String claimdescription) {
		// TODO Auto-generated method stub
		
	}

	public String getStatus() {
		return status;
	
	}


	public void setStatus(String status) {
		// TODO Auto-generated method stub
		
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}


}
