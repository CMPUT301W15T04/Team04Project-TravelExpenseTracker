package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.io.IOException;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;


public class US07_05_01 extends ActivityInstrumentationTestCase2<OneClaimActivity> {
	private OneClaimController controller;
	public US07_05_01() {
		super(OneClaimActivity.class);
	}
	
	public void testStatusApproved() throws IllegalStateException, IOException {
		CLmanager manager = new CLmanager();
		Claim claim = new Claim("testClaim");
		controller = new OneClaimController(claim);
		User user = new User("test");
		claim.setClaimiant(user.getName());
		manager.insertClaim(claim);
		controller.addComment("nice");
		manager.updateClaim(controller.getClaim());
		Claim getclaim = manager.getClaim("testClaim");
		assertEquals("nice", getclaim.getComment().get(0));
	}
	
	
}
