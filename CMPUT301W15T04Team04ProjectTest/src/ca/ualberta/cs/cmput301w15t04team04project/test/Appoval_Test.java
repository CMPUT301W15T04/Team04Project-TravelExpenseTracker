package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;
import java.util.Date;

import android.test.ViewAsserts;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import junit.framework.TestCase;
import ca.ualberta.cs.cmput301w15t04team04project.Approval;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.Item;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;


public class Appoval_Test extends TestCase {

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

	}

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
		Destination testDestionation = new Destination();
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
	}

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

	}
	
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



	}

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
		
	}

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
	}

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

	}
	
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
		
	}
}
