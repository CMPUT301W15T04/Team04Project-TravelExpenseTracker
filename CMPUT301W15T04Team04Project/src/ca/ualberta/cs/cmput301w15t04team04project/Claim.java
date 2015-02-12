package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;
import java.util.Date;

public class Claim {
	protected String claimName;
	protected Date startDate;
	protected Date endDate;
	protected String status;
	protected String description;
	protected ArrayList<Tag> tagList;
	protected ArrayList<Destination> destinations;
	protected ArrayList<Listener> listener;
	protected Approval approver;
	protected boolean editable = true;


	public Claim(String claimname) {
		// TODO Auto-generated constructor stub

	}

	public Approval getApprover() {
		return approver;
	}

	public void setApproval(Approval approver) {
		
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

	public String getClaimName() {
		return claimName;
	}

	public void setClaimName(String claimName) {
		this.claimName = claimName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setDescription(String claimDescription) {
		// TODO Auto-generated method stub

	}

	public String getStatus() {
		return null;
		// TODO Auto-generated method stub
	}

	public void setStatus(String status) {
		// TODO Auto-generated method stub

	}

	public String getDescription() {
		return null;
		// TODO Auto-generated method stub

	}

	public boolean getEditable() {

		return editable;
	}
	public void setEditable(){
		// TODO Auto-generated method stub
	}

<<<<<<< HEAD

	public void setApprover(Approval approval) {
=======
	public void addDestination(Destination testDestionation) {
		// TODO Auto-generated method stub
		
	}

	public Destination getDestionation() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addItem(Item itemA) {
>>>>>>> c8797b1b6af44068c321fe70f89de6f916464271
		// TODO Auto-generated method stub
		
	}

<<<<<<< HEAD
=======
	public ArrayList<Item> getItemList() {
		// TODO Auto-generated method stub
		return null;
	}

>>>>>>> c8797b1b6af44068c321fe70f89de6f916464271
}
