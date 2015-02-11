package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.Item;
import junit.framework.TestCase;

public class Claims_Overall_Test extends TestCase {

	public void testClaim() {
		String claimname = "Test";
		Claim claim = new Claim(claimname);
		claim.setStartdate(new Date());
		claim.setEnddate(new Date());
		String claimdescription = "Test";
		claim.setDescription(claimdescription);

	}

	public void testStatus() {
		String claimname = "Test";
		Claim claim = new Claim(claimname);
		String status = claim.getStatus();
		claim.setStatus();
		assertTrue(status.equals(claim.getStatus()));

	}


}