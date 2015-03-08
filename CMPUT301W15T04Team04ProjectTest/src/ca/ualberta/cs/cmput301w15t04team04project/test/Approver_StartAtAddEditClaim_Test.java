package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.graphics.Bitmap;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.SignInActivity;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

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
		//precondition
		
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

		AClaim.setApproverName("previous_approver");
		
		//basic flow
		
		String aname = "approver_test";
		User approver = new User(aname);
		
		Activity activity = getActivity();
		
		ListView listView = (ListView) activity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.MainClaimListView); //listView
		
	    try {
		listView.performItemClick(
				listView.getAdapter().getView(0, null, null),
		        0,
		        listView.getAdapter().getItemId(0));
				//assertEquals(expected, actual);

	    	 }catch(Throwable e){
	    		 e.printStackTrace();
	    	 }
	    	 
	    	 
	    // might need sync or delay
	    Instrumentation inst = getInstrumentation();
	    //Wait for going to the dialog finish		
	    inst.waitForIdleSync();
	    //the dialog shows up
	    View dialog = activity.getFragmentManager().findFragmentByTag("tag").getView();
	    
	    
	    
	    TextView Itemnametextview = (TextView) dialog.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.MainDialogItemNameTextView);
		assertTrue("name is shown", Itemnametextview.isShown());
		TextView amounttextview = (TextView) dialog.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.MainDialogAmountTextView);
		assertTrue("Toast is shown", amounttextview.isShown());
		TextView StartingDateTextView = (TextView) dialog.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.MainDialogStartingDateTextView);
		assertTrue("starting date shown", StartingDateTextView.isShown());
		TextView EndingDateTextView = (TextView) dialog.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.MainDialogEndingDateTextView);
		assertTrue("category is shown", EndingDateTextView.isShown());
		TextView ApproverNameTextView = (TextView) dialog.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.MainDialogApproverNameTextView);
		assertTrue("Toast is shown", ApproverNameTextView.isShown());
		
		//Button imageButton = (Button) dialog.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.MainDialogReciptButton);
		//assertTrue("picutre shows", imageButton.isShown());

		
		assertTrue("name is equal", Itemnametextview.toString().equals("1"));
		assertTrue("starting date is equal", amounttextview.equals(date));
		assertTrue("ending date is equal", DateTextView.equals(endDate));
	}
		
		//assertTrue("destionation is true",testClaimList.getSubmittedClaimList().get(0).getDestionation().equals(testDestionation));
		
	  /*  assertTrue("name is equal", testClaimList.getSubmittedClaimList()
				.get(0).getClaimName().toString().equals("1"));
		assertTrue("starting date is equal", testClaimList
				.getSubmittedClaimList().get(0).getStartDate().equals(date));
		assertTrue("ending date is equal", testClaimList
				.getSubmittedClaimList().get(0).getEndDate().equals(endDate));
		assertTrue("destionation is true",
				testClaimList.getSubmittedClaimList().get(0).getDestionation()
						.equals(testDestionation));*/
		
		
		
		//TextView v = (TextView) activity.getWindow().getDecorView()
		//		.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.);
		//assertTrue("Toast is shown", v.isShown());
		
		
		
		
	
	
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
