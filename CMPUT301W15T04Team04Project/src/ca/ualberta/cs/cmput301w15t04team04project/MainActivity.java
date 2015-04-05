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
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup.OnCheckedChangeListener;
/**
 * The MyClaim Activity is the profile my claims. which is write without
 * Internet environment .
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

	// private int num = -1;
	private MainController controller = new MainController();
	public List<Fragment> fragments;

	//resurce from "https://github.com/joshua2ua/CurrentLocation" March 28
	public static final String MOCK_PROVIDER = "mockLocationProvider";

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
		/*if (location != null){
			TextView tv = (TextView) findViewById(R.id.gpsHomeLocationTextView);
			tv.setText("Lat: " + location.getLatitude()
			+ "\nLong: " + location.getLongitude());
		}*/
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, listener);
		
		
		initialisePaging();
	}

	/**
	 * set initialisePaging
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
	 * setFragmentIndicator
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

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Modify the following code
	 *
	 * @author Chenrui Lei
	 * @version 1.0
	 * @since 2015-03-11
	 * @author Yufei Zhang
	 * @version 1.1
	 * @since 2015-03-13
	 */
	/**
	 * @param item
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
	 * Modify the following code
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
	 * Modify the following code
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
	 * Modify the following code
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
	 * Modify the following code
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
	
	
	public void goToMapAction(View v){
		Intent intent = new Intent(MainActivity.this, osmMainActivity.class);
		startActivity(intent);
	}
	
	public void goToSearch(MenuItem item) {
		Intent intent = new Intent(MainActivity.this, SearchActivity.class);
		startActivity(intent);
	}
	
}
