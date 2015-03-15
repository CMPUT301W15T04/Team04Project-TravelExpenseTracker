package ca.ualberta.cs.cmput301w15t04team04project.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.FragmentProfile;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;

public class US08_04_01 extends ActivityInstrumentationTestCase2<OneClaimActivity> {
	private OneClaimActivity thisActivity;
	private FragmentProfile profilefragment;
	
	

	public US08_04_01() {
		super(OneClaimActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		thisActivity = (OneClaimActivity) getActivity();
		
	}
	
	public void testPreConditions(){
        assertNotNull(thisActivity);
        
        Claim claim = new Claim("AClaim");
        
	}
	
	
}
