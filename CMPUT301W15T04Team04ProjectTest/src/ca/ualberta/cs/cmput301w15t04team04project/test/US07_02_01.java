package ca.ualberta.cs.cmput301w15t04team04project.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;


public class US07_02_01 extends ActivityInstrumentationTestCase2<OneClaimActivity> {
	OneClaimController controll;
	
	public US07_02_01() {
		super(OneClaimActivity.class);
	}
	
	public void testSubmitWarning() {
		Claim claim = new Claim("testClaim");
		controll = new OneClaimController(claim);
		assertEquals(false, controll.checkComplete());
	}
}

