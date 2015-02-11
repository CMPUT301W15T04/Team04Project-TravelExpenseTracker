package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import ca.ualberta.cs.cmput301w15t04team04project.Approval;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;


public class Appoval_Test extends TestCase{

	
	protected void viewSubmittedClaimsTest(){
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		ArrayList<Claim> testClaimListTrue = null;
		testClaimListTrue.add(AClaim);
		testClaimListTrue.add(BClaim);

		assertTrue("Submittedlist", testClaimList.getSubmittedClaimList().equals(testClaimListTrue));
		
	}
	
	
	protected void viewSubmittedClaimsDetailsTest(){
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
		assertTrue("name is equal", testClaimList.getSubmittedClaimList().get(0).getClaimName().toString().equals("1"));
		Date date = new Date();
		AClaim.setStartDate(date);
		assertTrue("starting date is equal", testClaimList.getSubmittedClaimList().get(0).getStartDate().equals(date));
		Date endDate = new Date();
		AClaim.setEndDate(endDate);
		assertTrue("ending date is equal", testClaimList.getSubmittedClaimList().get(0).getEndDate().equals(endDate));
		BClaim.setDescription("tests");
		assertTrue("description is equal", testClaimList.getSubmittedClaimList().get(1).getDescription().equals("tests"));
		BClaim.setStatus("Submitted");
		assertTrue("status is equal", testClaimList.getSubmittedClaimList().get(1).getStatus().equals("Submitted"));

		//destinations have not been done
		//total currency amount has not been done
	}
	
	
	protected void sortedClaimListTest(){
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
		
		//itemlist not done
	}
	
	protected void addACommentOfSubmittedClaimTest(){
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		
		
		
	}
	
}
