package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Calendar;
import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.ListView;
import ca.ualberta.cs.cmput301w15t04team04project.FragmentProfile;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ClaimListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ItemListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

public class US08_04_01 extends ActivityInstrumentationTestCase2<OneClaimActivity> {
	private OneClaimActivity thisActivity;
	//private FragmentProfile profilefragment;
	private Claim claim ;
	private ClaimEditController controller;
	private OneClaimController itemcontroller;
	private Item item;
	private Date date;
	private Calendar calender = Calendar.getInstance();;
	private User approver;
	private ItemListAdapter itemListAdapter;
	private MyLocalClaimListManager manager;
	private User claimiant;

	
	public US08_04_01() {
		super(OneClaimActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		claimiant = new User("testclaimiant");
		
		controller = new ClaimEditController();
		claim = new Claim("AClaim");
		claim.setStatus("submitted");
		claim.setClaimiant("testclaimiant");
		controller.setClaimObj(claim);
		item = new Item("AItem");
		claim.addItem(item);
		calender.set(2005, 1, 12);
		date = calender.getTime();
		item.setItemDate(date);
		String description = "testdescription";
		item.setItemDescription(description);
		approver = new User("approver");
		SignInManager.saveInFile(getActivity(), claimiant);
		thisActivity = (OneClaimActivity) getActivity();
		//manager = new MyLocalClaimListManager();
		//claim = manager.loadClaimList(getActivity()).getClaimArrayList().get(0);
	}

	
	public void testAllItemDetailofSubmittedClaimTest(){
		itemListAdapter = new ItemListAdapter(getActivity(), 0, claim.getItems());

		ListView itemListView = (ListView) getActivity().findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.OneCaimItemListView); //listView

		View view = itemListAdapter.getView(0, null, null);
		ListView listview = (ListView) getActivity().findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.OneCaimItemListView);  
		
		assertEquals("Name is equal", "approver", item.getItemName());
		assertTrue(item.getItemDate().equals(date));
		assertEquals("description", "testdescription", item.getItemDescription());
		
		
	}
	
}
