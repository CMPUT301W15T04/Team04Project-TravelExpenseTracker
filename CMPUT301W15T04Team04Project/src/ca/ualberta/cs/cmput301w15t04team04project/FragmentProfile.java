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

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * FragmentProfile is like the activity which get the User name
 * 
 * @author weijie2
 * @version 1.1
 * @date 2015-3-16
 */
public class FragmentProfile extends Fragment {
	private TextView userName;
	private User user;
	private TextView progress;
	private TextView approved;
	private TextView outBox;
	private Button addClaim;

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		user = SignInManager.loadFromFile(getActivity());
		return inflater.inflate(R.layout.fragment_profile, container, false);
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		userName = (TextView) getView().findViewById(R.id.userNameDisplay);
		userName.setText(user.getName());
		progress = (TextView) getView().findViewById(R.id.progresClaimsTextView);
		approved = (TextView) getView().findViewById(R.id.approvedClaimsTextView);
		outBox = (TextView) getView().findViewById(R.id.savedClaimsTextView);
		addClaim = (Button) getView().findViewById(R.id.addClaimButton);
		check();
	}

/*	private final LocationListener listener = new LocationListener() {
		public void onLocationChanged (Location location) {
			TextView tv = (TextView) getView().findViewById(R.id.gpsHomeLocationTextView);
			if (location != null) {
				double lat = location.getLatitude();
				double lng = location.getLongitude();
				Date date = new Date(location.getTime());
				
				tv.setText("The location is: \nLatitude: " + lat
						+ "\nLongitude: " + lng
						+ "\n at time: " + date.toString());
			} else {
				tv.setText("Cannot get the location");
			}
		}
		
		public void onProviderDisabled (String provider) {
			
		}
		
		public  void onProviderEnabled (String provider) {
			
		}
		
		public void onStatusChanged (String provider, int status, Bundle extras) {
			
		}
	};*/
	/**
	 * check if user is a approval, if yes the some view should be invisible.
	 */
	private void check() {
		if (user.getName().equals("approval")){
			progress.setVisibility(View.GONE);
			approved.setVisibility(View.GONE);
			outBox.setVisibility(View.GONE);
			addClaim.setVisibility(View.GONE);
		}
	}
}
