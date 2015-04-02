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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ItemEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * This is the fragment part 1 for adding/editing an item.
 * 
 * @author Ji Yang
 * @author Yang Zhang
 * @version 1.0
 * @since 2015-03-10
 * @author Yufei Zhang
 * @version 1.1
 * @since 2015-03-15
 */
public class FragmentEditItem1 extends Fragment {
	private TextView itemName;
	private DatePicker datePicker;
	private Spinner currencyUnit;
	private TextView amount;
	private Spinner category;
	private int myItemId;
	private int myClaimId;
	private Resources res;
	private ItemEditController controller;
	private CLmanager onlineManager = new CLmanager();
	private String claimName;
	
	private Runnable finishLoad =  new Runnable() {
		public void run() {
			Item currentItem = controller.getClaim().getPosition(myItemId);
			itemName.setText(currentItem.getItemName());

			// set item date
			@SuppressWarnings("deprecation")
			int date = currentItem.getItemDate().getDate();
			@SuppressWarnings("deprecation")
			int month = currentItem.getItemDate().getMonth();
			@SuppressWarnings("deprecation")
			int year = currentItem.getItemDate().getYear() + 1900;
			datePicker.updateDate(year, month, date);
			// set ammount
			amount.setText("" + currentItem.getItemCurrency().getAmount());
			res = getResources();
			String[] cates = res.getStringArray(R.array.categories);
			String selection = currentItem.getItemCategory();
			int pick = Arrays.asList(cates).indexOf(selection);
			category.setSelection(pick);
			String[] units = res.getStringArray(R.array.currencyUnits);
			String selection2 = currentItem.getItemCurrency().getType();
			int pick2 = Arrays.asList(units).indexOf(selection2);
			currencyUnit.setSelection(pick2);
		}
	};
	
	/**
	 * This is the onCreateView of initial the view
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-15
	 */
	// private ArrayAdapter<String> categoryAdapter ;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater
				.inflate(R.layout.fragment_edit_item_1, container, false);

	}

	/**
	 * This is the onActivityCreated of create Item or Edit item set the
	 * original information in the View
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-15
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Bundle bundle = getActivity().getIntent().getExtras();
		if (bundle.size() == 1) {
			EditItemActivity.addEditItemStatus = 0;
		} else if (bundle.size() == 2) {
			EditItemActivity.addEditItemStatus = 1;
			claimName = bundle.getString("MyClaimName");
			myItemId = bundle.getInt("myItemId");
			itemName = (TextView) getView().findViewById(R.id.itemNameEditText);
			datePicker = (DatePicker) getView().findViewById(
					R.id.itemDateDatePicker);
			category = (Spinner) getView().findViewById(
					R.id.itemCategorySpinner);
			currencyUnit = (Spinner) getView().findViewById(
					R.id.currencyUnitsSpinner);
			amount = (TextView) getView().findViewById(
					R.id.itemCurrencyEditText);
			EditItemActivity.itemId = this.myItemId;
			GetThread get = new GetThread(claimName);
			get.start();
			// set item name
			

			
		}

	}
	class GetThread extends Thread{ 
		private String claimName;
		
		public GetThread(String claimName){
			this.claimName = claimName;
		}
		
		public void run(){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			controller = new ItemEditController(onlineManager.getClaim(claimName));
			getActivity().runOnUiThread(finishLoad);
		}
		
	}
}
