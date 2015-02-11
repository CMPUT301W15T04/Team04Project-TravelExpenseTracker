package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.Claim;

import junit.framework.TestCase;

public class Claims_Overall_Test extends TestCase {

	public void testClaim() {
		String claimname = "Test";
		Claim claim = new Claim(claimname);

	}

	public void testData() {
		String claimname = "Test";
		Claim claim = new Claim(claimname);
		claim.setStatus(claimname);
	
		assertTrue("Problems with getter and setter of status", claimname.equals(claim.getStatus()));
		claim.setStartDate(new Date());
		claim.setEndDate(new Date());
		String claimdescription = "Test";
		claim.setDescription(claimdescription);
		assertFalse("Problems with getter and setter of status", claimdescription.equals(claim.getDescription()));
	}


}