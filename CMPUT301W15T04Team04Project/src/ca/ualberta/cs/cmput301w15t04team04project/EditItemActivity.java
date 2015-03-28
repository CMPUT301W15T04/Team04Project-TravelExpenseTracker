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

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.PagerAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
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
	private OneClaimController controller;
	private Item item;
	private ClaimList claimList;
	private int claimId;
	protected static int addEditItemStatus = 0; // 0 add 1 edit
	protected static int itemId;
	private Bitmap bitmap;
	private int receiptFlag = 0;
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
		claimList = MyLocalClaimListManager.loadClaimList(this);
		Bundle bundle = getIntent().getExtras();
		claimId = bundle.getInt("myClaimId");
		receiptFlag = 0;
		// itemId = bundle.getInt("MyItemid");

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
			this.item = new Item(itemName.getText().toString());

			// put information into this item
			/*
			 * int Year = itemDateDatePicker.getYear(); int Month =
			 * itemDateDatePicker.getMonth(); int DateOfMonth =
			 * itemDateDatePicker.getDayOfMonth();
			 */
			this.item.setItemDate(calendar.getTime());

			this.item.setItemCategory(itemCategorySpinner.getSelectedItem()
					.toString());

			String tempAmountStr = itemCurrencyEeditText.getText().toString();
			float tempAmountFloat = 0;
			try {
				tempAmountFloat = Float.valueOf(tempAmountStr);
			} catch (NumberFormatException e) {
				tempAmountFloat = 0;
			}
			Currency tempCurrency = new Currency(currencyUnitsSpinner
					.getSelectedItem().toString(), tempAmountFloat);
			this.item.setItemCurrency(tempCurrency);

			this.item.setItemDescription(fragmentEditItem2DiscriptionEditText
					.getText().toString());

			// controller.addItem(this.item);
			if (receiptFlag == 1){
				this.item.setReceipBitmap(bitmap);

			}
			claimList.getClaimArrayList().get(claimId).addItem(this.item);
			MyLocalClaimListManager.saveClaimList(this, claimList);
			Toast.makeText(this, this.item.getItemName(), Toast.LENGTH_LONG)
					.show();
			/**
			 * part end here
			 */
		}

		else {

			this.item = claimList.getClaimArrayList().get(claimId).getItems()
					.get(itemId);
			this.item.setItemName(itemName.getText().toString());

			/*
			 * int Year = itemDateDatePicker.getYear(); int Month =
			 * itemDateDatePicker.getMonth(); int DateOfMonth =
			 * itemDateDatePicker.getDayOfMonth(); this.item.setDate(new
			 * Date(Year-1900,Month,DateOfMonth));
			 */

			this.item.setItemCategory(itemCategorySpinner.getSelectedItem()
					.toString());

			String tempAmountStr = itemCurrencyEeditText.getText().toString();
			float tempAmountFloat = 0;
			try {
				tempAmountFloat = Float.valueOf(tempAmountStr);
			} catch (NumberFormatException e) {
				tempAmountFloat = 0;
			}
			Currency tempCurrency = new Currency(currencyUnitsSpinner
					.getSelectedItem().toString(), tempAmountFloat);
			this.item.setItemCurrency(tempCurrency);

			this.item.setItemDescription(fragmentEditItem2DiscriptionEditText
					.getText().toString());
			if (receiptFlag == 1){
				this.item.setReceipBitmap(bitmap);

			}	
			MyLocalClaimListManager.saveClaimList(this, claimList);
			Toast.makeText(this, this.item.getItemName(), Toast.LENGTH_LONG)
					.show();

		}

		Intent intent = new Intent(EditItemActivity.this,
				OneClaimActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("myClaimId", claimId);

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
}
