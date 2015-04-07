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

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * <b>This class is to help users to search their claims by tags</b> 
 * 
 * @author Yufei Zhang
 * @version 1.0
 * @since 2015-03-12
 */
public class SearchActivity extends Activity {
	private EditText tags;
	/**
	 * Called to do initial creation of a fragment.<br>
	 * This is called after onAttach(Activity) and before onCreateView(LayoutInflater, ViewGroup, Bundle).<br>
	 * Note that this can be called while the fragment's activity is still in the process of being created.<br>
	 * As such, you can not rely on things like the activity's content view hierarchy being initialized at this point.<br>
	 * If you want to do work once the activity itself is created, see onActivityCreated(Bundle).<br>
	 * 
	 * @param savedInstanceState	If the fragment is being re-created from a previous saved state, this is the state.
	 * 
	 * @author Yufei Zhang
	 * @author Weijie Sun
	 * @version 2.0
	 * @since 2015-04-05
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setIcon(R.drawable.ic_action_search);
	}
	
	/**
	 * This boolean function is to search the Activity change the mode of the my Claim Activity to 4
	 * In order to find the Claims which meet the requirement
	 * 
	 * @author Yufei Zhang
	 * @author Weijie Sun
	 * @version 2.0
	 * @since 2015-04-05
	 */
	public void search(View view){
		tags = (EditText) findViewById(R.id.enterTags);
		String tag = tags.getText().toString();
		MyClaimActivity.mode = 4;
		Intent intent = new Intent(SearchActivity.this,
				MyClaimActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("tag", tag);
		startActivity(intent);
		finish();
	}
}
