package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import junit.framework.TestCase;

public class Claims_Overall_Test extends TestCase {

	public void testClaim() {
		String claimname = "Beijing";
		Claim claim = new Claim(claimname);
		claim.setStartdate(new Date());
		claim.setEnddate(new Date());
		String claimdescription = "test";
		claim.setDescription(claimdescription);
		
		
		
	}

}
