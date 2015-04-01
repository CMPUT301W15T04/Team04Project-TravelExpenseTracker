package ca.ualberta.cs.cmput301w15t04team04project.test;

import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ItemListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController2;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.app.Instrumentation;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import junit.framework.TestCase;

public class US08_06_01 extends ActivityInstrumentationTestCase2<MyClaimActivity>{
	private MyClaimActivity thisActivity;
	private MyLocalClaimListManager manager;
	private ClaimEditController controller;
	private OneClaimController2 itemcontroller;
	private Claim claim ;
	private Item item;
	private ItemListAdapter itemListAdapter;
	private User approver;

	
	public US08_06_01() {
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
        //ImageView image = (ImageView) findViewById(R.id.test_image);
        Bitmap bMap = BitmapFactory.decodeResource(thisActivity.getResources(), R.drawable.ic_launcher);
        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 150, 100, true);
        //image.setImageBitmap(bMapScaled);        
        item.setReceipBitmap(bMap);
	}
	
	public void test(){
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
		
	    //where to find the submitted id
	    
	}

}
