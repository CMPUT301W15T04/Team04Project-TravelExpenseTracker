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
package ca.ualberta.cs.cmput301w15t04team04project.controller;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.SignInActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

/**
 * The sign in controller is a controller for sign in view
 * 
 * @author Chenrui Lei
 * @version 1.0
 * @since 2015-03-12
 */

public class SignInController {

	
	public SignInController() {
		// constructor stub
	}

	/**
	 * signIn is use to react when signIn button be clicked
	 * get the claimant name in EditText 
	 * the save it in local
	 * @param context the view that pass in
	 * @param userName the EditText that user inputed at
	 * @since 2015-03-12
	 */
	public void signIn(Context context, EditText userName) {
		String userNameInput = userName.getText().toString();
		if (userNameInput.length() == 0) {
			Toast.makeText(context, "You must enter your name!",
					Toast.LENGTH_SHORT).show();
		} else {
			// create a new user and change it's longinStatus to true
			User user = new User(userNameInput);
			user.changeLoginStatus();
			// SignInActivity.user = user;

			// store the user info
			SignInManager.saveInFile(context, user);

			// goto the main page
			Intent intent = new Intent(context, MainActivity.class);
			context.startActivity(intent);
		}
	}
}
