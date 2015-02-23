package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import junit.framework.TestCase;
import ca.ualberta.cs.cmput301w15t04team04project.AddEditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.AddEditExpenseActivity;
import ca.ualberta.cs.cmput301w15t04team04project.Approval;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.Claimant;
import ca.ualberta.cs.cmput301w15t04team04project.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.Item;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.Manager;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
//import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;


public class Appoval_Test extends ActivityInstrumentationTestCase2<AddEditClaimActivity>   {
	public Appoval_Test(Class<AddEditClaimActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}

	Activity activity;
	ClaimList claimList = Manager.getClaimList();
	
	protected void setUp() throws Exception {
		super.setUp();
		// add a claim to test on
		Claim claim = new Claim("Test");
		claim.setStartDate(new Date());
		Item item = new Item("Item1");
		claim.addItem(item);
		claimList.addClaim(claim);
		Intent intent = new Intent();
		intent.putExtra("Index", 0);
		setActivityIntent(intent);
		activity = getActivity();
	}
	
	//US08.01.01
	protected void viewSubmittedClaimsTest() {
		
		
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		ArrayList<Claim> testClaimListTrue = new ArrayList<Claim>();
		testClaimListTrue.add(AClaim);
		testClaimListTrue.add(BClaim);

		assertTrue("Submittedlist", testClaimList.getSubmittedClaimList()
				.equals(testClaimListTrue));
		
		testOpenNextActivity(MainActivity, AddEditClaimActivity);
		
		final Button button = (Button) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.AddEditClaimViewSubmittedListButton);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();
			}
		});
		View v = activity.getWindow().getDecorView()
				.findViewById(android.R.id.MainShowSubmittedListView);
		assertTrue("Toast is shown", v.isShown());
		
	}
	
	
	//US08.01.01 and US08.04.01
	protected void viewSubmittedClaimsDetailsTest() {
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
		assertTrue("name is equal", testClaimList.getSubmittedClaimList()
				.get(0).getClaimName().toString().equals("1"));
		Date date = new Date();
		AClaim.setStartDate(date);
		assertTrue("starting date is equal", testClaimList
				.getSubmittedClaimList().get(0).getStartDate().equals(date));
		Date endDate = new Date();
		AClaim.setEndDate(endDate);
		assertTrue("ending date is equal", testClaimList
				.getSubmittedClaimList().get(0).getEndDate().equals(endDate));
		BClaim.setDescription("tests");
		assertTrue("description is equal", testClaimList
				.getSubmittedClaimList().get(1).getDescription()
				.equals("tests"));
		BClaim.setStatus("Submitted");
		assertTrue("status is equal", testClaimList.getSubmittedClaimList()
				.get(1).getStatus().equals("Submitted"));
		Destination testDestionation = new Destination("Paris","test");
		BClaim.addDestination(testDestionation);
		assertTrue("destionation is true",
				testClaimList.getSubmittedClaimList().get(1).getDestionation()
						.equals(testDestionation));
		Item itemA = new Item("food");
		Item itemB = new Item("texi");
		itemA.setAmount(12);
		itemB.setAmount(15);
		AClaim.addItem(itemA);
		AClaim.addItem(itemB);
		int amount = AClaim.getTotalCurrency();
		assertEquals("total currency is right",amount, 27);
		testOpenNextActivity(MainActivity, AddEditClaimActivity);
		testOpenNextActivity(OneClaimActivity, AddEditExpenseActivity);
	}

	// US08.04.01 and US08.05.01
	protected void viewClaimItemReceiptPhoto(){
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		Item itemA = new Item("food");
		Item itemB = new Item("texi");
		AClaim.addItem(itemA);
		BClaim.addItem(itemB);
		itemA.takeAPhoto();
		itemB.takeAPhoto();
		
		assertFalse("is photo", itemA.getPhoto().equals(null));
		assertFalse("is photo", itemB.getPhoto().equals(null));
		
		testOpenNextActivity(OneClaimActivity, AddEditExpenseActivity);
		
	}
	
	//US08.02.01
	protected void sortedClaimListTest() {
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

		Item itemA = new Item("food");
		Item itemB = new Item("texi");
		AClaim.addItem(itemA);
		BClaim.addItem(itemB);
		assertTrue("first item is true", testClaimList.getSubmittedClaimList()
				.get(1).getItemList().get(0).equals(itemB));
		assertTrue("first item is true", testClaimList.getSubmittedClaimList()
				.get(0).getItemList().get(0).equals(itemA));

		testOpenNextActivity(MainActivity, AddEditClaimActivity);
		View v = activity.getWindow().getDecorView()
				.findViewById(android.R.id.MainClaimListView);
		assertTrue("Toast is shown", v.isShown());

	}

	
	/*
	
	//should go to another activity AddEditClaimActivity
	
	public class Appoval_Test extends ActivityInstrumentationTestCase2<AddEditClaimActivity>   {
	public Appoval_Test(Class<AddEditClaimActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}

	Activity activity;
	ClaimList claimList = Manager.getClaimList();
	
	*/
	
	// US08.06.01
	
	
	protected void addACommentOfSubmittedClaimTest() {

		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		Approval approval = new Approval("test");
		AClaim.setApprover(approval);
		approval.setComment("comment test");
		assertEquals("comment added ", AClaim.getApprover().getComment().toString(), "comment test");
		
		testOpenNextActivity(MainActivity, AddEditClaimActivity);
		
		TextView v = (TextView) activity.getWindow().getDecorView()
				.findViewById(android.R.id.);
		assertTrue("Toast is shown", v.isShown());
	}

	//from us07.05.01
	public void showFeedback() {
		Approval approver = new Approval("jack");
		Claim claim = claimList.getPosition(0);
		approver.approve(claim, "This a good claim");
		assertTrue("recieve feedback?", claim.getApprover() == "jack");
		assertTrue("recieve feedback?",
				claim.getComment() == "This a good claim");
		TextView view = (TextView) activity.findViewById(R.id.commentsForClaim);
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), view);
	}
	
	//US08.07.01
	protected void returnClaimNotApproveTest() {

		Approval AApproval = new Approval("tester");
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		BClaim.setStatus("Returned");
		BClaim.setApprover(AApproval);
		BClaim.getApprover().setComment("reason");
		assertTrue("comment is added", BClaim.getApprover().getComment()
				.equals("reason"));
		assertEquals("status is return? ", BClaim.getStatus(), "Returned");
		
		testOpenNextActivity(MainActivity, AddEditClaimActivity);
		
		
		final Button button = (Button) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.MainViewNotApprovedClaimListButton);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();
			}
		});
		View v = activity.getWindow().getDecorView()
				.findViewById(android.R.id.MainShowNotApprovedListView);
		assertTrue("Toast is shown", v.isShown());
	}

	//US08.08.01
	protected void returnClaimSetApproverNameTest() {
		Approval AApproval = new Approval("tester");
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		BClaim.setStatus("Returned");
		BClaim.setApprover(AApproval);
		BClaim.getApprover().setComment("reason");
		assertTrue("comment is added",
				BClaim.getApprover().getName().equals("tester"));
		testOpenNextActivity(MainActivity, AddEditClaimActivity);

		TextView view = (TextView) activity.findViewById(R.id.AddEditClaimApproverNameTextView);
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), view);
	}

	protected void approveClaimSetApproverNameTest() {
		Approval AApproval = new Approval("tester");
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		BClaim.setApprover(AApproval);

		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		BClaim.setStatus("Approved");
		BClaim.getApprover().setComment("reason");
		assertTrue("comment is added",
				BClaim.getApprover().getName().equals("tester"));
		testOpenNextActivity(MainActivity, AddEditClaimActivity);

		TextView view = (TextView) activity.findViewById(R.id.AddEditClaimApproverNameTextView);
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), view);
	}
	
	//US08.09.01 added 2015-02-12
	
	public void claimantCanNotChangeClaimStatusTest(){
		String name = "J";
		
		Claimant testClaimant = new Claimant(name);
		Approval testApproval = new Approval(name); 
		
		Claim claimA = new Claim("A");
		claimA.setClaimant(testClaimant);
		claimA.setApprover(testApproval);
		claimA.setStatus("Submitted");
		assertEquals("should change", claimA.getStatus(), "Submitted");
		claimA.setStatus("Returned");
		assertEquals("should not changed", claimA.getStatus(), "Submitted");
		claimA.setStatus("Approved");
		assertEquals("should not changed", claimA.getStatus(), "Submitted");
		testOpenNextActivity(MainActivity, AddEditClaimActivity);

		assertTrue("Claimant cannot edit the claim write by himself",
				claimA.getEditable() == false);
		
		
	}
	


	
	//taken from http://stackoverflow.com/questions/9405561/test-if-a-button-starts-a-new-activity-in-android-junit-pref-without-robotium
	public void testOpenNextActivity(Activity myAcitivity, Activity nextActivity) {
		  // register next activity that need to be monitored.
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(nextActivity.class.getName(), null, false);

		  // open current activity.
		  //MyActivity myActivity = getActivity();
		  final Button button = (Button) myActivity.findViewById(R.id.open_next_activity);
		  myActivity.runOnUiThread(new Runnable() {
		    @Override
		    public void run() {
		      // click button and open next activity.
		      button.performClick();
		    }
		  });

		  //NextActivity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5);
		  // next activity is opened and captured.
		  assertNotNull(nextActivity);
		  nextActivity .finish();
		}

	protected void viewSClaimsDetailsTest() {
		Approval approve = new Approval("test");
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		BClaim.setApprover(approve);

		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		BClaim.setStatus("Approved");
		assertEquals("should change", AClaim.getStatus(), "Submitted");
		
		ListView listView = (ListView) findViewById(R.id.claimListView);

		MainActivity activity ; // should add something
		final ArrayList<Claim> list = new ArrayList<Claim>();
		
		
		final ArrayAdapter<Claim> claimAdapter = new ArrayAdapter<Claim>(activity, android.R.layout.simple_list_item_1, list);
		listView.setAdapter(claimAdapter);
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), view);
		
		ListView ItemlistView = (ListView) findViewById(R.id.claimListView);

		MainActivity itemactivity ; // should add something
		final ArrayList<Item> itemlist = new ArrayList<Item>();
		
		
		final ArrayAdapter<Item> itemAdapter = new ArrayAdapter<Item>(itemactivity, android.R.layout.simple_list_item_1, itemlist);
		ItemlistView.setAdapter(claimAdapter);
		ViewAsserts.assertOnScreen(itemactivity.getWindow().getDecorView(), ItemlistView);
		// not sure is it right
		testOpenNextActivity(MainActivity, OneClaimActivity);

	}
	
	//08.05.01
    protected void viewReceiptTest(){
    	Approval approver = new Approval("test");
    	Claim Aclaim = new Claim("test");
    	Item item = new Item("test");
    	Aclaim.addItem(item);
    	item.takeAPhoto();
    	assertTrue("view Receipt",item.getPhoto().equals(imageFileUri));
    	public class ClickFunActivityTest
        extends ActivityInstrumentationTestCase2 {
    
    	Button mClickMeButton = new Button();	
    		
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);

        mClickFunActivity = getActivity();
        mClickMeButton = (Button) 
                mClickFunActivity
                .findViewById(R.id.photo);
        mInfoTextView = (TextView) 
                mClickFunActivity.findViewById(R.id.info_text_view);
    }
}

    }
}
