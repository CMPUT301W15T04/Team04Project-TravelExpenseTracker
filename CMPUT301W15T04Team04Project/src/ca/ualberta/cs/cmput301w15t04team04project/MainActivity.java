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

public class MainActivity extends FragmentActivity {
	private ActionBar actionBar;
	private SignInController signInController = new SignInController();
	
	private RadioGroup bottom_Rg;
	private PagerAdapter mpageAdapter;
	private ViewPager pager;
	
	//private int num = -1;
	private MainController controller = new MainController();
	private MainActivity thisActivity = this;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//searchClaim.setVisible(true);
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
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, FragmentMain.class.getName()));
		fragments.add(Fragment.instantiate(this, FragmentMoments.class.getName()));
		fragments.add(Fragment.instantiate(this,FragmentProfile.class.getName()));
		
		mpageAdapter = new PagerAdapter(this.getSupportFragmentManager(),fragments);
		pager = (ViewPager) findViewById(R.id.mainActivityPager);
		pager.setAdapter(mpageAdapter);
		setFragmentIndicator();
		//num = pager.getCurrentItem();
	}

	
	/**
	 * setFragmentIndicator
	 * 
	 * @author Youdon Ma
	 * @author Yufei Zhang
	 * @version 2.0
	 * @since 2015-03-13
	 */
	private void setFragmentIndicator() {

		bottom_Rg = (RadioGroup) findViewById(R.id.mainActivityBottomMenu);
		bottom_Rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.myClaimMenuButton:
					pager.setCurrentItem(0);
					actionBar.setTitle("My Local Claims");
					actionBar.setIcon(R.drawable.ic_launcher);
					break;

				case R.id.momentsMenuButton:
					pager.setCurrentItem(1);
					actionBar.setTitle("Sumbitted Claims");
					actionBar.setIcon(R.drawable.ic_launcher);
					break;

				case R.id.myProfileMenuButton:
					pager.setCurrentItem(2);
					actionBar.setTitle("Me");
					actionBar.setIcon(R.drawable.user2_icon);
					break;

				default:
					break;
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void goToSearch(MenuItem item) {
		controller.goToSearch(thisActivity);
	}

	public void goToEditClaim(MenuItem item) {
		controller.goToEditClaim(thisActivity);
	}
	
	
	/**
	* Modify the following code
	*
	* @author  Chenrui Lei
	* @version 1.0
	* @since   2015-03-11
	*/
	public void logOut(View view) {
		signInController.logOut(MainActivity.this);

		// go back to signIn page
		Intent intent3 = new Intent(MainActivity.this, SignInActivity.class);
		startActivity(intent3);
		
		// stop current view
		finish();
    }
}
