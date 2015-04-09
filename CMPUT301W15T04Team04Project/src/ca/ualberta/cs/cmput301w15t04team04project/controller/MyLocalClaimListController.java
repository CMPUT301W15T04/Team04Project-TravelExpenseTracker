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

import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;

/**
 * The MyLocalClaimList Controller is a controller of the MyClaimActivity simply
 * Change the Thing that Activity related
 * 
 * @param claimlist
 *            is the ClaimList get from Manager
 * @author Youdong Ma
 * @version 1.0
 * @since 2015-03-12
 * 
 */
public class MyLocalClaimListController {
	private ClaimList claimList;
	public MyLocalClaimListController(){
		
	}
	
	public MyLocalClaimListController(ClaimList claimList){
		this.claimList = claimList;
	}
	/**
	 * get the list of claims if the list does not exist, create a new one
	 */
	public ClaimList getClaimList(){
		if (claimList == null) {
			claimList = new ClaimList();
		}
		return claimList;
	}
	
	/**
	 * add all claims in the arrayList to the cliamList
	 * @param arrayList
	 */
	
	public void addall(ArrayList<Claim> arrayList){
		getClaimList().getClaimArrayList().addAll(arrayList);
	}
	
	/**
	 * clean the list of claims
	 */
	
	public void clear(){
		getClaimList().getClaimArrayList().clear();
	}

	/**
	 * get ArrayList of Claim
	 * 
	 * @return ArrayList of Claim
	 */
	public ArrayList<Claim> getClaims() {

		return getClaimList().getClaimArrayList();
	}

	/**
	 * delete the claim by given index
	 * 
	 * @author Youdong Ma
	 * @param index
	 */
	public void deleteClaim(int index) {
		getClaims().remove(index);
	}
	
	/**
	 * sort Claim by start date newest first
	 */
	public void sortClaimNewFirst(){
		for (int i = 0; i < (getClaims().size() - 1); i++) {
			for (int j = i; j < (getClaims().size() - 1 ); j++) {
				if (getClaims().get(j).getStartDate().getTime()  > getClaims().get(j+1).getStartDate().getTime()) {
					Claim bigger = getClaims().get(j);
					getClaims().remove(bigger);
					getClaims().add(bigger);
				}else{
					Claim bigger = getClaims().get(j+1);
					getClaims().remove(bigger);
					getClaims().add(bigger);
				}
				
			}
		}
	}
	/**
	 * sort Claim by start date oldest first
	 */
	public void sortClaimOldFirst(){
		for (int i = 0; i < (getClaims().size() - 1); i++) {
			for (int j = i; j < (getClaimList().size() - 1 - i); j++) {
				if (getClaims().get(j).getStartDate().getTime()  < getClaims().get(j+1).getStartDate().getTime()) {
					Claim bigger = getClaims().get(j);
					getClaims().remove(bigger);
					getClaims().add(bigger);
				}else{
					Claim bigger = getClaims().get(j+1);
					getClaims().remove(bigger);
					getClaims().add(bigger);
				}
				
			}
		}
	}
	/**
	 * Update a claim by finding the original one remove it and adding the new one
	 * @param claim
	 */
	public void update(Claim claim) {
		// TODO Auto-generated method stub
		for  (int i = 0; i < getClaims().size(); i++) {
			if (getClaims().get(i).getClaim().equals(claim.getClaim())){
				getClaims().remove(i);
				getClaims().add(claim);
				break;
			}
		}
	}
    /**
     * delete a claim by a given claim name.
     * @param claimName
     */

		
	public void delete(String claimName) {
		for  (int i = 0; i < getClaims().size(); i++) {
			if (getClaims().get(i).getClaim().equals(claimName)){
				getClaims().remove(i);
				break;
			}
		}
	}

	public Claim getClaim(String claimName) {
		for  (int i = 0; i < getClaims().size(); i++) {
			if (getClaims().get(i).getClaim().equals(claimName)){
				return getClaims().get(i);
			}
		}
		return null;
	}

	public ArrayList<Claim> getClaimsByStatus(String searchString) {
		ArrayList<Claim> claims = new ArrayList<Claim>();
		for  (int i = 0; i < getClaims().size(); i++) {
			if (getClaims().get(i).getStatus().equals(searchString)){
				claims.add(getClaims().get(i));
			}
		}
		return claims;
	}

	/**
	 * upload online editing
	 */
	public void upload(Context context) {
		for  (int i = 0; i < getClaims().size(); i++) {
			if (getClaims().get(i).getStatus().equals("In Progress")||getClaims().get(i).getStatus().equals("returned")){
				AddThread add = new AddThread(getClaims().get(i), context);
				add.start();
			}
		}
	}
	class AddThread extends Thread {
		private Claim claim;
		private Context context;
		public AddThread(Claim claim, Context context) {
			this.claim = claim;
			this.context = context;
		}
		@Override
		public void run() {
			try {
				CLmanager manager = new CLmanager();
				manager.offlineInsertClaim(claim, context, claim.getClaimiant());
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}