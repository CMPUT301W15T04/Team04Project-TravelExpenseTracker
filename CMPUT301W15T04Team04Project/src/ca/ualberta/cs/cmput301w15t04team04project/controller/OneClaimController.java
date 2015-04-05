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
	 *
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

	/**
	 * clear the item arraylist in the claim
	 */
	
	public void clear(){
		claim.getItems().clear();
	}
	/**
	 * get items from a claim
	 */
	public ArrayList<Item> getItem() {

		return getClaim().getItems();
	}


	/**
	 * delete a item in a claim by given index
	 */
	public void deleteItem(int index) {
		getItem().remove(index);
		getClaim().notifyListener();

	}

	/**
	 * OneClaimController is initial
	 * 
	 */

	public OneClaimController() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * submitted a Claim
	 */
	public void submittedClaim() {
		claim.setStatus("submitted");
	}

	/**
	 * returnClaim is return Claim
	 */

	public void returnClaim() {
		// TODO Auto-generated method stub
		claim.setStatus("returned");
	}

	/**
	 * approve a claim.
	 */

	public void approveClaim() {
		// TODO Auto-generated method stub
		claim.setStatus("approved");
	}

	/**
	 * check if a claim complete or not
	 */
	public boolean checkComplete() {
		// TODO Auto-generated method stub
		for (int i = 0;i<claim.getItems().size();i++){
			if (claim.getItems().get(i).getItemName().isEmpty()==true){
				return false;	
			}else if(claim.getItems().get(i).getItemDescription().isEmpty()==true){
				return false;	
			}else if(claim.getItems().get(i).getItemDescription().isEmpty()==true){
				return false;
			}
		}
		if (claim.getClaim().isEmpty()==true){
			return false;
		}else if (claim.getDescription().isEmpty()==true){
			return false;
		}else if (claim.getTag().isEmpty()==true){
			return false;
		}else{
		return true;
		}
		
		
	}
	
	/**
	 * approal adds a comment to a claim
	 */
	public void addComment(String commentString) {
		// TODO Auto-generated method stub
		ArrayList<String> comments = claim.getComment();
		comments.add(commentString);
		claim.setComment(comments);
	}

}
