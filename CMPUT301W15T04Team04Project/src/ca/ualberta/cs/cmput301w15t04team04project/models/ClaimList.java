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

import java.util.ArrayList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;

/**
 * The ClaimList model is design for store Claim objects in order to be used by
 * the view and modified by the controller.
 * 
 * @author Ji Yang
 * @author Yang Zhang
 * @author Weijie Sun
 * @version 1.1
 * @since 2015-03-09
 */

public class ClaimList {

	protected ArrayList<Claim> claims = null;

	/**
	 * The constructor of the class
	 * 
	 * 
	 */
	public ClaimList() {
		claims = new ArrayList<Claim>();
	}


	/**
	 * get a claim list in ArrayList date type
	 * 
	 * @return claimList the claimList in the ArrayList type .
	 */
	public ArrayList<Claim> getClaimArrayList() {
		return claims;
	}

	public int size() {
		return claims.size();
	}

}