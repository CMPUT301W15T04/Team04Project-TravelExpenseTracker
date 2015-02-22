package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.ListView;
import android.widget.TextView;

import ca.ualberta.cs.cmput301w15t04team04project.AddEditExpenseActivity;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.Item;
import ca.ualberta.cs.cmput301w15t04team04project.Manager;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import junit.framework.TestCase;

public class Items_Listing_Test extends
		ActivityInstrumentationTestCase2<OneClaimActivity> {
	final ClaimList claimList = Manager.getClaimList();
	Activity activity;
	ListView itemList;

	public Items_Listing_Test() {
		super(OneClaimActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		super.setUp();
		// add a claim to test on
		Claim claim = new Claim("Test");
		Item itemA = new Item("food");
		Item itemB = new Item("texi");
		Item itemC = new Item("hotel");
		itemA.setAmount(12);
		itemB.setAmount(15);
		itemB.setAmount(38);
		claim.addItem(itemA);
		claim.addItem(itemB);
		claim.addItem(itemC);
		Intent intent = new Intent();
		intent.putExtra("Index", 0);
		setActivityIntent(intent);
		activity = getActivity();
	}

	public void listItemInOneClaimDetailtest() {
		Claim claim = claimList.getPosition(0);
		int amount = claim.getTotalCurrency();
		assertEquals("total currency is right", amount, 65);
		int claimCount = itemList.getCount();
		for (int i = 0; i < claimCount; i++) {

			TextView itemOverAlldes = (TextView) itemList
					.getItemAtPosition(i);

			String viewText = itemOverAlldes.getText().toString();

			Item item = claim.getExpense(i);
			String itemInfo = item.toString();
			String itemText = ((OneClaimActivity) activity).claim
					.toString();
			assertEquals("DisplayError", itemInfo, itemText);
		}
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(),
				itemList);

	}
}
