package ca.ualberta.cs.cmput301w15t04team04project.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;

public class US02_01_01 extends ActivityInstrumentationTestCase2<MyClaimActivity> {
	public MyClaimActivity thisActivity;
	public ClaimEditController controller;
	public MyLocalClaimListController controller1;
	
	public US02_01_01()
	{

		super(MyClaimActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	protected void setUp() throws Exception
	{
		super.setUp();
		thisActivity = (MyClaimActivity) getActivity();
		controller = new ClaimEditController();
	}
}
