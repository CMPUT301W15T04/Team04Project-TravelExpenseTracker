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

import java.util.Date;
import java.util.List;
import java.util.Vector;
import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.PagerAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MainController;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup.OnCheckedChangeListener;
/**
 * <b>The MyClaim Activity is the profile my claims.</b>
 * <ol>
 * <li type = "square">This activity is gives user 7 different button to choose.
 * <ul>
 * 
 * <li>Progressing Claims
 * <ul>
 * 	<li>This type of claims are saved in local.
 * 	<li>This kind of claims can be modified only by claimants.
 * </ul>
 * 
 * <li>Submit Claims
 * <ul>
 * <li>This type of claims are saved online
 * <li>This kind of claims can be seen by both approvers and claimants.
 * <li>Claimant can only change the status from submit to progress.
 * <li>Approver can only add comments and approve the submitted claims.
 * </ul>
 * 
 * <li>Approved Claims
 * <ul>
 * <li>This kind of claims are saved online
 * <li>This type of claims cannot be modified by anybody
 * <li>This kind of claims can only be seen by claimants
 * <li>This kind of claims will be send back to the claimant once they are approved
 * </ul>
 *
 * <li>Returned Claims
 * <ul>
 * <li>The Returned Claims are modified by approvers online
 * <li>This kind of claims will be send back to the claimant so that the claimant can modify them offline
 * </ul>
 * 
 * <li>Button (GPS)
 * <ul>
 * <li>Click on this button will lead the user to the GPS page
 * </ul>
 * 
 * <li>LOU OUT
 * <ul>
 * <li>This button is on the action bar
 * <li>User can click it to log out the system
 * </ul>
 * 
 * <li>Search
 * <ul>
 * <li>Click on this button on the action bar allows user go the search page
 * </ul>
 * </ul>
 * </ol>
 * 
 * @author youdong
 * @author Weijie Sun
 * @version 1.0
 * @since 2015-03-11
 * @author Chenrui Lei
 * @author Yufei Zhang
 * @version 1.1
 * @since 2015-03-15
 */
public class MainActivity extends FragmentActivity {
	private ActionBar actionBar;
	private User user;
	private RadioGroup bottom_Rg;
	private PagerAdapter mpageAdapter;
	private ViewPager pager;
	public static Location homeLocation;
	
	// private int num = -1;
	private MainController controller = new MainController();
	public List<Fragment> fragments;

	//resurce from "https://github.com/joshua2ua/CurrentLocation" March 28
	public static final String MOCK_PROVIDER = "mockLocationProvider";

	
	/**
	 * Called to do initial creation of a fragment.<br>
	 * This is called after onAttach(Activity) and before onCreateView(LayoutInflater, ViewGroup, Bundle).<br>
	 * Note that this can be called while the fragment's activity is still in the process of being created.<br>
	 * As such, you can not rely on things like the activity's content view hierarchy being initialized at this point.<br>
	 * If you want to do work once the activity itself is created, see onActivityCreated(Bundle).<br>
	 * 
	 * @param savedInstanceState	If the fragment is being re-created from a previous saved state, this is the state.
	 */
	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// searchClaim.setVisible(true);
		setContentView(R.layout.activity_main);
		user = SignInManager.loadFromFile(this);
		actionBar = getActionBar();
		actionBar.setTitle("My Local Claims");

		LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

/*		if (location != null){
			user.setHomelocation(location);
			TextView tv = (TextView) findViewById(R.id.gpsHomeLocationTextView);
			tv.setText("Lat: " + location.getLatitude()
			+ "\nLong: " + location.getLongitude());
		}*/
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, listener);
		
		
		initialisePaging();
	}

	/**
	 * Set initialisePaging
	 * 
	 * @author Youdon Ma
	 * @author Yufei Zhang
	 * @version 2.0
	 * @since 2015-03-13
	 */
	private void initialisePaging() {
		// TODO Auto-generated method stub
		fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this,
				FragmentProfile.class.getName()));
		fragments.add(Fragment.instantiate(this,
				FragmentMoments.class.getName()));

		mpageAdapter = new PagerAdapter(this.getSupportFragmentManager(),
				fragments);
		pager = (ViewPager) findViewById(R.id.mainActivityPager);
		pager.setAdapter(mpageAdapter);
		setFragmentIndicator();
		// num = pager.getCurrentItem();
	}

	/**
	 * Set FragmentIndicator
	 * 
	 * @author Youdon Ma
	 * @version 1.0
	 * @since 2015-03-10
	 * @author Yufei Zhang
	 * @version 1.1
	 * @since 2015-03-13
	 */
	private void setFragmentIndicator() {

		bottom_Rg = (RadioGroup) findViewById(R.id.mainActivityBottomMenu);
		bottom_Rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.myProfileMenuButton:
					pager.setCurrentItem(0);
					actionBar.setTitle("Me");
					// actionBar.setIcon(R.drawable.user2_icon);
					break;

				case R.id.momentsMenuButton:
					pager.setCurrentItem(1);
					actionBar.setTitle("Moments");
					// actionBar.setIcon(R.drawable.ic_launcher);
					break;

				default:
					break;
				}

			}
		});
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
	 */
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	/**
	 * <b>This function is  for user to log out the system</b>
	 * <br>
	 * Once this button is clicked, the system will jump to the login page and users should login again.
	 * The data of the user will be saved except the user name; hence the system will not do the automatically login function after logout.
	 * 
	 * @param item
	 * @author Chenrui Lei
	 * @version 1.0
	 * @since 2015-03-11
	 * @author Yufei Zhang
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public void logOut(MenuItem item) {
		// call controller to logout
		controller.logOut(MainActivity.this);

		// go back to signIn page
		Intent intent = new Intent(MainActivity.this, SignInActivity.class);
		startActivity(intent);

		// stop current view
		finish();
	}
	
	
	public void addClaim(View v){
		Intent intent = new Intent(MainActivity.this, EditClaimActivity.class);
		startActivity(intent);
	}
	/**
	 * Once the user click "Progressing Claims", system will call this function to jump to the page for progressing claims.
	 *
	 * @author Chenrui Lei
	 * @version 1.0
	 * @since 2015-03-11
	 * @author Yufei Zhang
	 * @version 1.1
	 * @since 2015-03-13
	 */
	/**
	 * @param view
	 */
	public void showProgressing(View view) {
		MyClaimActivity.mode = 0;
		Intent intent = new Intent(MainActivity.this, MyClaimActivity.class);
		startActivity(intent);
	}

	/**
	 * Once the user click "Submitted Claims", system will call this function to jump to the page for submitted claims.
	 *
	 * @author Chenrui Lei
	 * @version 1.0
	 * @since 2015-03-11
	 * @author Yufei Zhang
	 * @version 1.1
	 * @since 2015-03-13
	 */
	/**
	 * @param view
	 */
	public void showSubmitted(View view) {
		MyClaimActivity.mode = 1;
		Intent intent = new Intent(MainActivity.this, MyClaimActivity.class);
		startActivity(intent);
	}

	/**
	 * Once the user click "Approved Claims", system will jump to the page for approved claims.
	 *
	 * @author Chenrui Lei
	 * @version 1.0
	 * @since 2015-03-11
	 * @author Yufei Zhang
	 * @version 1.1
	 * @since 2015-03-13
	 */
	/**
	 * @param view
	 */
	public void showApproved(View view) {
		MyClaimActivity.mode = 2;
		Intent intent = new Intent(MainActivity.this, MyClaimActivity.class);
		startActivity(intent);
	}

	/**
	 *Once the user click "returned Claims", system will jump to the page for returned claims.
	 *
	 * @author Chenrui Lei
	 * @version 1.0
	 * @since 2015-03-11
	 * @author Yufei Zhang
	 * @version 1.1
	 * @since 2015-03-13
	 */
	/**
	 * @param view
	 */
	public void showReturn(View view) {
		MyClaimActivity.mode = 3;
		Intent intent = new Intent(MainActivity.this, MyClaimActivity.class);
		startActivity(intent);
		/**
		 * We will finish this part in project 5
		 * 
		 * Intent intent = new Intent(MainActivity.this, MyClaimActivity.class);
		 * startActivity(intent);
		 */
	}
	
	
	private final LocationListener listener = new LocationListener() {
		public void onLocationChanged (Location location) {
			TextView tv = (TextView) findViewById(R.id.gpsHomeLocationTextView);
			if (location != null) {
				double lat = location.getLatitude();
				double lng = location.getLongitude();
				Date date = new Date(location.getTime());
				
				tv.setText("Latitude: " + lat
						+ "\nLongitude: " + lng
						+ "\n at time: " + date.toString());
			} else {
				tv.setText("Cannot get the location");
			}
		}
		
		public void onProviderDisabled (String provider) {
			
		}
		
		public  void onProviderEnabled (String provider) {
			
		}
		
		public void onStatusChanged (String provider, int status, Bundle extras) {
			
		}
	};
	
	/**
	 * Will be called when user clicked add Location button, it will pop a
	 * dialog and let user choose the method of location which go to the osmMainAcitivity
	 * 
	 * @param v View passed to the activity to check which button was pressed.
	 */
	public void goToMapAction(View v){
		AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
		if (user.getHomelocation()!=null){
			adb.setMessage("Current Home Location is "+user.getHomelocation().getLatitude()+user.getHomelocation().getLongitude()+"\nChoose the HomeLocation Way");

		}
		else{
		adb.setMessage("Choose the HomeLocation Way");
		}
		adb.setNegativeButton("GPS", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				homeLocation = location;
				user.setHomelocation(location);
			}
		});
		
		adb.setPositiveButton("Map", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = new Intent(MainActivity.this, osmMainActivity.class);
				startActivity(intent);
			}
		});
		
		adb.setCancelable(true);
		adb.show();


	}
	
	/**
	 * jump to search activity
	 * @param item 
	 */
	public void goToSearch(MenuItem item) {
		Intent intent = new Intent(MainActivity.this, SearchActivity.class);
		startActivity(intent);
	}
	
}
