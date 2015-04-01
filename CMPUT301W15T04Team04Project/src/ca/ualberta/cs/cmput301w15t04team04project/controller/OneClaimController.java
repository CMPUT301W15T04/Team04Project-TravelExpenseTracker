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

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;

/**
 * OneClaimController is the controller of the OneClaimActivity
 * 
 * @author Weijie Sun
 * @version 1.0
 * @since 2015-03-13
 */

public class OneClaimController {
	private Claim claim ;

	/**
	 * @param claim
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public OneClaimController(Claim claim) {

		this.claim = claim;
	}

	/**
	 * @return claim
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public Claim getClaim() {
		if (claim == null) {
			claim = new Claim("");
		}
		return claim;
	}

	
	public void clear(){
		claim.getItems().clear();
	}
	/**
	 * @return  ArrayList<Item> 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public ArrayList<Item> getItem() {

		return getClaim().getItems();
	}

	/**
	 * @param item
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public void addItem(Item item) {
		getItem().add(item);
		getClaim().notifyListener();
	}

	/**
	 * @param index
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public void deleteItem(int index) {
		getItem().remove(index);
		getClaim().notifyListener();

	}

	/**
	 * OneClaimController is initial
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */

	public OneClaimController() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * submittedClaim is submitted Claim
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	/**
	 * @param which
	 */
	public void submittedClaim() {
		claim.setStatus("submitted");
	}

	/**
	 * confirmClaim is confirm Claim
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	/**
	 * @param which
	 */
	public void confirmClaim() {
		// TODO Auto-generated method stub

	}

	/**
	 * returnClaim is return Claim
	 * 
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */

	public void returnClaim(int which) {
		// TODO Auto-generated method stub

	}

	/**
	 * approveClaim is approve Claim
	 * @param which
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */

	public void approveClaim(int which) {
		// TODO Auto-generated method stub

	}



}
