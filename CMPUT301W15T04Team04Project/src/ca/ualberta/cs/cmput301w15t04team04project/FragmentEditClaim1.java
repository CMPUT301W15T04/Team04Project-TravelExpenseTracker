package ca.ualberta.cs.cmput301w15t04team04project;

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;

import android.widget.DatePicker;


import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This is the fragment part 1 for adding/editing a claim.
 * 
 * @author Ji Yang
 * @author Yang Zhang
 * @version 1.0
 * @since 2015-03-10
 */
public class FragmentEditClaim1 extends Fragment {
	private TextView claimName;
	private DatePicker startDate;
	private DatePicker endDate;
	private int year;
	private int month;
	private int day;
	private EditText descript;
	private int addEditstatus = 0; //0 add 1 edit
	private int myClaimId;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		
		
		return inflater.inflate(R.layout.fragment_edit_claim_1, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		/**
		 * The following fix Weijie's problem
		 * 
		 * @author  Chenrui
		 * @since   2015-03-15
		 * 
		 * Improve Chenrui's code
		 * @author  Yufei
		 * @since   2015-03-15
		 */
		ClaimList claimList = MyLocalClaimListManager.loadClaimList(getActivity(), "local");
		
		Bundle bundle = getActivity().getIntent().getExtras();
		
		if (bundle == null){
			EditClaimActivity.addEditstatus = 0;
		}
		else{
			EditClaimActivity.addEditstatus = 1;
			
			int claimId = bundle.getInt("myClaimId");
			Claim currentClaim = claimList.getClaimArrayList().get(claimId);
			
			claimName = (EditText) getView().findViewById(R.id.claimNameEditText);
			startDate = (DatePicker) getView().findViewById(R.id.fromDatePicker);
			endDate = (DatePicker) getView().findViewById(R.id.toDatePicker);
			descript  = (EditText) getView().findViewById(R.id.descriptionEditText);
			
			claimName.setText(currentClaim.getClaim());
			startDate.init(2000, 0, 1, null);
			endDate.init(2015, 2, 15, null);
			descript.setText("We need to solve how to get the date");
			
			Toast.makeText(getActivity(), currentClaim.getClaim(), Toast.LENGTH_SHORT).show();
		}

	}

}
