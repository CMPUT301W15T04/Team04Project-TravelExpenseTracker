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

import java.io.IOException;
import java.util.ArrayList;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Destination;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * <b>This is the fragment part 2 for adding/editing a claim.</b><br>
 * <OL>
 * <LI>In this part, you need to fill out the information shown on the scream.
 * <UL>
 * <LI>Enter the tag(s) of a claim (String).<br>
 * If you want to add several tags, you need to split several tag by comma.<br>
 * For example (tag1, tag2) will add tag1 and tag2 to the claim.
 * <LI>Enter the destination of the claim by click "Add"
 * The first row is using for adding the name of the destination.
 * The second row is using for describe the reason why you went there.
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

public class FragmentEditClaim2 extends Fragment {
	private String ClaimName;
	// private ArrayList<String> tags;
	private EditText tags;
	private String tag = "";
	// private ArrayList<Destination> destinations;
	private ListView DestinationListView;
	protected ClaimEditController controller2;
	private ArrayList<Destination> destinationList = new ArrayList<Destination>();
	private CLmanager onlineManager2;
	private ArrayAdapter<Destination> DestinationListAdapter;

	private Runnable doFinish2 = new Runnable() {
		public void run() {
			int tagsSize = controller2.getClaim().getTag().size();
			// Build the new tags and destinations
			for (int i = 0; i < tagsSize; i++) {
				if (i != 0) {
					tag = tag + "," + controller2.getClaim().getTag().get(i);
				} else {
					tag = controller2.getClaim().getTag().get(i);
				}
			}
			destinationList.addAll(controller2.getClaim().getDestination());
			EditClaimActivity.destinationList = destinationList;
			tags.setText(tag);
			DestinationListAdapter.notifyDataSetChanged();
		}
	};

	/**
	 * Version of onCreateView(String, Context, AttributeSet) that also supplies 
	 * the parent that the view created view will be placed in.
	 * 
	 * @param inflater
	 * @param container
	 * @param savedInstanceState
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_edit_claim_2, container,
				false);
	}

	/**
	 * <b>onActivityCreated is Edit Claim or Add Claim</b><br>
	 * Called when the fragment's activity has been created and this fragment's view hierarchy instantiated.<br>
	 * It can be used to do final initialization once these pieces are in place, such as retrieving views or restoring state.<br>
	 * It is also useful for fragments that use setRetainInstance(boolean) to retain their instance, 
	 * as this callback tells the fragment when it is fully associated with the new activity instance.<br>
	 * This is called after onCreateView(LayoutInflater, ViewGroup, Bundle) and before onViewStateRestored(Bundle).
	 * 
	 * @param savedInstanceState	If the fragment is being re-created from a previous saved state, this is the state.
	 * @author Chenrui
	 * @since 2015-03-15
	 * @author Yufei
	 * @since 2015-03-15
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		onlineManager2 = new CLmanager();
		Bundle bundle = getActivity().getIntent().getExtras();
		DestinationListView = (ListView) getActivity().findViewById(
				R.id.destinationListView);
		Button addDestinationButton = (Button) getActivity().findViewById(
				R.id.setHomeLocationButton);
		ButtonListener addDestinationButtonListener = new ButtonListener();
		addDestinationButton.setOnClickListener(addDestinationButtonListener);
		DestinationListAdapter = new ArrayAdapter<Destination>(getActivity(),
				R.layout.list_item, destinationList);
		DestinationListView.setAdapter(DestinationListAdapter);
		controller2 = new ClaimEditController();
		if (bundle == null) {
			EditClaimActivity.addEditStatus = 0;
		} else {
			EditClaimActivity.addEditStatus = 1;
			tags = (EditText) getView().findViewById(R.id.tagEditText);
			ClaimName = bundle.getString("MyClaimName");
			GetThread2 getClaim2 = new GetThread2(ClaimName);
			getClaim2.start();
		}
	}
	/**
	 * <b>This class is using for adding the destination once user click the "Add" button.</b>
	 * <br>
	 * The destination name and the reason will be shown as destination(reason) below the
	 * title "Destination & Reason"
	 * 
	 * @author Yufei Zhang
	 */
	class ButtonListener implements View.OnClickListener {
		@Override
		public void onClick(View view) {
			// find informations from views
			String destination = ((EditText) getActivity().findViewById(
					R.id.destinationEditText)).getText().toString();
			String reason = ((EditText) getActivity().findViewById(
					R.id.reasonEditText)).getText().toString();
			destinationList.add(new Destination(destination,reason));
			EditClaimActivity.destinationList = destinationList;
			DestinationListAdapter.notifyDataSetChanged();

			// show to user
			Toast.makeText(getActivity().getBaseContext(), "Destination added",
					Toast.LENGTH_SHORT).show();

			// /finish();
		}
	}

	/**
	* <b>This class is get a claim thread by the cName(string)</b>
	* @param cName This is a string of the name of a claim 
	* @exception IOException On input error.
	* @see IOException
	* @exception IllegalStateException On input error.
	* @see IllegalStateException
	*/
	class GetThread2 extends Thread {
		private String cName;

		public GetThread2(String claimName) {
			this.cName = claimName;
		}

		@Override
		public void run() {
			try {
				controller2.setClaimObj(onlineManager2.getClaim(cName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			getActivity().runOnUiThread(doFinish2);
		}
	}
}
