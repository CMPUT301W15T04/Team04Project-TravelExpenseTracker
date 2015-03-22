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
 * @author Yufei Zhang
 * @version 1.1
 * @since 2015-03-15
 */
public class FragmentEditClaim1 extends Fragment {
	private TextView claimName;
	private DatePicker startDate;
	private DatePicker endDate;
	private int year;
	private int month;
	private int day;
	private EditText descript;
	// private int addEditstatus = 0; //0 add 1 edit
	private int myClaimId;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_edit_claim_1, container,
				false);
	}

	@Override
	/**
	 * The following fix Weijie's problem
	 * 
	 * @author Chenrui
	 * @since 2015-03-15
	 * 
	 *        Improve Chenrui's code
	 * @author Yufei
	 * @since 2015-03-15
	 */
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		ClaimList claimList = MyLocalClaimListManager
				.loadClaimList(getActivity());

		Bundle bundle = getActivity().getIntent().getExtras();

		if (bundle == null) {
			EditClaimActivity.addEditStatus = 0;
		} else {
			EditClaimActivity.addEditStatus = 1;

			myClaimId = bundle.getInt("myClaimId");
			Claim currentClaim = claimList.getClaimArrayList().get(myClaimId);

			// get the views
			claimName = (EditText) getView().findViewById(
					R.id.claimNameEditText);
			startDate = (DatePicker) getView()
					.findViewById(R.id.fromDatePicker);
			endDate = (DatePicker) getView().findViewById(R.id.toDatePicker);
			descript = (EditText) getView().findViewById(
					R.id.descriptionEditText);

			// set content of view to dispaly
			claimName.setText(currentClaim.getClaim());

			day = currentClaim.getStartDate().getDate();
			month = currentClaim.getStartDate().getMonth();
			year = currentClaim.getStartDate().getYear() + 1900;
			startDate.updateDate(year, month, day);

			day = currentClaim.getEndDate().getDate();
			month = currentClaim.getEndDate().getMonth();
			year = currentClaim.getEndDate().getYear() + 1900;
			endDate.updateDate(year, month, day);

			descript.setText(currentClaim.getDescription());

			EditClaimActivity.myClaimId = this.myClaimId;

			Toast.makeText(getActivity(), currentClaim.getClaim(),
					Toast.LENGTH_SHORT).show();
		}

	}

}
