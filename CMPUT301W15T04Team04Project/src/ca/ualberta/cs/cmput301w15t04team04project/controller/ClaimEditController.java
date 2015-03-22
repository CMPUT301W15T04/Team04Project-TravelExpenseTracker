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

import android.hardware.Camera.Size;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;

/**
 * @author Youdong Ma
 * @author Ji Yang
 * 
 */
public class ClaimEditController extends MyLocalClaimListController {

	/**
	 * MyLocalClaimListController2 is initialed with a claimList
	 * 
	 * @param claimList
	 */
	public ClaimEditController(ClaimList claimList) {
		super(claimList);
	}

	public ArrayList<Claim> getClaims() {
		return getClaimList().getClaimArrayList();
	}

	public Claim setClaim(Claim claim, String cName, String cDescription,
			String cTag, Date sDate, Date eDate) {
		claim.setClaim(cName);
		claim.setDescription(cDescription);
		claim.setTag(tagSplit(cTag));
		claim.setStartDate(sDate);
		claim.setEndDate(eDate);
		return claim;
	}

	public Claim setEditClaim(Claim claim, String cName, String cDescription,
			String cTag, Date sDate, Date eDate) {
		claim.setClaim(cName);
		claim.setDescription(cDescription);
		claim.setTag(tagSplit(cTag));
		claim.setStartDate(sDate);
		claim.setEndDate(eDate);
		return claim;
	};

	/*
	 * public String loadTag(ArrayList<String> tagsArray) { String tagString
	 * =""; for (String item : tagsArray) { tagString += item + ","; } return
	 * tagString; }
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
	 * insert an claim
	 * 
	 * @param claim
	 */
	public void addClaim(Claim claim) {
		getClaims().add(0, claim);
		getClaimList().notifyListeners();
	}

}
