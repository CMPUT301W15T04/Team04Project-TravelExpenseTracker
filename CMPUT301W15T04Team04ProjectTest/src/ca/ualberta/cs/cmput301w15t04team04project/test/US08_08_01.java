package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;
import java.util.Date;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.ListView;
import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ItemListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

public class US08_08_01 extends ActivityInstrumentationTestCase2<MyClaimActivity>{
	private MyClaimActivity thisActivity;
	private MyLocalClaimListManager manager;
	private ClaimEditController controller;
	private OneClaimController itemcontroller;
	private Claim claim ;
	private Item item;
	private ItemListAdapter itemListAdapter;
	private User approver;
	
	public US08_08_01() {
		super(MyClaimActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		thisActivity = (MyClaimActivity) getActivity();

		controller = new ClaimEditController();
		
	}
	
	public void testPreConditions(){
        assertNotNull(thisActivity);
        claim.setClaimiant("testClaimiant");
        claim.setStatus("Submitted");
        controller.addClaim();
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
		//set activity user is approver?
		
		ListView listView = (ListView) thisActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView); //listView
		
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
	    View dialog = thisActivity.getFragmentManager().findFragmentByTag("tag").getView();
		
	    //where to find the Approver button id
	    
	}
}
