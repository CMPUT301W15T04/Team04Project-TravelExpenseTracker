package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.DatePicker;
import android.widget.EditText;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.Destination;
import junit.framework.TestCase;
import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

public class Claims_Overall_Test extends
		ActivityInstrumentationTestCase2<addClaimActivity> {

	// use case 1
	public void testRecordNameAndDateInClaim() {
		Claim claim = new Claim();
		EditText claimantName = (EditText) findViewById(R.id.claimantName);
		claim.setClaimantName(claimantName.getText().toString());
		assertTrue("The claimant name setting is not correct!",
				claimantName.equals(claim.getClaimantName()));
		DatePicker startDate = (DatePicker) findViewById(R.id.claimStartDatePicker);
		claim.setStartDate(startDate.getDate());
		DatePicker endDate = (DatePicker) findViewById(R.id.claimEndDatePicker);
		claim.setEndDate(endDate.getDate());

	}

	// use case 2
	public void testRecordDestinationAndReasonInClaim() {
		EditText claimDestination = (EditText) findViewById(R.id.claimDestination);
		EditText claimReason = (EditText) findViewById(R.id.claimReason);
		Destination des = new Destination(claimDestination.getText().toString());
		des.setReason(claimReason.getText().toString());
		assertTrue("Destination reason sets false!", claimReason.getText()
				.toString().equals(des.getReason()));
		Claim claim = new Claim();
		claim.addDestination(des);
		int position = claim.findDesPosition(des);
		assertTrue("Destination set false!",
				des.equals(claim.getDestination(position)));
	}

	// use case 3
	public void testViewClaim() {
		Claim claim = new Claim();
		claim.setStartDate(new Date());
		claim.setEndDate(new Date());
		assertNotNull("No start date", claim);
		assertNotNull("No end date", claim);

	}

	// use case 4
	public void testEditClaim(){
		ClaimList claimList = new ClaimList();
		Claim claim = new Claim();
		claimList.addClaim(claim);		
		assertNotNull("No claim is gotten!", claimList.getPostion(position));
	}
	
	// use case 5
	public void testDeleteClaim(){
		ClaimList claimList = new ClaimList();
		Claim claim = new Claim();
		claimList.addClaim(claim);
		claimList.deleteClaim(position);
		assertTrue("The claim isn't deleted!", claimList.getPostion(position).equals(null));
	}

}