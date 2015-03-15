package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import android.os.Bundle;
import android.app.Activity;
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
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * This is the fragment part 1 for adding/editing an item.
 * 
 * @author Ji Yang
 * @author Yang Zhang
 * @version 1.0
 * @since 2015-03-10
 */
public class FragmentEditItem1 extends Fragment {
	private TextView itemName;
	private DatePicker datepicker;
	private TextView amount;
	private Spinner category;
	private int myItemId;
	private int myClaimId;
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
			
			Item currentItem = claimList.getClaimArrayList().get(myClaimId).getItems().get(myItemId);
			
			itemName = (TextView) getView().findViewById(R.id.itemNameEditText);
			datepicker = (DatePicker) getView().findViewById(R.id.itemDateDatePicker);
			category = (Spinner) getView().findViewById(R.id.itemCategorySpinner);
			amount = (TextView) getView().findViewById(R.id.itemCurrencyEeditText);
			
			// set item name
			itemName.setText(currentItem.getItemName());
			
			// set item date
			int date = currentItem.getDate().getDate();
			int month = currentItem.getDate().getMonth();
			int year = currentItem.getDate().getYear() + 1900;
			datepicker.updateDate(year, month, date);
<<<<<<< HEAD

			amount.setText(""+storeItem.getCurrency().getAmount());
			categoryAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getCategory());
			categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			category.setAdapter(categoryAdapter);
			category.setOnItemSelectedListener(new OnItemSelectedListener(){
				  			@Override
				             public void onItemSelected(AdapterView<?> parent, View view,
				                      int position, long id) {
				           	

				            	   
				             }
				 
			            @Override
				            public void onNothingSelected(AdapterView<?> parent) {

				             }
			       });
=======
			
			// set item amount
			amount.setText(Double.toString(currentItem.getCurrency().getAmount()));
			
>>>>>>> 1297ec66dd5094cc09804afe05829d0a70cd5b1c
			
		}
	
	}

	private List<String> getCategory() {
		// TODO Auto-generated method stub
		List<String> categoryList = new ArrayList<String>();
		categoryList.add("category1");
		categoryList.add("category2");
		
		return categoryList;
	}

}
