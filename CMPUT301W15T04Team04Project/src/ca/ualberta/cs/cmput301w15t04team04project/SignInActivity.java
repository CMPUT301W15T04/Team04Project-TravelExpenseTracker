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
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends Activity {
	private EditText userName;
	public static User user;
	private SignInController signInConroller;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// load the old user
		user = SignInManager.loadFromFile(this,"UserStatus");
		
		if (user.getLoginStatus()==true){
			// skip login page if already loged in
			Intent intent = new Intent(SignInActivity.this,
					MainActivity.class);
			startActivity(intent);
			finish();
		} else {
			setContentView(R.layout.activity_signin);
			getActionBar().setTitle("Sign In");
			userName = (EditText) findViewById(R.id.userNameEditText);
		}
	}
	
	/**
	 * 
	 * @author Chenrui Lei
	 * @author Yufei Zhang 
	 * @version 1.0
	 * @since 2015-03-11
	 */
	
	public void signIn(View v){
		String userNameInput = userName.getText().toString();
		if(userNameInput.length() == 0){
			Toast.makeText(this, "You must enter your name!" ,Toast.LENGTH_SHORT).show();
		}else{
			// create a new user and change it's longinStatus to true
			user = new User(userNameInput);
			user.changeLoginStatus();
			
			// goto the main page
			Intent intent = new Intent(SignInActivity.this,
					MainActivity.class);
			startActivity(intent);
			finish();
			
			// store the user info
			SignInManager.saveInFile(user,this,"UserStatus");
		}
	}
	
}