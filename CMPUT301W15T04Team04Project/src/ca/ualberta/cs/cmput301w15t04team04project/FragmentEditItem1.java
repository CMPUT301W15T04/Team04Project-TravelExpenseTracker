package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
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
	
	//private ArrayAdapter<String> categoryAdapter ;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.fragment_edit_item_1, container, false);
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		ClaimList claimList = MyLocalClaimListManager.loadClaimList(getActivity(), "local");
		Bundle bundle = getActivity().getIntent().getExtras();
		if (bundle.size() == 1){
			EditItemActivity.addEditItemStatus = 0;
		}
		else if (bundle.size() == 2)
		{
			EditItemActivity.addEditItemStatus = 1;
			
			myClaimId = bundle.getInt("myClaimId");
			myItemId = bundle.getInt("myItemId");
			Toast.makeText(getActivity(),"Frag ItemID = " + myItemId, Toast.LENGTH_SHORT).show();
			
			Item currentItem = claimList.getClaimArrayList().get(myClaimId).getItems().get(myItemId);
			
			itemName = (TextView) getView().findViewById(R.id.itemNameEditText);
			datePicker = (DatePicker) getView().findViewById(R.id.itemDateDatePicker2);
			category = (Spinner) getView().findViewById(R.id.itemCategorySpinner);
			currencyUnit = (Spinner) getView().findViewById(R.id.currencyUnitsSpinner);
			amount = (TextView) getView().findViewById(R.id.itemCurrencyEeditText);
			
			// set item name
			itemName.setText(currentItem.getItemName());
			
			// set item date
			int date = currentItem.getDate().getDate();
			int month = currentItem.getDate().getMonth();
			int year = currentItem.getDate().getYear() + 1900;
			datePicker.updateDate(year, month, date);


			// set ammount
			amount.setText(""+currentItem.getCurrency().getAmount());

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 89b071c96095c5577b0e516125d92f1618125c4d

			
			// set item amount
			//amount.setText(Double.toString(currentItem.getCurrency().getAmount()));
			
>>>>>>> origin/master
			// set category
			res = getResources();
			String[] cates = res.getStringArray(R.array.categories);
			String selection = currentItem.getCategory();
			int pick = Arrays.asList(cates).indexOf(selection);
			category.setSelection(pick);
			
			// set currency unit 
			String[] units = res.getStringArray(R.array.currencyUnits);
			String selection2 = currentItem.getCurrency().getType();
			int pick2 = Arrays.asList(units).indexOf(selection2);
			currencyUnit.setSelection(pick2);
			
			EditItemActivity.itemId = this.myItemId;
		}
	
	}

}
