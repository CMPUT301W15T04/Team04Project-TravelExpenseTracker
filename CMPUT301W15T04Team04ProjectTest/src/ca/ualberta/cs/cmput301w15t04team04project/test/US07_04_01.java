package ca.ualberta.cs.cmput301w15t04team04project.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;


public class US07_04_01 extends ActivityInstrumentationTestCase2<OneClaimActivity> {
	OneClaimController controll;
	
	public US07_04_01() {
		super(OneClaimActivity.class);
	}
	
	public void ClaimStatusApproved() {
		Claim claim = new Claim("testClaim");
		controll = new OneClaimController(claim);
		assertEquals("In Progress", controll.getClaim().getStatus());
		controll.submittedClaim();
		assertEquals("submitted", controll.getClaim().getStatus());
		controll.approveClaim();
		assertEquals("approved", controll.getClaim().getStatus());
	}
}

