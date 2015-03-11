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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.PagerAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class EditClaimActivity extends FragmentActivity {
	private RadioGroup bottom_Rg;
	private PagerAdapter mpageAdapter;
	private ViewPager pager;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_claim);
		initialisePaging();


	}
	private void initialisePaging() {
		// TODO Auto-generated method stub
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, FragementEditClaim1.class.getName()));
		fragments.add(Fragment.instantiate(this,
				FragementEditClaim2.class.getName()));
		mpageAdapter = new PagerAdapter(this.getSupportFragmentManager(),
				fragments);
		pager = (ViewPager) findViewById(R.id.editClaimActivityPager);
		pager.setAdapter(mpageAdapter);
		setFragmentIndicator();

	}

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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_claim, menu);
		return true;
	}

	public void confirm(MenuItem item) {
		Claim claim = new Claim(null);
		EditText claimName = (EditText) findViewById(R.id.claimNameEditText);
		EditText description = (EditText) findViewById(R.id.descriptionEditText);
		EditText tag = (EditText) findViewById(R.id.tagEditText);
		EditText destinationandReason = (EditText) findViewById(R.id.destinationandReasonEditText);
		DatePicker fromDatePicker = (DatePicker) findViewById(R.id.fromDatePicker);
		DatePicker toDatePicker = (DatePicker) findViewById(R.id.toDatePicker);
		Button confirm = (Button) findViewById(R.id.action_accept);
		// Controller clc = new Controller();
		claim.setClaim(claimName.getText().toString());
		//claim.setDescription(description);
		//claim.setTag(tag);
		// clc.addClaim(claim);
		Toast.makeText(EditClaimActivity.this, "Added", Toast.LENGTH_LONG)
				.show();
		Intent intent = new Intent(EditClaimActivity.this, MainActivity.class);
		// Controller.saveClaimList();
		startActivity(intent);
	}

}
