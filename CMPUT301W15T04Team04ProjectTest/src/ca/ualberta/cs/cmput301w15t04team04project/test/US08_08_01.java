package ca.ualberta.cs.cmput301w15t04team04project.test;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.ListView;
import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ItemListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController2;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

public class US08_08_01 extends ActivityInstrumentationTestCase2<MyClaimActivity>{
	private MyClaimActivity thisActivity;
	private MyLocalClaimListManager manager;
	private ClaimEditController controller;
	private OneClaimController2 itemcontroller;
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
		manager = new MyLocalClaimListManager();
		claim = manager.loadClaimList(getActivity()).getClaimArrayList().get(0);
		controller = new ClaimEditController(manager.loadClaimList(getActivity()));
		
	}
	
	public void testPreConditions(){
        assertNotNull(thisActivity);
        
        claim.setStatus("Submitted");
        controller.appendClaim(claim);
        item = new Item("AItem");
        claim.addItem(item);
        approver = new User("approver");
       
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
