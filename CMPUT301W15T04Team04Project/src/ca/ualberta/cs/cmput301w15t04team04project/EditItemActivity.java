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

import ca.ualberta.cs.cmput301w15t04team04project.adapter.ClaimListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.PagerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class EditItemActivity extends FragmentActivity {
	private RadioGroup bottom_Rg;
	private PagerAdapter mpageAdapter;
	private ViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		//setContentView(R.layout.fragment_edit_item_1);
		//setContentView(R.layout.fragment_edit_item_2);
		initialisePaging();

		
	}
	
	/**
	 * initialisePaging is using for create a tab when we edit an item
	 **/
	private void initialisePaging() {
		// TODO Auto-generated method stub
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, FragmentEditItem1.class.getName()));
		fragments.add(Fragment.instantiate(this,FragmentEditItem2.class.getName()));
		mpageAdapter = new PagerAdapter(this.getSupportFragmentManager(),fragments);
		pager = (ViewPager) findViewById(R.id.editItemActivityPager);
		pager.setAdapter(mpageAdapter);
		//setFragmentIndicator();
	}
	
	private void setFragmentIndicator() {

		bottom_Rg = (RadioGroup) findViewById(R.id.editItemBottomMenu);
		bottom_Rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.editItemPrevious:
					pager.setCurrentItem(0);
					break;

				case R.id.editItemNext:
					pager.setCurrentItem(1);
					break;

				default:
					break;
				}

			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
		return true;
	}

	public void confirm(MenuItem item) {
		/**
		 * we need to add code here doing the following things
		 * 1. Add a new item to the current claim
		 * 2. Update the changes of the chosen item
		 **/
		finish();
	}
}
