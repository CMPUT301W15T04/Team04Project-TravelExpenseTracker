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

import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.SignInController;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * <b>SignInActivity is a page that provide a way for user to sign in</b>
 * <ol>
 * <li>User should firstly enter his or her user name
 * <li>User should secondly enter his or her password
 * <li>User should click on sign in to login the system
 * <ul>
 * <li>system will call the signIn function to check the status (new user or not).
 * <li>system will save the user's data
 * </ul>
 * </ol>
 * 
 * @author CHENRUI
 * @author Yufei Zhang
 * @version 1.0
 * @since 2015-03-13
 */
public class SignInActivity extends Activity {
	private EditText userName;
	private User user;
	private SignInController signInConroller = new SignInController();

	/**
	 * Called to do initial creation of a fragment.<br>
	 * This is called after onAttach(Activity) and before onCreateView(LayoutInflater, ViewGroup, Bundle).<br>
	 * Note that this can be called while the fragment's activity is still in the process of being created.<br>
	 * As such, you can not rely on things like the activity's content view hierarchy being initialized at this point.<br>
	 * If you want to do work once the activity itself is created, see onActivityCreated(Bundle).<br>
	 * 
	 * @param savedInstanceState	If the fragment is being re-created from a previous saved state, this is the state.
	 * @author Chenrui Lei
	 * @author Yufei Zhang
	 * @since 2015-03-13
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getActionBar().hide();
		// load the old user
		user = SignInManager.loadFromFile(this);

		if (user.getLoginStatus() == true) {
			// skip login page if already loged in
			Intent intent = new Intent(SignInActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
		} else {
			setContentView(R.layout.activity_signin);
			getActionBar().setTitle("Sign In");
			userName = (EditText) findViewById(R.id.userNameEditText);
		}
	}

	/**
	 * Call signInController to react the sign in action
	 * 
	 * @param v the view of SignInActivity
	 * 
	 * @author Chenrui Lei
	 * @author Yufei Zhang
	 * @since 2015-03-11
	 */
	public void signIn(View v) {
		signInConroller.signIn(this, userName);
		finish();
	}

}