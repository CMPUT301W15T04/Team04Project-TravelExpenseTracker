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
import android.widget.ImageView;

/**
 * ItemDetailActivity is the Activity show the detail information of the Item
 * 
 * @author weijie2
 * @version 1.1
 * @date 2015-3-16
 */
public class ItemDetailActivity extends Activity {

	/**
	 * @param isClaimant boolean value o judge the user see this acivity is claimiant or approve
	 */
	private boolean isClaimant = OneClaimActivity.isClaimant;
	
	/**
	 * This function create the dialog approver see the activity_item_detail_a
	 * claimiant see the activity_item_detail
	 * 
	 * @author Yufei Zhang
	 * @version 1.0
	 * @since 2015-03-12
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (isClaimant) {
			setContentView(R.layout.activity_item_detail);			
			
		} else {
			setContentView(R.layout.activity_item_detail_a);
		}
		
		
	}
	/**
	 * This boolean function is to activate the option menu.
	 * 
	 * @author Yufei Zhang
	 * @author Weijie Sun
	 * @version 2.0
	 * @since 2015-04-05
	 */
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreasteOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item_detail, menu);
		return true;
	}

	/**
	 * This boolean function is the default setting
	 * 
	 * @author Yufei Zhang
	 * @author Weijie Sun
	 * @version 2.0
	 * @since 2015-04-05
	 */
	/* (non-Javadoc)
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
