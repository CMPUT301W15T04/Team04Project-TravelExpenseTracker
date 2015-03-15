package ca.ualberta.cs.cmput301w15t04team04project.test;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;
import ca.ualberta.cs.cmput301w15t04team04project.FragmentMoments;
import ca.ualberta.cs.cmput301w15t04team04project.FragmentProfile;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import junit.framework.TestCase;
//resource from http://blog.denevell.org/android-testing-fragments.html
public class US08_03_01UITest extends ActivityInstrumentationTestCase2<MainActivity> {

	private ListView claimlistview;
    private MainActivity thisActivity;
	private FragmentProfile profilefragment;
	private FragmentMoments momentfragment;
    private MyLocalClaimListController controller;
	
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
        Claim Aclaim = new Claim("Aclaim");
        Aclaim.setStatus("Submitted");
        Claim Bclaim = new Claim("Bclaim");
        Bclaim.setStatus("Submitted");
        Claim Cclaim = new Claim("Cclaim");
        Cclaim.setStatus("Proceed");

        
        controller.addClaim(Aclaim);
        controller.addClaim(Bclaim);
        controller.addClaim(Cclaim);
    }
	
	protected void AllClaimDetailsUItest(){
		ListView listView = (ListView) thisActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView); //listView

		assertEquals("index 0 equals", listView.getChildAt(0).equals(AClaim));
		assertEquals("index 1 equals", listView.getChildAt(1).equals(BClaim));
		
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
