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

/**
 * The User model is just a rough User's information simply store set and get
 * all of the User
 *
 * @author Weijie Sun
 * @version 1.0
 * @since 2015-03-08
 */

public class User {
	private boolean loginStatus = false;
	private String name = null;

	public User(String userName) {
		name = userName;
	}

	/*
	 * public User(){ }
	 */

	/**
	 * The following two method is the getter and setter for loginStatus
	 * attribute The getter simply get the context in loginStatus The setter
	 * simply change the boolean loginStatus context
	 *
	 * @author Chenrui Lei
	 * @version 1.0
	 * @since 2015-03-11
	 */
	public boolean getLoginStatus() {
		return loginStatus;
	}

	public void changeLoginStatus() {
		if (loginStatus) {
			loginStatus = false;
		} else {
			loginStatus = true;
		}
	}

	/**
	 * The following two method is the getter and setter for name attribute The
	 * getter simply get the context of name The setter simply change the
	 * context of name
	 *
	 * @author Chenrui Lei
	 * @version 1.0
	 * @since 2015-03-11
	 */
	public String getName() {
		return name;
	}

	public void setName(String nameInput) {
		name = nameInput;
	}

}
