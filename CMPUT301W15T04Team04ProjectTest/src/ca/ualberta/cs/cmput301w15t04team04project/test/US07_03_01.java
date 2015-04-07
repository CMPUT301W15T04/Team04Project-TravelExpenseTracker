package ca.ualberta.cs.cmput301w15t04team04project.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;


public class US07_03_01 extends ActivityInstrumentationTestCase2<OneClaimActivity> {
	private OneClaimController controller;
	
	public US07_03_01() {
		super(OneClaimActivity.class);
	}
	
	public void testStatusReturned() {
		Claim claim = new Claim("testClaim");
		controller = new OneClaimController(claim);
		assertEquals("In Progress", controller.getClaim().getStatus());
		controller.submittedClaim();
		assertEquals("submitted", controller.getClaim().getStatus());
		controller.returnClaim();
		assertEquals("returned", controller.getClaim().getStatus());

	}
}

