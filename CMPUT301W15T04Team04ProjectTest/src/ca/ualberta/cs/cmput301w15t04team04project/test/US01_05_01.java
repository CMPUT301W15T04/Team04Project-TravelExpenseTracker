package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;
import java.util.Date;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.AdapterView;
import android.widget.ListView;
import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;


public class US01_05_01 extends ActivityInstrumentationTestCase2<MyClaimActivity> {
	public MyClaimActivity thisActivity;
	public ClaimEditController controller;
	public MyLocalClaimListController controller1;
	public User claimiant;
	public ArrayList<Item> items;

	public US01_05_01() {
		super(MyClaimActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		//thisActivity = (MyClaimActivity) getActivity();
		controller = new ClaimEditController();
	}
	
	public void test(){
		
		//assertNotNull(thisActivity);
        
        claimiant = new User("testclaimiant");
        Claim testClaim = new Claim("test");

        
        controller.getClaimList().getClaimArrayList().add(testClaim);
        
        //controller.setClaimObj(testClaim);
		
		controller.getClaimList().getClaimArrayList().remove(0);

		assertEquals("claim list is empty", controller.getClaimList().size(), 0);
		
/*		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MyClaimActivity.class.getName(), null, false);
		
		ListView listView = (ListView) thisActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView); //listView
		
		MyClaimActivity myActivity = getActivity();


		listView.getOnItemLongClickListener().onItemLongClick(AdapterView<T> adapterView,
				listView.getAdapter().getView(0, null, null),
				0, listView.getAdapter().getItemId(0));*/
	}

}
