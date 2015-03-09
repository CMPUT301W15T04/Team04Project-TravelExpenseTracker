/*
* Copyright 2015 Weijie Sun
* Copyright 2015 Youdong Ma
* Copyright 2015 Yufei Zhang
* Copyright 2015 Chenrui Lei
* Copyright 2015 Yang Zhang
* Copyright 2015 Ji Yang
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import ca.ualberta.cs.cmput301w15t04team04project.AddEditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.Manager;
import junit.framework.TestCase;
import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

public class Claims_Overall_Test extends
		ActivityInstrumentationTestCase2<addClaimActivity> {
	Activity activity;
	ClaimList claimList = Manager.getClaimList();

	public Claims_Overall_Test() {
		super(addCliamAc.class);
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

	// use case 1
	public void testRecordNameAndDateInClaim() {
		
		

		EditText claimantName = (EditText) findViewById(R.id.claimantName);
		claim.setClaimantName(claimantName.getText().toString());

		DatePicker startDate = (DatePicker) findViewById(R.id.claimStartDatePicker);
		claim.setStartDate(startDate.getDate());
		DatePicker endDate = (DatePicker) findViewById(R.id.claimEndDatePicker);
		claim.setEndDate(endDate.getDate());
		final Button button = (Button) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.submitClaimButton);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();
			}
		});

		assertTrue("The claimant name setting is not correct!",
				claimantName.equals(claim.getClaimantName()));
		assertTrue("The claimant name setting is not correct!",
				claimantName.equals(claim.getClaimantName()));

	}

	// use case 2
	public void testRecordDestinationAndReasonInClaim() {
		EditText claimDestination = (EditText) findViewById(R.id.claimDestination);
		EditText claimReason = (EditText) findViewById(R.id.claimReason);
		Destination des = new Destination(claimDestination.getText().toString());
		des.setReason(claimReason.getText().toString());
		final Button button = (Button) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.submitClaimButton);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();
			}
		});
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
		final ListView lv = (ListView) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.claimListView);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				lv.performClick();
			}
		});
		assertNotNull("No start date", claim);
		assertNotNull("No end date", claim);

	}

	// use case 4
	public void testEditClaim() {
		ClaimList claimList = new ClaimList();
		Claim claim = new Claim();
		claimList.addClaim(claim);
		final Button button = (Button) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.EditClaimButton);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();
			}
		});
		assertNotNull("No claim is gotten!", claimList.getPosition(position));
	}

	// use case 5
	public void testDeleteClaim() {
		ClaimList claimList = new ClaimList();
		Claim claim = new Claim();
		claimList.addClaim(claim);
		claimList.deleteClaim(position);
		final Button button = (Button) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.deleteClaimButton);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();
			}
		});
		assertTrue("The claim isn't deleted!", claimList.getPosition(position)
				.equals(null));
	}
	//US01.06.01
	public void testStorage(){
		System.exit(0);
		Intent intent = new Intent();
		intent.putExtra("Index", 0);
		setActivityIntent(intent);
		activity = getActivity();
		assertNotNull("No claim is gotten!", claimList.getPosition(0));
		
	}
}