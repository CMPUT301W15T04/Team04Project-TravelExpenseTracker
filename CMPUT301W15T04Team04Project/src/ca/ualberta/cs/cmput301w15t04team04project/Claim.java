package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;
import java.util.Date;

public class Claim {
	protected String claimname;
	protected Date startdate;
	protected Date enddate;
	protected ArrayList<Tag> taglist;
	protected ArrayList<Destination> destinations;
	protected ArrayList<Listener> listener;
	
	public Claim(String claimname) {
		// TODO Auto-generated constructor stub
		
	}

	public void remove(Item item) {
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

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public void setDescription(String claimdescription) {
		// TODO Auto-generated method stub
		
	}

}
