package ca.ualberta.cs.cmput301w15t04team04project.test;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;
import ca.ualberta.cs.cmput301w15t04team04project.FragmentMoments;
import ca.ualberta.cs.cmput301w15t04team04project.FragmentProfile;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import junit.framework.TestCase;

public class US08_03_01UITest extends ActivityInstrumentationTestCase2<MainActivity> {

	private ListView claimlistview;
    private MainActivity thisActivity;
	private FragmentProfile profilefragment;
	private FragmentMoments momentfragment;
    
	public US08_03_01UITest() {
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
	
	public void testPreConditions() {
        assertNotNull(thisActivity);
        assertNotNull(momentfragment);
        
        
    }
	
	protected void AllClaimDetailsUItest(){
		ListView listView = (ListView) thisActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView); //listView

		
		
	}
	
/*	private Fragment startFragment(Fragment fragment) {
	      FragmentTransaction transaction = mActivity.getSupportFragmentManager().beginTransaction();
	      transaction.add(R.id.activity_test_fragment_linearlayout, fragment, "tag");
	      transaction.commit();
	      getInstrumentation().waitForIdleSync();
	      Fragment frag = mActivity.getSupportFragmentManager().findFragmentByTag("tag");
	      return frag;
	    }*/
}
