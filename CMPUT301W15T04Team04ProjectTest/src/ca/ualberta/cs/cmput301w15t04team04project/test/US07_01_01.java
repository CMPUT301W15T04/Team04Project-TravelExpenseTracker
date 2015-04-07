package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.io.IOException;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;

public class US07_01_01 extends
		ActivityInstrumentationTestCase2<OneClaimActivity> {
	private OneClaimController controll;

	public US07_01_01() {
		super(OneClaimActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSubmitApprover() throws IllegalStateException, IOException {
		CLmanager manager = new CLmanager();
		Claim claimA = new Claim("testClaim");
		manager.insertClaim(claimA);
		controll = new OneClaimController(claimA);
		assertEquals("In Progress", controll.getClaim().getStatus());
		controll.submittedClaim();
		assertEquals("submitted", controll.getClaim().getStatus());
		manager.updateClaim(controll.getClaim());
		Claim claimB = manager.getClaim("testClaim");
		assertEquals("submitted", claimB.getStatus());
	}
}
