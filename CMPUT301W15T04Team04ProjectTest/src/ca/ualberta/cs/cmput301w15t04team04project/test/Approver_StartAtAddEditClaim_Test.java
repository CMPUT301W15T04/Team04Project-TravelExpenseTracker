package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import android.app.AlertDialog;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.SignInActivity;
import ca.ualberta.cs.travel.R;
//us08.01.01
public class Approver_StartAtAddEditClaim_Test extends ActivityInstrumentationTestCase2<MainActivity>{

	private String ClaimName;
	private ListView claimlistview;
	
	public Approver_StartAtAddEditClaim_Test(Class<MainActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void test_inMainActivity(){
		String tname = "claimant_test";
		User claimiant = new User(tname);
		
		
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		AClaim.setClaimName("1");
		
		Date date = new Date();
		AClaim.setStartDate(date);

		Date endDate = new Date();
		AClaim.setEndDate(endDate);
		
		Destination testDestionation = new Destination("Paris","test");
		AClaim.addDestination(testDestionation);

		
		String aname = "approver_test";
		User approver = new User(aname);
		
		ListView listView = (ListView) findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.); //listView
		
	    AlertDialog dialog = MainActivity.getLastDialog(); // I create getLastDialog method in MyActivity class. Its return last created AlertDialog
	    if (dialog.isShowing()) {
	    	 try {
		listView.performItemClick(
				listView.getAdapter().getView(0, null, null),
		        0,
		        listView.getAdapter().getItemId(0));
			assertEquals(expected, actual)
		
	    	 }catch(Throwable e){
	    		 e.printStackTrace();
	    	 }
	    }

	    assertTrue("name is equal", testClaimList.getSubmittedClaimList()
				.get(0).getClaimName().toString().equals("1"));
		assertTrue("starting date is equal", testClaimList
				.getSubmittedClaimList().get(0).getStartDate().equals(date));
		assertTrue("ending date is equal", testClaimList
				.getSubmittedClaimList().get(0).getEndDate().equals(endDate));
		assertTrue("destionation is true",
				testClaimList.getSubmittedClaimList().get(0).getDestionation()
						.equals(testDestionation));
		
		
		
		TextView v = (TextView) activity.getWindow().getDecorView()
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.);
		assertTrue("Toast is shown", v.isShown());
		
		
		
		
	}
	
/*	public void testOpenMainActivity() {
		  // register next activity that need to be monitored.
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

		  // open current activity.
		  SignInActivity myActivity = getActivity();
		  
		  
		  
		  final Button button = (Button) myActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.signInButton);
		  myActivity.runOnUiThread(new Runnable() {
		    @Override
		    public void run() {
		      // click button and open next activity.
		      button.performClick();
		    }
		  });

		 
		  MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 1000);
		 
		  
		  
		  assertNotNull(nextActivity);
		  nextActivity .finish();
		}*/
	
}
