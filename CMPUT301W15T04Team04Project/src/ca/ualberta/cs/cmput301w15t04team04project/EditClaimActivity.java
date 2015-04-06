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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.PagerAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * <b>This is the activity for adding or editing a claim.</B>
 * <OL>
 * <LI type = "square">
 * Mainly there are 6 functions:
 * <UL>
 * <li>doFinish
 * <li>onCreate
 * <li>initialisePaging
 * <li>setFragmentIndicator
 * <li>onCreateOptionMenu
 * <li>confirmClaim
 * </ul>
 * 
 * @author Ji Yang
 * @author Yang Zhang
 * @author Yufei Zhang
 * @author Weijie Sun
 * @version 1.0
 * @since 2015-03-10
 */
public class EditClaimActivity extends FragmentActivity {
	private CLmanager onlineManager = new CLmanager();
	private RadioGroup bottom_Rg;
	private PagerAdapter mpageAdapter;
	private ViewPager pager;
	private ClaimEditController controller;
	private User user;
	public static ArrayList<Item> items;
	public static ArrayList<String> comments;
	protected static int addEditStatus = 0; // 0 add 1 edit
	protected static String ClaimName;
	protected Activity thisActivity = this;
	protected static ArrayList<Destination> destinationList = new ArrayList<Destination>();
	
	private Runnable doFinish = new Runnable() {
		public void run() {
			finish();
		}
	};
	/**
	 * Initializing the activity and call the initialisePaging() function to allow the pager<br>
	 * Called to do initial creation of a fragment.<br>
	 * This is called after onAttach(Activity) and before onCreateView(LayoutInflater, ViewGroup, Bundle).<br>
	 * Note that this can be called while the fragment's activity is still in the process of being created.<br>
	 * As such, you can not rely on things like the activity's content view hierarchy being initialized at this point.<br>
	 * If you want to do work once the activity itself is created, see onActivityCreated(Bundle).<br>
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_claim);
		controller = new ClaimEditController();
		user = SignInManager.loadFromFile(this);
		initialisePaging();

	}

	/*
	 * public static void changeFragmentTextView(String s) { Fragment frag =
	 * getFragmentManager().findFragmentById(R.id.yourFragment); ((TextView)
	 * frag.getView().findViewById(R.id.textView)).setText(s); }
	 */

	/**
	 * Initializing the pager for loading Fragments
	 * 
	 * @author Ji Yang
	 * @version 1.0
	 * @since 2015-03-10
	 */
	private void initialisePaging() {
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this,
				FragmentEditClaim1.class.getName()));
		fragments.add(Fragment.instantiate(this,
				FragmentEditClaim2.class.getName()));
		mpageAdapter = new PagerAdapter(this.getSupportFragmentManager(),
				fragments);
		pager = (ViewPager) findViewById(R.id.editClaimActivityPager);
		pager.setAdapter(mpageAdapter);
		setFragmentIndicator();
	}

	/**
	 * setFragmentIndicator
	 * 
	 * @author Ji Yang
	 * @version 1.0
	 * @since 2015-03-10
	 */
	private void setFragmentIndicator() {

		bottom_Rg = (RadioGroup) findViewById(R.id.editClaimBottomMenu);
		bottom_Rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.editClaimPrevious:
					pager.setCurrentItem(0);
					break;
				case R.id.editClaimNext:
					pager.setCurrentItem(1);
					break;
				default:
					break;
				}
			}
		});
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
		getMenuInflater().inflate(R.menu.edit_claim, menu);
		return true;
	}

	/**
	 * This function controls the MenuItem and shown as a "√" on the scream.<br>
	 * <ol>The MenuItem has the following functions:
	 * <ul>
	 * <li>The function will find all needed views by their id.
	 * <li>The function will test the user chooses either adding or editing.
	 * <li>If user chooses to add a claim, the class "AddThread" will be called
	 * <li>Else if user chooses to edit a claim, the class "updateThread will be called 
	 * </ul>
	 * </ol>
	 * 
	 * @author Chenrui Lei
	 * @author Ji Yang
	 * @author Yufei Zhang
	 * @version 1.1
	 * @since 2015-03-12
	 * @version 1.2
	 * @since 2015-03-20
	 */

	@SuppressWarnings("deprecation")
	public void confirmClaim(MenuItem item) {
		EditText claimName = (EditText) findViewById(R.id.claimNameEditText);
		EditText description = (EditText) findViewById(R.id.descriptionEditText);
		EditText tag = (EditText) findViewById(R.id.tagEditText);
		DatePicker fromDatePicker = (DatePicker) findViewById(R.id.fromDatePicker);
		DatePicker toDatePicker = (DatePicker) findViewById(R.id.toDatePicker);
		Date sDate = new Date();
		Date eDate = new Date();
		String cName = claimName.getText().toString();
		String cDescription = description.getText().toString();
		String cTag = tag.getText().toString();
		sDate.setDate(fromDatePicker.getDayOfMonth());
		sDate.setMonth(fromDatePicker.getMonth());
		sDate.setYear(fromDatePicker.getYear() - 1900);
		eDate.setDate(toDatePicker.getDayOfMonth());
		eDate.setMonth(toDatePicker.getMonth());
		eDate.setYear(toDatePicker.getYear() - 1900);

		/*
		 * Calendar calendar = Calendar.getInstance();
		 * calendar.set(toDatePicker.getYear(), toDatePicker.getMonth(),
		 * toDatePicker.getDayOfMonth()); Calendar calendarfrom =
		 * Calendar.getInstance(); calendarfrom.set(fromDatePicker.getYear(),
		 * fromDatePicker.getMonth(), fromDatePicker.getDayOfMonth());
		 */
		// System.out.println(tag==null);

		if (addEditStatus == 0) {
			ArrayList<Item> cItem = new ArrayList<Item>();
			ArrayList<String> cComments = new ArrayList<String>();
 			Claim claim = controller.setClaim(cName, cDescription, cTag, sDate,
					eDate, destinationList, user.getName(), cItem,cComments);
			Thread add = new AddThread(claim);
			add.start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			
			Claim claim = controller.setClaim(cName, cDescription, cTag, sDate,
					eDate, destinationList, user.getName(), items, comments);
			Thread update = new UpdateThread(claim);
			update.start();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	/**
	* This class is add claim thread to run
	* @param claim This is the claim which should be add in the CLManager 
	* @exception IOException On input error.
	* @see IOException
	* @exception IllegalStateException On input error.
	* @see IllegalStateException
	*/
	
	class AddThread extends Thread {
		private Claim claim;

		public AddThread(Claim claim) {
			this.claim = claim;
		}
		@Override
		public void run() {
			try {
				onlineManager.insertClaim(claim);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			runOnUiThread(doFinish);
		}
	}
	
	/**
	* This class is edit claim thread to run
	* @param claim This is the claim which should be add in the CLManager 
	* @exception IOException On input error.
	* @see IOException
	* @exception IllegalStateException On input error.
	* @see IllegalStateException
	*/
	class UpdateThread extends Thread {
		private Claim claim;

		public UpdateThread(Claim claim) {
			this.claim = claim;
		}

		@Override
		public void run() {
			try {
				
				onlineManager.updateClaim(claim);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			runOnUiThread(doFinish);
		}
	}
}
