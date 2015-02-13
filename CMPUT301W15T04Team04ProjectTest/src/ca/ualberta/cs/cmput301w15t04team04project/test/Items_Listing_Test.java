package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.Item;
import junit.framework.TestCase;

public class Items_Listing_Test extends TestCase {
	Item item = new Item("car");
	String i = item.toString();

	public void listItemInOneClaimDetailtest(){
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
}
