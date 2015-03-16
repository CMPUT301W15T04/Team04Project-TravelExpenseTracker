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

import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;

public class Claims_Overall_Test<ActionMenuItemView> extends
		ActivityInstrumentationTestCase2<MyClaimActivity> {
	protected Instrumentation instrumentation;
	protected MyClaimActivity activity = null;

	public Claims_Overall_Test() {
		super(MyClaimActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
	}

	// US01.01.01
	public void testAddClaimNameAndDate() {
		// get activity and assert user has logged in
		Intent intent = new Intent();
		setActivityIntent(intent);
		activity = getActivity();
		MyLocalClaimListController.getClaimList();

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				MyClaimActivity.class.getName(), null, false);
		// get the button and press it
		final View button = (View) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.action_new_claim);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open the add claim activity.
				((View) button).performClick();
			}
		});
		final EditClaimActivity activity1 = (EditClaimActivity) instrumentation
				.waitForMonitorWithTimeout(activityMonitor, 10000);
		final View saveButton = (View) activity1
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.confirmClaim);
		activity1.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and save and finish the activity.

				TextView claimName = (TextView) activity1
						.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.claimNameEditText);
				DatePicker startDate = (DatePicker) activity1
						.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.fromDatePicker);
				DatePicker endDate = (DatePicker) activity1
						.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.toDatePicker);

				claimName.setText("test");
				startDate.updateDate(2012, 12, 12);
				endDate.updateDate(2015, 03, 15);
				((View) saveButton).performClick();
			}
		});
	}

	// US01.01.01
	public void testAddDestinationAndTags() {
		// get activity and assert user has logged in
		Intent intent = new Intent();
		setActivityIntent(intent);
		activity = getActivity();
		MyLocalClaimListController.getClaimList();
		assertEquals("No claims", MyLocalClaimListController.getClaimList()
				.size(), 0);

		ActivityMonitor activityMonitor = getInstrumentation().addMonitor(
				MyClaimActivity.class.getName(), null, false);
		// get the button and press it
		final Button button = (Button) activity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.action_new_claim);
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and open the add claim activity.
				button.performClick();
			}
		});
		final EditClaimActivity activity1 = (EditClaimActivity) instrumentation
				.waitForMonitorWithTimeout(activityMonitor, 5000);
		final Button saveButton = (Button) activity1
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.confirmClaim);
		activity1.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// click button and save and finish the activity.

				TextView claimName = (TextView) activity1
						.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.claimNameEditText);
				DatePicker startDate = (DatePicker) activity1
						.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.fromDatePicker);
				DatePicker endDate = (DatePicker) activity1
						.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.toDatePicker);

				claimName.setText("test");
				startDate.updateDate(2012, 12, 12);
				endDate.updateDate(2015, 03, 15);
				saveButton.performClick();
			}
		});
	}
}
