package ca.ualberta.cs.cmput301w15t04team04project.test;

import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import junit.framework.TestCase;

public class Claims_Status_Test extends TestCase{

	public void testGetApprover(){
		Claim claim = new Claim("Test");
		claim.setApprover("Jack");
		assertTrue("The approver is not matched", claim.getApprover().equals("Jack"));
	}
	public void testEditable(){
		Claim claim = new Claim("Test");
		if (claim.getStatus().toString().equals("submitted")){
			assertTrue("A claim with submitted status should not be editable", claim.getEditable() == false);
		}else if (claim.getStatus().toString().equals("for approval")){
			assertTrue("A claim with for approval status should be editable", claim.getEditable() == true);
		}else if (claim.getStatus().toString().equals("returned")){
			assertTrue("A claim with submitted status should be editable", claim.getEditable() == true);
		}
		
	}

}
