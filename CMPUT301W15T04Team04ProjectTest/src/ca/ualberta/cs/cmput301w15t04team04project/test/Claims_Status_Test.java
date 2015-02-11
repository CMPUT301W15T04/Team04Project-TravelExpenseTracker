package ca.ualberta.cs.cmput301w15t04team04project.test;

import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import junit.framework.TestCase;

public class Claims_Status_Test extends TestCase{

	public void testGetApprover(){
		Claim claim = new Claim("Test");
		claim.setApprover("Jack");
		assertTrue("The approver is not matched", claim.getApprover().equals("Jack"));
	}
	
}
