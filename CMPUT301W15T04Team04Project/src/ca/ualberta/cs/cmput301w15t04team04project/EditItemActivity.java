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
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.PagerAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ItemEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Currency;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * This is the activity for adding/editing an item.
 * 
 * @author Ji Yang
 * @author Yang Zhang
 * @version 1.0
 * @since 2015-03-10
 */
public class EditItemActivity extends FragmentActivity {
	private RadioGroup bottom_Rg;
	private PagerAdapter mpageAdapter;
	private ViewPager pager;
	private ItemEditController controller;
	private String claimName;
	static int addEditItemStatus = 0; // 0 add 1 edit
	static int itemId;
	private Bitmap bitmap;
	private int receiptFlag = 0;
	private CLmanager onlineManager = new CLmanager();
	private Bundle bundle;
	
	private Runnable doFinishEdit = new Runnable() {
		public void run() {
			//finish();
		}
	};
	private Runnable FinishLoad = new Runnable() {
		public void run() {
			Toast.makeText(getApplicationContext(), controller.getClaim().getClaim(), Toast.LENGTH_LONG).show();
		}
	};
	
	/**
	 * Initializing the activity. Call the initialisePaging() function to allow
	 * the pager
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 * @author Ji Yang
	 * @version 1.0
	 * @since 2015-03-10
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		// setContentView(R.layout.fragment_edit_item_1);
		// setContentView(R.layout.fragment_edit_item_2);
		initialisePaging();
		bundle = getIntent().getExtras();
		claimName = bundle.getString("MyClaimName");
		Toast.makeText(this, claimName, Toast.LENGTH_LONG)
		.show();
		controller = new ItemEditController();
		GetClaimThread get = new GetClaimThread(claimName);
		get.start();
		receiptFlag = 0;
	}

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
		fragments.add(Fragment.instantiate(this,
				FragmentEditItem1.class.getName()));
		fragments.add(Fragment.instantiate(this,
				FragmentEditItem2.class.getName()));

		mpageAdapter = new PagerAdapter(this.getSupportFragmentManager(),
				fragments);
		pager = (ViewPager) findViewById(R.id.editItemActivityPager);
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

	/**
	 * active the Menu
	 * 
	 * @author Yufei Zhang
	 * @version 1.0
	 * @since 2015-03-03
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
		return true;
	}

	/**
	 * active the cofirm button
	 * 
	 * @author Yufei Zhang
	 * @version 1.0
	 * @since 2015-03-02
	 */
	public void confirm(MenuItem item) {
		/**
		 * we need to add code here doing the following things: 1. Add a new
		 * item to the current claim 2. Update the changes of the chosen item
		 **/

		/**
		 * this part should be in controller. Chenrui
		 */
		// get the views
		EditText itemName = (EditText) findViewById(R.id.itemNameEditText);
		DatePicker itemDateDatePicker = (DatePicker) findViewById(R.id.itemDateDatePicker);
		Calendar calendar = Calendar.getInstance();
		calendar.set(itemDateDatePicker.getYear(),
				itemDateDatePicker.getMonth(),
				itemDateDatePicker.getDayOfMonth());

		Spinner itemCategorySpinner = (Spinner) findViewById(R.id.itemCategorySpinner);
		Spinner currencyUnitsSpinner = (Spinner) findViewById(R.id.currencyUnitsSpinner);
		EditText itemCurrencyEeditText = (EditText) findViewById(R.id.itemCurrencyEditText);

		EditText fragmentEditItem2DiscriptionEditText = (EditText) findViewById(R.id.fragmentEditItem2DiscriptionEditText);

		ImageButton imageButton = (ImageButton) findViewById(R.id.addRecieptImageButton);

		// create an item
		
		
		
		if (addEditItemStatus == 0) {
			Item newitem = new Item(itemName.getText().toString());
			newitem.setItemDate(calendar.getTime());

			newitem.setItemCategory(itemCategorySpinner.getSelectedItem()
					.toString());

			String tempAmountStr = itemCurrencyEeditText.getText().toString();
			int tempAmountInt = 0;
			try {
				tempAmountInt = Integer.valueOf(tempAmountStr);
			} catch (NumberFormatException e) {
				tempAmountInt = 0;
			}
			Currency tempCurrency = new Currency(currencyUnitsSpinner
					.getSelectedItem().toString(), tempAmountInt);
			newitem.setItemCurrency(tempCurrency);

			newitem.setItemDescription(fragmentEditItem2DiscriptionEditText
					.getText().toString());

			// controller.addItem(this.item);
			if (receiptFlag == 1){
				newitem.setReceipBitmap(bitmap);

			}
			controller.addItem(newitem);
			UpdateThread update = new UpdateThread(controller.getClaim());
			update.start();
			
			/**
			 * part end here
			 */
		}else {
			Toast.makeText(this, controller.getClaim().getClaim()+itemId+controller.getClaim().getItems().size(), Toast.LENGTH_LONG)
			.show();
			controller.getClaim().getPosition(itemId).setItemDate(calendar.getTime());
			controller.getClaim().getPosition(itemId).setItemName(itemName.getText().toString());
			controller.getClaim().getPosition(itemId).setItemCategory(itemCategorySpinner.getSelectedItem()
					.toString());
			String tempAmountStr = itemCurrencyEeditText.getText().toString();
			int tempAmountInt = 0;
			try {
				tempAmountInt = Integer.valueOf(tempAmountStr);
			} catch (NumberFormatException e) {
				tempAmountInt = 0;
			}
			Currency tempCurrency = new Currency(currencyUnitsSpinner
					.getSelectedItem().toString(), tempAmountInt);
			controller.getClaim().getPosition(itemId).setItemCurrency(tempCurrency);

			controller.getClaim().getPosition(itemId).setItemDescription(fragmentEditItem2DiscriptionEditText
					.getText().toString());
			if (receiptFlag == 1){
				controller.getClaim().getPosition(itemId).setReceipBitmap(bitmap);

			}
			UpdateThread update = new UpdateThread(controller.getClaim());
			update.start();
			

		}

		Intent intent = new Intent(EditItemActivity.this,
				OneClaimActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("MyClaimName", claimName);
		startActivity(intent);
		finish();
	}

	/**
	 * active the camera button
	 * 
	 * @author Yufei Zhang
	 * @version 1.0
	 * @since 2015-03-02
	 */
	public void addReciept(View view) {
		/**
		 * we need to add code here doing the following things 1. Add a new
		 * reciept and show it on this imageView
		 **/
		Toast.makeText(EditItemActivity.this,
				"Add a Reciept\nWe will finish it\nin project 5.",
				Toast.LENGTH_SHORT).show();
	}
	
	public void setReceiptBitmap(Bitmap bitmap , int receiptFlag) {
		// TODO Auto-generated method stub
		this.bitmap = bitmap;
		this.receiptFlag = receiptFlag;
	}
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
			runOnUiThread(doFinishEdit);
		}
	}
	class GetClaimThread extends Thread {
		private String claimName;

		public GetClaimThread(String claimName) {
			this.claimName = claimName;
		}

		public void run() {
			controller = new ItemEditController(
					onlineManager.getClaim(claimName));
			runOnUiThread(FinishLoad);
		}
	}
}
