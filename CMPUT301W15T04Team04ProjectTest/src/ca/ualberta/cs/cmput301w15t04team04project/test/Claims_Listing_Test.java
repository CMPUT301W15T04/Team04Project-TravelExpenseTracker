package ca.ualberta.cs.cmput301w15t04team04project.test;

import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import junit.framework.TestCase;

public class Claims_Listing_Test extends TestCase {
	
	
	
	public void testClaimList(){
		ClaimList claimlist = new ClaimList();
		
		String claimname = "Test";
		Claim testclaim = new Claim(claimname);
		
		claimlist.addClaim(testclaim);
		claimlist.getPosition(0);
		
	}
	
	

}
