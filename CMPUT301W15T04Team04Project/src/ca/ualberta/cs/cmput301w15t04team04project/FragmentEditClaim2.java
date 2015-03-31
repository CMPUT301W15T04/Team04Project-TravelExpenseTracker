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
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
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
	private String ClaimName;
	// private ArrayList<String> tags;
	private EditText tags;
	private String tag = "";
	// private ArrayList<Destination> destinations;
	private EditText destinations;
	private String destination = "";
	protected ClaimEditController controller2;
	private ArrayList<String> DestinationList = new ArrayList<String>();
	private CLmanager onlineManager2;
	private ArrayAdapter<String> DestinationListAdapter;

	private Runnable doFinish2 = new Runnable() {
		public void run() {
			int tagsSize = controller2.getClaim().getTag().size();
			int desnSize = controller2.getClaim().getDestination().size();

			// Build the new tags and destinations
			for (int i = 0; i < tagsSize; i++) {
				if (i != 0) {
					tag = tag + "," + controller2.getClaim().getTag().get(i);
				} else {
					tag = controller2.getClaim().getTag().get(i);
				}
			}

			for (int j = 0; j < desnSize; j++) {
				if (j == 0) {
					destination = controller2.getClaim().getDestination().get(j)
							.getdName()
							+ "("
							+ controller2.getClaim().getDestination().get(j)
									.getdReason() + ")";
				} else {
					destination = destination
							+ "\n"
							+ controller2.getClaim().getDestination().get(j)
									.getdName()
							+ "("
							+ controller2.getClaim().getDestination().get(j)
									.getdReason() + ")";
				}
			}
			tags.setText(tag);
			destinations.setText(destination);
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_edit_claim_2, container,
				false);
	}

	/**
	 * onActivityCreated is Edit Claim or Add Claim
	 * 
	 * The following fix Weijie's problem
	 * 
	 * @author Chenrui
	 * @since 2015-03-15
	 * 
	 *        Improve Chenrui's code
	 * @author Yufei
	 * @since 2015-03-15
	 **/
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		onlineManager2 = new CLmanager();
		Bundle bundle = getActivity().getIntent().getExtras();
		ListView DestinationListView = (ListView) getActivity().findViewById(
				R.id.destinationListView);
		Button addDestinationButton = (Button) getActivity().findViewById(
				R.id.button1);
		ButtonListener addDestinationButtonListener = new ButtonListener();
		addDestinationButton.setOnClickListener(addDestinationButtonListener);
		DestinationListAdapter = new ArrayAdapter<String>(getActivity(),
				R.layout.list_item, DestinationList);
		DestinationListView.setAdapter(DestinationListAdapter);
		DestinationListAdapter.notifyDataSetChanged();
		controller2 = new ClaimEditController();
		if (bundle == null) {
			EditClaimActivity.addEditStatus = 0;
		} else {
			EditClaimActivity.addEditStatus = 1;
			tags = (EditText) getView().findViewById(R.id.tagEditText);
			destinations = (EditText) getView().findViewById(
					R.id.destinationEditText);
			ClaimName = bundle.getString("MyClaimName");
			GetThread2 getClaim2 = new GetThread2(ClaimName);
			getClaim2.start();
			// get the views

			// get the size of two ListViews

			// set content of view to dispaly
			

			// descript.setText(currentClaim.getDescription());

			// EditClaimActivity.myClaimId = this.myClaimId;
		}
	}

	protected static ArrayList<Destination> desList = new ArrayList<Destination>();

	class ButtonListener implements View.OnClickListener {
		@Override
		public void onClick(View view) {
			// find informations from views
			String destination = ((EditText) getActivity().findViewById(
					R.id.destinationEditText)).getText().toString();
			String reason = ((EditText) getActivity().findViewById(
					R.id.reasonEditText)).getText().toString();
			DestinationList.add(destination);
			DestinationListAdapter.notifyDataSetChanged();
			controller2.destinationSet(desList, destination, reason);
			
			// show to user
			Toast.makeText(getActivity().getBaseContext(), "Destination added",
					Toast.LENGTH_SHORT).show();

			// /finish();
		}
	}

	class GetThread2 extends Thread {
		private String cName;

		public GetThread2(String claimName) {
			this.cName = claimName;
		}

		@Override
		public void run() {
			try {
				Claim claim = onlineManager2.getClaim(cName);
				controller2.setClaimObj(claim);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getActivity().runOnUiThread(doFinish2);
		}
	}
}
