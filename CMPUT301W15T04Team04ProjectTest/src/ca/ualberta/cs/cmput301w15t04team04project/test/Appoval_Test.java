package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import ca.ualberta.cs.cmput301w15t04team04project.Approval;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.Item;

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
		// destinations have not been done
		// total currency amount has not been done
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

		/*
		 * ClaimList claimList = new ClaimList(); Claim testClaim1 = new
		 * Claim("test1"); Claim testClaim2 = new Claim("test2");
		 * testClaim1.setStartDate(new Date());// set a more recent date
		 * testClaim2.setStartDate(new Date());// set a older date
		 * 
		 * // now the index of testClaim2 is 0, the index of testClaim1 is 1
		 * claimList.addClaim(testClaim2); claimList.addClaim(testClaim1); //
		 * after the sort function claimList.sortClaimList(); int recent =
		 * claimList.getClaim().indexOf(testClaim1); int old =
		 * claimList.getClaim().indexOf(testClaim2);
		 * assertTrue("Not a valid sort", (recent < old)); //itemlist not done
		 */

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
		BClaim.setApproval(AApproval);
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
		BClaim.setApproval(AApproval);
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
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		BClaim.setStatus("Approved");
		BClaim.setApproval(AApproval);
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

}
