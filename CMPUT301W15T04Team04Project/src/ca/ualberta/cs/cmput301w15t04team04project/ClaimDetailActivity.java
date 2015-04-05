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
package ca.ualberta.cs.cmput301w15t04team04project;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * <b>This is the activity showing the details of a claim for claimants.</B>
 * <OL>
 * <LI type = "square">
 * The detail includes:
 * <UL>
 * <li>Claim Name
 * <li>Start Date of a Claim
 * <li>End Date of a Claim
 * <li>Status of a Claim
 * <li>Tag(s) of a Claim
 * <li>Destination(s) of a Claim
 * </OL>
 * <ol>
 * <li type = "square">There also have 2 button on the dialog
 * <ul>
 * <li>Cancel: back to the oneClaimActivity
 * <li>Submit: submit the current claim.
 * </ul> 
 * </ol>
 * 
 * @author Yufei Zhang
 * @author Weijie Sun
 * @param isClaimant boolean value o judge the user see this acivity is claimiant or approve
 * @version 2.0
 * @since 2015-04-05
 */

public class ClaimDetailActivity extends Activity {
	private boolean isClaimant = OneClaimActivity.isClaimant;

	/**
	 * <ul>
	 * <li>This function create the dialog approver.<br>
	 * <ul>
	 * <li>If the user is a claimant, the layout for the claimant will be chosen.<br>
	 * <li>Otherwise, the layout for the approver will be chosen. <br>
	 * </ul></ul>
	 * 
	 * Called to do initial creation of a fragment.<br>
	 * This is called after onAttach(Activity) and before onCreateView(LayoutInflater, ViewGroup, Bundle).<br>
	 * Note that this can be called while the fragment's activity is still in the process of being created.<br>
	 * As such, you can not rely on things like the activity's content view hierarchy being initialized at this point.<br>
	 * If you want to do work once the activity itself is created, see onActivityCreated(Bundle).<br>
	 * 
	 * @param savedInstanceState	If the fragment is being re-created from a previous saved state, this is the state.
	 * @author Yufei Zhang
	 * @version 1.0
	 * @since 2015-03-12
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isClaimant) {
			setContentView(R.layout.activity_claim_detail);
		} else {
			setContentView(R.layout.activity_claim_detail_a);
		}
	}

	
	/**
	 * This boolean function is to activate the option menu.
	 * Initialize the contents of the Activity's standard options menu.<br>
	 * You should place your menu items in to menu. For this method to be called, you must have first called setHasOptionsMenu(boolean).<br>
	 * See Activity.onCreateOptionsMenu for more information.
	 * 
	 * @param menu	The options menu in which you place your items.
	 * @see setHasOptionsMenu(boolean)
	 * @see onPrepareOptionsMenu(Menu)<br>
	 * @see onOptionsItemSelected(MenuItem)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.claim_detail, menu);
		return true;
	}

	/**
	 * This hook is called whenever an item in your options menu is selected.<br>
	 * The default implementation simply returns false to have the normal processing happen (calling the item's Runnable or sending a message to its Handler as appropriate).<br>
	 * You can use this method for any items for which you would like to do processing without those other facilities.<br>
	 * Derived classes should call through to the base class for it to perform the default menu handling.
	 * 
	 * @param item	The menu item that was selected.
	 * @return boolean Return false to allow normal menu processing to proceed, true to consume it here.
	 * @see onCreateOptionsMenu(Menu)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
