package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.Claim;

import junit.framework.TestCase;

public class Claims_Overall_Test extends TestCase {

	public void testClaim() {
		String claimName = "Test";
		Claim claim = new Claim(claimName);

	}

	public void testData() {
		String claimName = "Test";
		Claim claim = new Claim(claimName);
		claim.setStatus(claimName);

		assertFalse("Problems with getter and setter of status",
				claimName.equals(claim.getStatus()));
		claim.setStartDate(new Date());
		claim.setEndDate(new Date());
		String claimdescription = "Test";
		claim.setDescription(claimdescription);
		assertFalse("Problems with getter and setter of description",
				claimdescription.equals(claim.getDescription()));
	}

}