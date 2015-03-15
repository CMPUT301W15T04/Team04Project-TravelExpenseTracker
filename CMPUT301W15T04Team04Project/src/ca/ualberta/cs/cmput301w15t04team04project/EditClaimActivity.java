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

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.PagerAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Destination;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.Global;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * This is the activity for adding/editing a claim.
 * 
 * @author Ji Yang
 * @author Yang Zhang
 * @version 1.0
 * @since 2015-03-10
 */
public class EditClaimActivity extends FragmentActivity {
	private EditText claimName;
	private EditText description;
	private EditText tag;
	private EditText destination;
	private DatePicker fromDatePicker;
	private DatePicker toDatePicker;
	
	protected static String claimNameF;
	protected static int yearS;
	protected static int monthS;
	protected static int dayS;
	protected static int yearD;
	protected static int monthD;
	protected static int dayD;
	protected static String descript = "Is is a test";
	
	// still need tag and destinations
	
	private RadioGroup bottom_Rg;
	private PagerAdapter mpageAdapter;
	private ViewPager pager;
	private MyLocalClaimListController controller;
	private ClaimList claimList;
	private int addEditstatus = 0; //0 add 1 edit
	private int myClaimId;
	
	private Claim thisClaim;
	
	
	/**
	 * Initializing the activity. Call the initialisePaging() function to allow
	 * the pager
	 * 
	 * 
	 * @author Ji Yang
	 * @version 1.0
	 * @since 2015-03-10
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_claim);
		
		claimList = MyLocalClaimListManager.loadClaimList(this, "local");
		controller = new MyLocalClaimListController(claimList);
		
		/*
		Bundle bundle = this.getIntent().getExtras();
		if (bundle == null){
			
			addEditstatus = 0;
		}
		else{
			addEditstatus = 1;
<<<<<<< HEAD
			
			int claimId = bundle.getInt("myClaimId");
			Toast.makeText(this, "claimId = " + claimId, Toast.LENGTH_SHORT).show();
			thisClaim = claimList.getClaimArrayList().get(claimId);

			claimNameF = thisClaim.getClaim().toString();
			//yearS = thisClaim.getStartDate().;
			//monthS = thisClaim.getStartDate().;
			//dayS = thisClaim.getStartDate().;
			
			//yearE = thisClaim.getEndDate().;
			//monthE = thisClaim.getEndDate().;
			//datE = thisClaim.getEndDate().;
			
			Toast.makeText(this, claimNameF, Toast.LENGTH_SHORT).show();
=======
			int claimid = bundle.getInt("MyClaimid");
			Toast.makeText(this, "Expense Item" + claimid, Toast.LENGTH_SHORT).show();
			Claim storeclaim = claimList.getClaimArrayList().get(claimid);
			claimName = (EditText) findViewById(R.id.claimNameEditText);
			String claimNameStr = storeclaim.getClaim().toString();
			//claimName.setText("Shabi");//storeclaim.getClaim().toString());//claimNameStr);
			Toast.makeText(this, claimNameStr, Toast.LENGTH_SHORT).show();
>>>>>>> origin/master
			
		}
		*/

		
		

		
		initialisePaging();

	}

/*    public static void changeFragmentTextView(String s) {
        Fragment frag = getFragmentManager().findFragmentById(R.id.yourFragment);
        ((TextView) frag.getView().findViewById(R.id.textView)).setText(s);  
    }*/
	
	/**
	 * Initializing the pager for loading Fragments
	 * 
	 * @author Ji Yang
	 * @version 1.0
	 * @since 2015-03-10
	 */
	private void initialisePaging() {

		// TODO Auto-generated method stub
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, FragmentEditClaim1.class.getName()));
		fragments.add(Fragment.instantiate(this, FragmentEditClaim2.class.getName()));
		mpageAdapter = new PagerAdapter(this.getSupportFragmentManager(), fragments);
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_claim, menu);
		return true;
	}

	/**
	 * This intent can finish since no necessary to keep it running the
	 * following code has been modified
	 * 
	 * @author Chenrui Lei
	 * @author Ji Yang
	 * @version 1.1
	 * @since 2015-03-12
	 */
	public void confirm(MenuItem item) {
		EditText claimName = (EditText) findViewById(R.id.claimNameEditText);
		EditText description = (EditText) findViewById(R.id.descriptionEditText);
		EditText tag = (EditText) findViewById(R.id.tagEditText);
		EditText destination = (EditText) findViewById(R.id.destinationandReasonEditText);
		DatePicker fromDatePicker = (DatePicker) findViewById(R.id.fromDatePicker);
		DatePicker toDatePicker = (DatePicker) findViewById(R.id.toDatePicker);

		Calendar calendar = Calendar.getInstance();
		calendar.set(toDatePicker.getYear(), toDatePicker.getMonth(),
				toDatePicker.getDayOfMonth());
		Calendar calendarfrom = Calendar.getInstance();
		calendarfrom.set(fromDatePicker.getYear(),
				fromDatePicker.getMonth(), fromDatePicker.getDayOfMonth());

		// Button confirm = (Button) findViewById(R.id.action_accept); // Bug
		// cause by this 2015-3-12
		// Controller clc = new Controller();
		if (addEditstatus == 0) {
			Claim claim = new Claim(claimName.getText().toString());
			claim.setDescription(description.getText().toString());
			claim.setTag(tag.getText().toString());
			// claim.addDestionation(destination.getText().toString());
			Destination destionation = new Destination(destination.getText().toString());
			claim.addDestionation(destionation);


			claim.setEndDate(calendar.getTime());


			claim.setStartDate(calendarfrom.getTime());

			controller.addClaim(claim);
			MyLocalClaimListManager.saveClaimList(this, claimList, "local");
		}
		
		else{
			
			Claim claim = claimList.getClaimArrayList().get(myClaimId);
			claim.setClaim(claimName.getText().toString());
			claim.setDescription(description.getText().toString());
			claim.setTag(tag.getText().toString());
			claim.setEndDate(calendar.getTime());
			claim.setStartDate(calendarfrom.getTime());
			
			MyLocalClaimListManager.saveClaimList(this, claimList, "local");

		}
		
		
		Intent intent = new Intent(EditClaimActivity.this,	MyClaimActivity.class); // Controller.saveClaimList();
		startActivity(intent);
		finish();
	}

}
