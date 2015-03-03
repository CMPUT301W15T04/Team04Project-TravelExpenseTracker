package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Instrumentation.ActivityMonitor;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemLongClickListener;

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
import ca.ualberta.cs.cmput301w15t04team04project.SignInActivity;
//import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import ca.ualberta.cs.cmput301w15t04team04project.User;
import ca.ualberta.cs.travel.AddTravelClaim;
import ca.ualberta.cs.travel.ClaimListController;
import ca.ualberta.cs.travel.ClaimListManager;
import ca.ualberta.cs.travel.Listener;
import ca.ualberta.cs.travel.R;


public class Appoval_Test extends ActivityInstrumentationTestCase2<SignInActivity>   {
	public Appoval_Test(Class<SignInActivity> activityClass) {
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
	
	public void testOpenNextActivity() {
		  // register next activity that need to be monitored.
		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

		  // open current activity.
		  SignInActivity myActivity = getActivity();
		  final Button button = (Button) myActivity.findViewById(android.R.id.SignInLoginButton);
		  myActivity.runOnUiThread(new Runnable() {
		    @Override
		    public void run() {
		      // click button and open next activity.
		      button.performClick();
		    }
		  });

		 //if it is not runnable? how do we know? because it is no assert there
		 
		  MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 1000);
		 
		  // do we need do add the test code here?
		 
		  assertNotNull(nextActivity);
		  nextActivity .finish();
		}
	
	//US08.01.01
	protected void viewSubmittedClaimsTest() {

	//before the basic flow , we should confirm some claim already created	
		
		
		
		
		
		//waiting for the joshua's answer 
		public void testOpenMainActivity(){
			  // register next activity that need to be monitored.
			  ActivityMonitor MainactivityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

			  // open current activity.
			  SignInActivity myActivity = getActivity();
			  final Button button = (Button) myActivity.findViewById(android.R.id.SignInLoginButton);
			  myActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button.performClick();
			    }
			  });

			  MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitorWithTimeout(MainactivityMonitor, 1000);

			  ArrayList<Claim> testClaimListTrue = new ArrayList<Claim>();
			  testClaimListTrue.add(AClaim);
			  testClaimListTrue.add(BClaim);

			  assertTrue("Submittedlist", testClaimList.getSubmittedClaimList()
						.equals(testClaimListTrue));
			  
			  View claimListView = activity.getWindow().getDecorView()
						.findViewById(android.R.id.MainClaimListView);
			  assertTrue("Toast is shown", v.isShown());
			  
			  public void testOpenAddEditClaimActivity{
				  
				  // register next activity that need to be monitored.
				  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(AddEditClaimActivity.class.getName(), null, false);

				  // open current activity.
				  AddEditClaimActivity myActivity = getActivity();
				  //listview adapter
				  
				  ClaimListManager.initManager(this.getApplicationContext());
			    	

				  ListView listView = (ListView) findViewById(R.id.claimListView);

			    	
			    	listView.setOnItemLongClickListener(new OnItemLongClickListener(){

						@Override
						public boolean onItemLongClick(AdapterView<?> adapterView, View view,
								int position, long id) {
							
							
							//
							adb.setNeutralButton("Edit", new OnClickListener(){
								public void onClick(DialogInterface dialog, int which){
									TextView approvernameview = (TextView) activity.findViewById(R.id.AddEditClaimApproverNameTextView);
									ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), view);
									TextView claimNameView = (TextView) activity.findViewById(R.id.AddEditClaimClaimNameTextView);
									ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), view);
									TextView view = (TextView) activity.findViewById(R.id.AddEditClaimTextView);
									ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), view);
							}

						
							});
						};

						
				  myActivity.runOnUiThread(new Runnable() {
				    @Override
				    public void run() {
				      // click button and open next activity.
				      button.performClick();
				    }
				  });
			    };

				AddEditClaimActivity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 100);
				// next activity is opened and captured.
				assertNotNull(nextActivity);
				nextActivity .finish();
			  }
			  
			  assertNotNull(nextActivity);
			  nextActivity .finish();
			};
			  
		

		
		
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
		
		final Button button = (Button) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.AddEditClaimViewSubmittedListButton);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();
			}
		});

		TextView nameview = (TextView) activity.findViewById(R.id.ViewClaimApproverNameTextView);
		assertTrue("Toast is shown", nameview.isShown());
		TextView Dateview = (TextView) activity.findViewById(R.id.ViewDateTextView);
		assertTrue("Toast is shown", Dateview.isShown());
		TextView Dateview = (TextView) activity.findViewById(R.id.ViewDateTextView);
		assertTrue("Toast is shown", Dateview.isShown());
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), view);
		View v = activity.getWindow().getDecorView()
				.findViewById(android.R.id.MainShowSubmittedListView);
		assertTrue("Toast is shown", v.isShown());
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
		String tname = "claimant_test";
		User claimiant = new User(tname);
		
	
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
		String tname = "claimant_test";
		User claimiant = new User(tname);
	
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
		
		
		User testApproval = new User(name); 
		
		Claim claimA = new Claim("A");
		
		claimA.setApprover(testApproval);
		claimA.setStatus("Submitted");
		assertEquals("should change", claimA.getStatus(), "Submitted");
		
		
		User testClaimant = new User(name);
		claimA.setClaimant(testClaimant);
		
		public void testOpenMainActivity1(){
			  // register next activity that need to be monitored.
			  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);

			  // open current activity.
			  SignInActivity myActivity = getActivity();
			  final Button button = (Button) myActivity.findViewById(android.R.id.SignInLoginButton);
			  myActivity.runOnUiThread(new Runnable() {
			    @Override
			    public void run() {
			      // click button and open next activity.
			      button.performClick();
			    }
			  });

			  MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 1000);

			  ArrayList<Claim> testClaimListTrue = new ArrayList<Claim>();
			  testClaimListTrue.add(AClaim);
			  testClaimListTrue.add(BClaim);

			  assertTrue("Submittedlist", testClaimList.getSubmittedClaimList()
						.equals(testClaimListTrue));
			  
			  View claimListView = activity.getWindow().getDecorView()
						.findViewById(android.R.id.MainClaimListView);
			  assertTrue("Toast is shown", v.isShown());
			  
			  public void testOpenAddEditClaimActivity1{
				  
				  // register next activity that need to be monitored.
				  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(AddEditClaimActivity.class.getName(), null, false);

				  // open current activity.
				  AddEditClaimActivity myActivity = getActivity();
				  //listview adapter
				  
				  ClaimListManager.initManager(this.getApplicationContext());
			    	

				  ListView listView = (ListView) findViewById(R.id.claimListView);

		    	
			    	
			    	listView.setOnItemLongClickListener(new OnItemLongClickListener(){

						@Override
						public boolean onItemLongClick(AdapterView<?> adapterView, View view,
								int position, long id) {
							final int finalPosition = position;
							Claim claim = list.get(finalPosition);
							AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
							adb.setMessage(claim.getName()+" total cost \n"+claim.totalcurrency()+"\n From "+claim.getFromDate()+" to "+claim.getToDate());
							adb.setCancelable(true);
							
							
							
							//
							adb.setNeutralButton("Edit", new OnClickListener(){
								public void onClick(DialogInterface dialog, int which){
									  MainActivity nextActivity = (MainActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 1000);
									  claimA.setStatus("Returned");
									  assertEquals("should not changed", claimA.getStatus(), "Submitted");
									  claimA.setStatus("Approved");
									  assertEquals("should not changed", claimA.getStatus(), "Submitted");
									  assertTrue("Claimant cannot edit the claim write by himself",
									  claimA.getEditable() == false);
							}

						
							});
						};
				  
				  myActivity.runOnUiThread(new Runnable() {
				    @Override
				    public void run() {
				      // click button and open next activity.
				      button.performClick();
				    }
				  });

				  AddEditClaimActivity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 100);
				  // next activity is opened and captured.
				  assertNotNull(nextActivity);
				  nextActivity .finish();
			  }
			  
			  assertNotNull(nextActivity);
			  nextActivity .finish();
			};
		
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
	}}
