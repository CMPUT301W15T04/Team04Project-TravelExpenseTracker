package ca.ualberta.cs.cmput301w15t04team04project.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.Spinner;
import ca.ualberta.cs.cmput301w15t04team04project.Approval;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import junit.framework.TestCase;
import ca.ualberta.cs.cmput301w15t04team04project.ShowClaimDetailActivity;

<<<<<<< HEAD
public class Claims_Status_Test extends
		ActivityInstrumentationTestCase2<ShowClaimDetailActivity> {
	
	Activity activity;
	ClaimList claimList = ClaimListManager.getClaimList();
	Claim claim = new Claim("Test");
	claimList.addClaim(claim);
	public void testSubmitApprover() {
		((Button) activity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.submitClaim)).performClick();
		assertTrue("A claim with submitted status?",claim.getStatus().equals("submitted"));
     	assertTrue("A claim with submitted status should not be editable",claim.getEditable() == false);

	}

	public void ClaimStatusChanged() {
		((Button) activity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.returnClaim)).performClick();
		assertTrue("A claim with returned status?",claim.getStatus().equals("returned"));
     	assertTrue("A claim with returned status should be editable",claim.getEditable() == true);
		((Button) activity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.approveClaim)).performClick();
		assertTrue("A claim with approved status?",claim.getStatus().equals("approved"));
	    assertTrue("A claim with approved status should not be editable",claim.getEditable() == false);

	}

	public void showFeedback(){
		Approval approver = new Approval("jack");
		approver.approve(claim, "This a good claim");
		assertTrue("recieve feedback?",claim.getApprover() == "jack");
		assertTrue("recieve feedback?",claim.getComment() == "This a good claim");
	}
}
