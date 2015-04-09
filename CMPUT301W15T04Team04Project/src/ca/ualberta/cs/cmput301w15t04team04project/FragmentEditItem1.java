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

import java.util.Arrays;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ItemEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.os.Bundle;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * <b>This is the fragment part 1 for adding/editing an item.</b><br>
 * <OL>
 * <LI>In this part, you need to fill out the information shown on the scream.
 * <UL>
 * <LI>Enter the name of an item(String).
 * <LI>Select the date of adding the item (DatePicker).
 * <LI>Select category of an item form the corresponding spinner.
 * <LI>Select the unit of the currency from the corresponding spinner.
 * <LI>Enter the price of the expense item in decimal numbers.
 * </UL> 
 * </OL>
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
	private Resources res;
	private ItemEditController controller;
	private CLmanager onlineManager = new CLmanager();
	private String claimName;
	private User user;
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
	 * Version of onCreateView(String, Context, AttributeSet) that also supplies 
	 * the parent that the view created view will be placed in.
	 * 
	 * @param parent	The parent that the created view will be placed in; note that this may be null.
	 * @param name	Tag name to be inflated.
	 * @param context	The context the view is being created in.
	 * @param attrs	Inflation attributes as specified in XML file.
	 * @return View Newly created view. Return null for the default behavior.
	 */
	// private ArrayAdapter<String> categoryAdapter ;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater
				.inflate(R.layout.fragment_edit_item_1, container, false);

	}

	/**
	 * Called when the fragment's activity has been created and this fragment's view hierarchy instantiated.<br>
	 * It can be used to do final initialization once these pieces are in place, such as retrieving views or restoring state.<br>
	 * It is also useful for fragments that use setRetainInstance(boolean) to retain their instance, 
	 * as this callback tells the fragment when it is fully associated with the new activity instance.<br>
	 * This is called after onCreateView(LayoutInflater, ViewGroup, Bundle) and before onViewStateRestored(Bundle).
	 * 
	 * @param savedInstanceState	If the fragment is being re-created from a previous saved state, this is the state.
	 * 
	 * @author Weijie Sun
	 * @author Yufei Zhang
	 * @version 1.1
	 * @since 2015-03-15
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		user = SignInManager.loadFromFile(getActivity());
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
	/**
	* <b>This class is get a claim thread by the claimName(string)</b>
	* @param claimName This is a string of the name of a claim 
	* @exception IllegalStateException On input error.
	* @see IllegalStateException
	*/
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
			controller = new ItemEditController(onlineManager.getClaim(claimName, getActivity(), user.getName()));
			getActivity().runOnUiThread(finishLoad);
		}
		
	}
}
