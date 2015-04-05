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
import android.app.AlertDialog;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.DialogInterface;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import junit.framework.TestCase;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

/**
 * @author youdong
 *
 */
public class Claims_Status_Test extends
		ActivityInstrumentationTestCase2<OneClaimActivity> {
	
	public Claims_Status_Test() {
		super(OneClaimActivity.class);
	}

	/* (non-Javadoc)
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();

	}

	/*
	 * US07.01.01
	 */
	/**
	 * 
	 */
	public void testSubmitApprover() {
		Claim claim = new Claim()
	}
	private void performClick(final Button button) throws Throwable {
	    runTestOnUiThread(new Runnable() {
	        @Override
	        public void run() {
	            button.performClick();
	        }
	    });
	    getInstrumentation().waitForIdleSync();
	}
	/*
	 * US07.02.01
	 */

	/**
	 * 
	 */
	public void testSubmitWarning() {
		Claim claim = claimList.getPosition(0);
		Item item = claim.getItem(0);
		final Button button = (Button) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.submitClaimButton);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();
			}
		});
		assertFalse("A claim with submitted status?",
				claim.getStatus().equals("submitted"));
		View v = activity.getWindow().getDecorView()
				.findViewById(android.R.id.content);
		assertTrue("Toast is shown", v.isShown());
	}

	/*
	 * US07.03.01
	 */

	/**
	 * 
	 */
	public void ClaimStatusReturned() {
		Approval approver = new Approval("jack");
		Claim claim = claimList.getPosition(0);
		activity = getActivity();
		final Button button = (Button) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.returnClaim);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();
			}
		});
		assertTrue("A claim with returned status?",
				claim.getStatus().equals("returned"));
		assertTrue("A claim with returned status should be editable",
				claim.getEditable() == true);

	}
	/*
	 * US07.04.01
	 */
	
	/**
	 * 
	 */
	public void ClaimStatusApproved() {
		Approval approver = new Approval("jack");
		activity = getActivity();
		Claim claim = claimList.getPosition(0);
		final Button button = (Button) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.approveClaim);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open next activity.
				button.performClick();
			}
		});
		assertTrue("A claim with approved status?",
				claim.getStatus().equals("approved"));
		assertTrue("A claim with approved status should not be editable",
				claim.getEditable() == false);

	}


	/*
	 * US07.05.01
	 */
	/**
	 * 
	 */
	public void showFeedback() {
		Approval approver = new Approval("jack");
		Claim claim = claimList.getPosition(0);
		approver.approve(claim, "This a good claim");
		assertTrue("recieve feedback?", claim.getApprover() == "jack");
		assertTrue("recieve feedback?",
				claim.getComment() == "This a good claim");
		TextView view = (TextView) activity.findViewById(R.id.commentsForClaim);
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), view);
	}

	/**
	 * @author Youdong Ma 
	 */
	public void chechEmptyElement(){
		((Button) activity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.submitClaim)).performClick();
		assertTrue("Claim has empty elements.", claim.checkEmpty() == True);
		TextView view = (TextView) activity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.toast);
		assertTrue("visual warning?", view��getText().toString() == "Can't submit");
		
	}
	
}