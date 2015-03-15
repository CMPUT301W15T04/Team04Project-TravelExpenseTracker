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
<<<<<<< HEAD
import android.widget.DatePicker;
=======
>>>>>>> origin/master
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
		//View editFrame1 = getActivity().findViewById(R.id.);
<<<<<<< HEAD

		claimName = (TextView) getView().findViewById(R.id.claimNameEditText);
		startDate = (DatePicker) getView().findViewById(R.id.fromDatePicker);
		endDate   = (DatePicker) getView().findViewById(R.id.toDatePicker);
		descript = (EditText) getView().findViewById(R.id.descriptionEditText);
		
		claimName.setText(EditClaimActivity.claimNameF);
		startDate.init(2000, 02, 14, null);
		endDate.init(2015, 02, 14, null);
		descript.setText(EditClaimActivity.descript);
=======
		
		/*
		claimname = (EditText) getView().findViewById(R.id.claimNameEditText);
		claimname.setText("Testing Edit Name");//EditClaimActivity.thisClaim.getClaim().toString());
		*/
		
		/**
		 * The following fix Weijie's problem
		 * 
		 * @author  Chenrui
		 * @since   2015-03-15
		 */
		ClaimList claimList = MyLocalClaimListManager.loadClaimList(getActivity(), "local");
		
		Bundle bundle = getActivity().getIntent().getExtras();
		if (bundle == null){
			
			addEditstatus = 0;
		}
		else{
			addEditstatus = 1;
			int claimid = bundle.getInt("MyClaimid");
			Toast.makeText(getActivity(), "Expense Item" + claimid, Toast.LENGTH_SHORT).show();
			Claim storeclaim = claimList.getClaimArrayList().get(claimid);
			claimname = (EditText) getView().findViewById(R.id.claimNameEditText);
			String claimNameStr = storeclaim.getClaim().toString();
			claimname.setText(claimNameStr);//"Shabi");//storeclaim.getClaim().toString());//claimNameStr);
			Toast.makeText(getActivity(), claimNameStr, Toast.LENGTH_SHORT).show();
		}
>>>>>>> origin/master
	}

}
