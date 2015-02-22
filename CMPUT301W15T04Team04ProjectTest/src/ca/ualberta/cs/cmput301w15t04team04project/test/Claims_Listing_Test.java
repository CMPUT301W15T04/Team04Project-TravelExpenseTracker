package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import junit.framework.TestCase;

public class Claims_Listing_Test extends TestCase {

	public void testClaimList() {
		ClaimList claimList = new ClaimList();
		String claimName = "Test";
		Claim testClaim = new Claim(claimName);
		claimList.addClaim(testClaim);
		assertTrue("Not the same claim",
				testClaim.equals(claimList.getPosition(0)));

	}

	public void testSortClaimList() {
		ClaimList claimList = new ClaimList();
		Claim testClaim1 = new Claim("test1");
		Claim testClaim2 = new Claim("test2");
		testClaim1.setStartDate(new Date());// set a more recent date
		testClaim2.setStartDate(new Date());// set a older date

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
public void testListClaims() {
		claimListView = (ListView) (activity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.claimList));
		Claim claimview = new Claim("Cview",new Date(2013,1,1), new Date(2014,1,1));
		Controller.addClaim(claimview);
		TextView textview = (TextView) claimListView.GetPosition(0);
		Claim claim = Controller.getClaim(0);
		String stringview = claim.toString();
		assertEquals("TEXT Displayed?",stringview, viewtext);
	}
}
