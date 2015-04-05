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

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.content.Context;

/**
 * @author Chenrui Lei
 * @version 1.0
 * @since 2015-03-12
 */
public class MainController {

	/**
	 * Constructor
	 */
	public MainController() {
		
	}

	/**
	 * logOut is use to react when logOut button be clicked
	 * Delete the user name saved in local
	 * @param context the view that pass in
	 * @author Chenrui Lei
	 */
	public void logOut(Context context) {
		// change the user info as not logged in
		User user = new User(null);
		user.setName(null);
		// store the user info
		SignInManager.saveInFile(context, user);
		// clean the local storage
		MyLocalClaimListManager.saveClaimList(context, null);
	}
}
