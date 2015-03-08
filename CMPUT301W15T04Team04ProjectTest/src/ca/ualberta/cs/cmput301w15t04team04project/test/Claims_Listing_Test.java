package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.cmput301w15t04team04project.AddEditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.Controller;
import ca.ualberta.cs.cmput301w15t04team04project.Manager;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import junit.framework.TestCase;

public class Claims_Listing_Test extends TestCase {
	Activity activity;
	ClaimList claimList = Manager.getClaimList();

	public Claims_Status_Test() {
		super(MainActivity.class);
	}

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

	public void testClaimList() {
		ClaimList claimList = new ClaimList();
		String claimName = "Test";
		Claim testClaim = new Claim(claimName);
		claimList.addClaim(testClaim);
		assertTrue("Not the same claim",
				testClaim.equals(claimList.getPosition(0)));

	}

	// US02.02.01
	public void testSortClaimList() {
		ClaimList claimList = new ClaimList();
		Claim testClaim1 = new Claim("test1");
		Claim testClaim2 = new Claim("test2");
		testClaim1.setStartDate(new Date());// set a more recent date
		testClaim2.setStartDate(new Date());// set a older date
		final Button button = (Button) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.sortClaimListButton);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				
				button.performClick();
			}
		});
		// now the index of testClaim2 is 0, the index of testClaim1 is 1
		claimList.addClaim(testClaim2);
		claimList.addClaim(testClaim1);
		// after the sort function
		claimList.sortClaimList();
		int recent = claimList.getClaim().indexOf(testClaim1);
		int old = claimList.getClaim().indexOf(testClaim2);
		assertTrue("Not a valid sort", (recent < old));
	}

	public void testGetPosition() {
		ClaimList claimList = new ClaimList();
		Claim testClaim = new Claim("test");
		claimList.addClaim(testClaim);
		assertTrue("Not match the index",
				claimList.getPosition(0).equals(testClaim));
	}

	public void testGetClaimList() {
		ClaimList claimList = new ClaimList();

	}

	// US02.01.01
	public void testListClaims() {
		claimListView = (ListView) (activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.claimList));
		Claim claimview = new Claim("Cview");
		Controller.addClaim(claimview);
		TextView textview = (TextView) claimListView.getItemAtPosition(0);
		Claim claim = Controller.getClaim(0);
		String stringview = claim.toString();
		assertEquals("TEXT Displayed?", stringview, textview);
	}
}
