package ca.ualberta.cs.cmput301w15t04team04project.test;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.FragmentProfile;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;

public class US08_04_01 extends ActivityInstrumentationTestCase2<MainActivity> {
	private MainActivity thisActivity;
	private FragmentProfile profilefragment;

	

	public US08_04_01() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		thisActivity = (MainActivity) getActivity();
		profilefragment = (FragmentProfile) thisActivity.fragments.get(0);
		
	}
	
	public void testPreConditions(){
        assertNotNull(thisActivity);
        assertNotNull(profilefragment);		
        
        
        
	}
}
