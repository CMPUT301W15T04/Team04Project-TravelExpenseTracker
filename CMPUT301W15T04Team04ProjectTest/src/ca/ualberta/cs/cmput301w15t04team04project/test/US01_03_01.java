package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;
import java.util.Date;

import android.app.AlertDialog;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

public class US01_03_01 extends ActivityInstrumentationTestCase2<OneClaimActivity> {
	public OneClaimActivity thisActivity;
	public ClaimEditController controller;
	public OneClaimController controller1;
	public User claimiant;
	public ArrayList<Item> items;

	public US01_03_01() {
		super(OneClaimActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		thisActivity = (OneClaimActivity) getActivity();
		controller1 = new OneClaimController();
	}
	
/*	public void test(){
		assertNotNull(thisActivity);
        
        claimiant = new User("testclaimiant");
        Claim testClaim = new Claim("test");
        Date date1 = new Date();
        date1.setYear(1999);
        testClaim.setStartDate(date1);
        Date date2 = new Date();
        date2.setYear(2000);  
        testClaim.setEndDate(date2);
        controller.setClaimObj(testClaim);
        
        ArrayList<Destination> destinations = new ArrayList<Destination>();
        Destination destination1 = new Destination("Edmonton");
        destination1.setdReason("test1");
        destinations.add(destination1);
        
        Destination destination2 = new Destination("Ca");
        destination2.setdReason("test2");
        destinations.add(destination2);
        
        ArrayList<String> comments = new ArrayList<String>();

        controller.setClaim("test", "", "", date1, date2, destinations, "testclaimiant", items,comments);

        Date startDate = new Date();
        startDate = testClaim.getStartDate();
        Date endDate = new Date();
        endDate = testClaim.getEndDate();
        
        assertEquals("Start Date is equall",startDate,date1);
        assertEquals("End Date is equall",endDate,date1);
	
        Destination destinationA = testClaim.getDestination().get(0);
        Destination destinationB = testClaim.getDestination().get(1);
        
        assertEquals("destination1 is equall",destinationA.getdName(),destination1.getdName());
        assertEquals("destination1 is equall",destinationB.getdName(),destination2.getdName());
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MyClaimActivity.class.getName(), null, false);

		OneClaimActivity thisActivity = (OneClaimActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 1000);

		AlertDialog.Builder adb = new AlertDialog.Builder(thisActivity);

	    //where to find the submitted id
		LayoutInflater factory = LayoutInflater.from(thisActivity);

		View claimInfoCDialogView = factory.inflate(
				R.layout.activity_claim_detail, null);
		thisActivity.showClaimDetailC(claimInfoCDialogView);
        
		Instrumentation inst = getInstrumentation();
	    //Wait for going to the dialog finish		
	    inst.waitForIdleSync();
	    
	    TextView claimName = (TextView) claimInfoCDialogView
				.findViewById(R.id.currentClaimNameATextView);
	    TextView startDate = (TextView) claimInfoCDialogView
				.findViewById(R.id.currentClaimSDATextView);
	    TextView endDate = (TextView) claimInfoCDialogView
				.findViewById(R.id.currentClaimEDATextView);
	    TextView state = (TextView) claimInfoCDialogView
				.findViewById(R.id.currentClaimStatusATextView);
	    
	    assertEquals("claimName shows", claimName.getText().toString(),"test");
	    assertEquals("status is equal", state.getText().toString(),"Progress");
		
	}
	*/
}
