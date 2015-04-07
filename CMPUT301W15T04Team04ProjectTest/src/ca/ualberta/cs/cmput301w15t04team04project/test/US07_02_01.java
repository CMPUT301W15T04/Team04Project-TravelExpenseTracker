package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;
import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;


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
		controll.getClaim().setClaimiant("Claimant");
		controll.getClaim().setClLocation(null);
		controll.getClaim().setDescription("Europe");
		controll.getClaim().setStartDate(new Date());
		controll.getClaim().setEndDate(new Date());
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("texi");
		ArrayList<Destination> destinations = new ArrayList<Destination>();
		Destination dest = new Destination("Paris");
		destinations.add(dest);
		controll.getClaim().setDestination(destinations);
		controll.getClaim().setTag(tags);
		assertEquals("it is complete",true, controll.checkComplete());
	}
}

