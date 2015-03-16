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

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Destination;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * This is the fragment part 2 for adding/editing a claim.
 * 
 * @author Ji Yang
 * @author Yang Zhang
 * @version 1.0
 * @since 2015-03-10
 * @author Yufei Zhang
 * @version 1.1
 * @since 2015-03-15
 */

public class FragmentEditClaim2 extends Fragment {
	private int myClaimId;
	// private ArrayList<String> tags;
	private EditText tags;
	private String tag = "";
	// private ArrayList<Destination> destinations;
	private EditText destinations;
	private String destination = "";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_edit_claim_2, container,
				false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

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
		ClaimList claimList = MyLocalClaimListManager.loadClaimList(
				getActivity());

		Bundle bundle = getActivity().getIntent().getExtras();

		if (bundle == null) {
			EditClaimActivity.addEditStatus = 0;
		} else {
			EditClaimActivity.addEditStatus = 1;

			myClaimId = bundle.getInt("myClaimId");
			Claim currentClaim = claimList.getClaimArrayList().get(myClaimId);

			// get the views
			tags = (EditText) getView().findViewById(R.id.tagEditText);
			destinations = (EditText) getView().findViewById(
					R.id.destinationandReasonEditText);

			// get the size of two ListViews
			int tagsSize = currentClaim.getTag().size();
			int desnSize = currentClaim.getDestination().size();

			// Build the new tags and destinations
			for (int i = 0; i < tagsSize; i++) {
				if (i != 0) {
					tag = tag + "," + currentClaim.getTag().get(i);
				} else {
					tag = currentClaim.getTag().get(i);
				}
			}

			for (int j = 0; j < desnSize; j++) {
				if (j == 0) {
					destination = currentClaim.getDestination().get(j)
							.getdName()
							+ "("
							+ currentClaim.getDestination().get(j).getdReason()
							+ ")";
				} else {
					destination = destination + "\n"
							+ currentClaim.getDestination().get(j).getdName()
							+ "("
							+ currentClaim.getDestination().get(j).getdReason()
							+ ")";
				}
			}

			// set content of view to dispaly
			tags.setText(tag);
			destinations.setText(destination);

			// descript.setText(currentClaim.getDescription());

			// EditClaimActivity.myClaimId = this.myClaimId;

			Toast.makeText(getActivity(), tag, Toast.LENGTH_SHORT).show();
		}
	}

}
