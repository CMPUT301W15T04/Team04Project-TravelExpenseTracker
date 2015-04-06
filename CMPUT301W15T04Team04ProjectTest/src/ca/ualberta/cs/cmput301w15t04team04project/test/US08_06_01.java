package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;
import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ItemListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.app.AlertDialog;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.test.ActivityInstrumentationTestCase2;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import junit.framework.TestCase;

public class US08_06_01 extends ActivityInstrumentationTestCase2<MyClaimActivity>{
	private MyClaimActivity thisActivity;
	private MyLocalClaimListManager manager;
	private ClaimEditController controller;
	private OneClaimController itemcontroller;
	private Claim claim ;
	private Item item;
	private ItemListAdapter itemListAdapter;
	private User approver;
	private User claimiant;
	
	public US08_06_01() {
		super(MyClaimActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		thisActivity = (MyClaimActivity) getActivity();
		claim = new Claim("test");
		controller = new ClaimEditController();
		controller.setClaimObj(claim);
	}

	public void testPreConditions(){
        assertNotNull(thisActivity);
        claim.setClaimiant("testClaimiant");
        claim.setStatus("Submitted");
        controller.setClaimObj(claim);
        item = new Item("AItem");
        approver = new User("approver");
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(item);
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("reason of approve "+approver.getName());
        Date date1 = new Date();
        date1.setYear(1999);
        Date date2 = new Date();
        date2.setYear(2000);  
        controller.setClaim("test", "", "", date1, date2, null, "testClaimiant", items, comments);
        claim.setStatus("Approved");
        
        assertTrue("comments are equal", claim.getComment().equals(comments));
        assertTrue("status are approved", claim.getStatus().equals("Approved"));
	}
	
	public void test(){
		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MyClaimActivity.class.getName(), null, false);
		
		ListView listView = (ListView) thisActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView); //listView
		
		MyClaimActivity myActivity = getActivity();


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
		OneClaimActivity nextActivity = (OneClaimActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 1000);

		AlertDialog.Builder adb = new AlertDialog.Builder(nextActivity);

	    //where to find the submitted id
		LayoutInflater factory = LayoutInflater.from(nextActivity);

		View claimInfoCDialogView = factory.inflate(
				R.layout.activity_claim_detail_a, null);
		nextActivity.showClaimDetailC(claimInfoCDialogView);
		
		AlertDialog.Builder alBuilder = new AlertDialog.Builder(nextActivity);
        alBuilder
                .setMessage("Do you wamt to exit?")
                .setNeutralButton("Yes",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                    int which) {
                                dialog.cancel();
                                // Write your code here for Yes
                            }
                        })
                ;
        
        alBuilder.setCancelable(false);
        alBuilder.show();
		
	    Instrumentation inst = getInstrumentation();
	    //Wait for going to the dialog finish		
	    inst.waitForIdleSync();
	    
	    
        
		assertNotNull(nextActivity);
		nextActivity.finish();
	    
		assertEquals("States are equal", "Submitted", claim.getStatus());
		
	}
	


}
