package ca.ualberta.cs.cmput301w15t04team04project.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;


public class US07_02_01 extends ActivityInstrumentationTestCase2<OneClaimActivity> {
	private OneClaimController controll;
	private OneClaimActivity activity;
	public US07_02_01() {
		super(OneClaimActivity.class);
	}
	protected void setUp() throws Exception
	{
		//super.setUp();
		//activity = (OneClaimActivity) getActivity();
		
	}
	public void testSubmitWarning() {
		Claim claim = new Claim("testClaim");
		controll = new OneClaimController(claim);
		assertEquals("it is not complete",false, controll.checkComplete());
	}
}

