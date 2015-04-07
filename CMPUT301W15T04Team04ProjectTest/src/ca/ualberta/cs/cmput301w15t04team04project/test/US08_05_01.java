package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.sql.Date;

import android.app.Instrumentation;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ItemListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

public class US08_05_01 extends ActivityInstrumentationTestCase2<OneClaimActivity>{
	private OneClaimActivity thisActivity;
	private MyLocalClaimListManager manager;
	private ClaimEditController controller;
	private OneClaimController itemcontroller;
	private Claim claim ;
	private Item item;
	private ItemListAdapter itemListAdapter;
	private User approver;

	
	public US08_05_01() {
		super(OneClaimActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		//thisActivity = (OneClaimActivity) getActivity();
		manager = new MyLocalClaimListManager();
		claim = manager.loadClaimList(getActivity()).getClaimArrayList().get(0);
	//resource from "http://www.higherpass.com/Android/Tutorials/Working-With-Images-In-Android/3/" March 30

		approver = new User("approval");
		SignInManager.saveInFile(thisActivity, approver);
        claim.setStatus("Submitted");
        controller.setClaimObj(claim);
        item = new Item("AItem");
        claim.addItem(item);
        approver = new User("approver");
        //ImageView image = (ImageView) findViewById(R.id.test_image);
/*        Bitmap bMap = BitmapFactory.decodeResource(thisActivity.getResources(), R.drawable.ic_launcher);
        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 150, 100, true);
		Bitmap bMap = Bitmap.createBitmap(256,256,Bitmap.Config.ARGB_4444);

        //image.setImageBitmap(bMapScaled);        
        item.setReceipBitmap(bMap);*/
	}
	
  	protected void test(){
			approver = new User("approval");
		SignInManager.saveInFile(thisActivity, approver);
			
		ListView listView = (ListView) thisActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.OneCaimItemListView); //listView
		
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
		
	    ImageView receiptImage = (ImageView) thisActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.currentRecieptImageView);
	    Bitmap getBitmap = ((BitmapDrawable)receiptImage.getDrawable()).getBitmap();

		Bitmap thisBitmap = Bitmap.createBitmap(256,256,Bitmap.Config.ARGB_4444);

		
		
	    assertEquals("receipt is equal", getBitmap, item.getReceipBitmap());
	    
	}
}
