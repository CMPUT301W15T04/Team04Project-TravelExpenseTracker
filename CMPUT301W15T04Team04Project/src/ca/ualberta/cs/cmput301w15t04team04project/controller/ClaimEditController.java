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

import java.util.ArrayList;
import java.util.Date;
import java.util.jar.Attributes.Name;

import android.hardware.Camera.Size;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

/**
 * This controller can control add or edit claim in ClaimEditActivity
 * @author Youdong Ma
 * @author Ji Yang 
 */

public class ClaimEditController extends MyLocalClaimListController {

	private Claim claim;

	/**
	 * ClaimEditController is initialed
	 */
	public ClaimEditController() {
		claim = new Claim(null);
	}

	public void setClaimObj(Claim claim) {
		this.claim = claim;
	}
	/**
	 * setClaim 
	 * @param cName
	 * @param cDescription
	 * @param cTag
	 * @param sDate
	 * @param eDate
	 * @param destination
	 * @param user
	 * @param items
	 * @param comments
	 * @return
	 */
	public Claim setClaim(String cName, String cDescription, String cTag,
			Date sDate, Date eDate, ArrayList<Destination> destination, String user, ArrayList<Item> items, ArrayList<String> comments) {
		claim.setClaim(cName);
		claim.setDescription(cDescription);
		claim.setTag(tagSplit(cTag));
		claim.setStartDate(sDate);
		claim.setEndDate(eDate);
		claim.setDestination(destination);
		claim.setClaimiant(user);
		claim.setItems(items);
		claim.setComment(comments);
		return claim;
	}

	/**
	 * tag is a string with ',', we need to split it by ',' to be a Array list of string
	 * @param tag
	 * @return
	 */

	public ArrayList<String> tagSplit(String tag) {
		ArrayList<String> tags = new ArrayList<String>();
		String[] temp = tag.split(",");
		for (int i = 0; i < temp.length; i++) {
			tags.add(temp[i]);
		}
		return tags;
	}
	/**
	 * get claim from this controller
	 * @return Claim
	 */

	public Claim getClaim(){
		return claim;
	}

}
