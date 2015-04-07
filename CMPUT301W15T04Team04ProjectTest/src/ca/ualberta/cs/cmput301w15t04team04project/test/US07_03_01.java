package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.io.IOException;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;


public class US07_03_01 extends ActivityInstrumentationTestCase2<OneClaimActivity> {
	private OneClaimController controller;
	
	public US07_03_01() {
		super(OneClaimActivity.class);
	}
	
	public void testStatusReturned() throws IllegalStateException, IOException {
		CLmanager manager = new CLmanager();
		Claim claimA = new Claim("testClaim");
		manager.insertClaim(claimA);
		controller = new OneClaimController(claimA);
		assertEquals("In Progress", controller.getClaim().getStatus());
		controller.submittedClaim();
		assertEquals("submitted", controller.getClaim().getStatus());
		manager.updateClaim(controller.getClaim());
		Claim claimB = manager.getClaim("testClaim");
		assertEquals("submitted", claimB.getStatus());
		controller.returnClaim();
		assertEquals("returned", controller.getClaim().getStatus());
		manager.updateClaim(controller.getClaim());
		Claim claimC = manager.getClaim("testClaim");
		assertEquals("returned", claimC.getStatus());
	}
}

