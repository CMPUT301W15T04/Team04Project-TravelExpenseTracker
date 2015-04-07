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

package ca.ualberta.cs.cmput301w15t04team04project.models;

import android.location.Location;

/**
 * The User model is just a rough User's information simply store set and get
 * all of the User
 * 
 * @author Chenrui Lei
 * @author Weijie Sun
 * @version 1.0
 * @since 2015-03-08
 * 
 */

public class User {
	protected boolean loginStatus = false;
	protected String name = null;
	protected Location homelocation = null;
	
	/*
	 * Constructor of User
	 */
	public User(String userName) {
		name = userName;
	}

	
	public Location getHomelocation() {
		return homelocation;
	}


	public void setHomelocation(Location homelocation) {
		this.homelocation = homelocation;
	}


	public boolean getLoginStatus() {
		return loginStatus;
	}

	/**
	 * changeLoginStatus is to change attribute loginStatus under a User
	 */
	public void changeLoginStatus() {
		if (loginStatus) {
			loginStatus = false;
		} else {
			loginStatus = true;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String nameInput) {
		name = nameInput;
	}

}
