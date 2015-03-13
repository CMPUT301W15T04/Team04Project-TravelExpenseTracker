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

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.FragmentProfileController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.SignInController;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class FragmentProfile extends Fragment {
	private TextView tv;
	private TextView userName;
	private RadioGroup settingOption;
	private User user;
	private FragmentProfileController controller = new FragmentProfileController();
	private Context FragmentProfile = getActivity();
	
	private SignInController signInController = new SignInController();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		user  = SignInManager.loadFromFile(getActivity(),"UserStatus");
		return inflater.inflate(R.layout.fragment_profile, container, false);
	}
	
	
    @Override  
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
        userName = (TextView) getView().findViewById(R.id.userNameDisplay);
        userName.setText(user.getName());
        
        /**
        settingOption = (RadioGroup)getView().findViewById(R.id.settingGroup);
        settingOption.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.MyClaims:
					//controller.GoToMyClaim(FragmentProfile);
					Intent intent1 = new Intent(getActivity(),
							MyClaimActivity.class);
					startActivity(intent1);
					break;

				case R.id.waitingList:
					Intent intent2 = new Intent(getActivity(),
							MyClaimActivity.class);
					startActivity(intent2);
					break;

				case R.id.logOut:
				**/
        
					/**
					* Modify the following code
					*
					* @author  Chenrui Lei
					* @version 1.0
					* @since   2015-03-11
					*/
        /**
					signInController.logOut(getActivity());
					
					// go back to signIn page
					Intent intent3 = new Intent(getActivity(), SignInActivity.class);
					startActivity(intent3);
					
					// stop current view
					getActivity().finish();
					break;

				default:
					break;
				}

			}
		});*/
	}

}
