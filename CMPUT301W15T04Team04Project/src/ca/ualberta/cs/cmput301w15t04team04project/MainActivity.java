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

import java.util.List;
import java.util.Vector;

import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.PagerAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MainController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.SignInController;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup.OnCheckedChangeListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Listener;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
/**
<<<<<<< HEAD
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
=======
 * The MainActivity Activity is which has to show all the claim submitted in the sever and the proflie of each user
 * Internet environment .
 *
 * @author Weijie Sun
 * @version 1.0
 * @since 2015-03-16
>>>>>>> d95e25615b9430c6379e0a4e51001b98d9d0c78d
 */

public class MainActivity extends FragmentActivity {
	private ActionBar actionBar;

	private RadioGroup bottom_Rg;
	private PagerAdapter mpageAdapter;
	private ViewPager pager;

	// private int num = -1;
	private MainController controller = new MainController();
	private MainActivity thisActivity = this;
	public List<Fragment> fragments;

	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// searchClaim.setVisible(true);
		setContentView(R.layout.activity_main);

		actionBar = getActionBar();
		actionBar.setTitle("My Local Claims");

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
		Intent intent3 = new Intent(MainActivity.this, SignInActivity.class);
		startActivity(intent3);

		// stop current view
		finish();
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
	public void showSaved(View view) {
		MyClaimActivity.mode = 3;
		Toast.makeText(MainActivity.this,
				"This part will be done in project 5", Toast.LENGTH_SHORT)
				.show();
		/**
		 * We will finish this part in project 5
		 * 
		 * Intent intent = new Intent(MainActivity.this, MyClaimActivity.class);
		 * startActivity(intent);
		 */
	}
}
