package ca.ualberta.cs.cmput301w15t04team04project.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;

public class US08_05_01 extends ActivityInstrumentationTestCase2<OneClaimActivity>{
	private OneClaimActivity thisActivity;

	
	public US08_05_01() {
		super(OneClaimActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		thisActivity = (OneClaimActivity) getActivity();
		
	}
	
	
}
