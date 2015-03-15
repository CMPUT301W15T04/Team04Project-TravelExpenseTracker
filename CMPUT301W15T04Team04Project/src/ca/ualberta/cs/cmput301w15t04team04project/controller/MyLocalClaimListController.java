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

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.SearchActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Listener;

/**
 * The MyLocalClaimList Controller is a controller of the MyClaimActivity simply
 * Change the Thing that Activity related
 * 
 * @param claimlist
 *            is the ClaimList get from Manager
 * @author Weijie Sun
 * @version 1.0
 * @since 2015-03-12
 * 
 */
public class MyLocalClaimListController {
	private ClaimList claimList = new ClaimList();

	/**
	 * MyLocalClaimListController is initial this class
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-12
	 */
	public MyLocalClaimListController(ClaimList claimList) {
		// claimlist =
		// MyLocalClaimListManager.getMyLocalClaimListManager().loadClaimList();
		this.claimList = claimList;
	}

	public ClaimList getClaimList() {

		return claimList;
	}

	/**
	 * getClaimList is get the claim list in the Manager
	 * 
	 * @author Weijie Sun
	 * @version 1.0
	 * @since 2015-03-12
	 */
	

	@SuppressWarnings("null")
	public ArrayList<Claim> getClaimsByIndex(ArrayList<Integer> indexList) {
		ArrayList<Claim> claims = new ArrayList<Claim>();
		for (int i = 0; i < indexList.size(); i++){
			claims.add(getClaims().get(indexList.get(i)));
		}
		return claims;
	}
	
	public ArrayList<Integer> getIndexList(String string){
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		for (int i = 0; i < getClaims().size(); i++){
			if (getClaims().get(i).getStatus().equals(string)){
				indexList.add(i);
			}
		}
		return indexList;
	}
	
	public ArrayList<Claim> getClaims() {

		return getClaimList().getClaimArrayList();
	}

	public void addClaim(Claim claim) {
		getClaims().add(0,claim);
		getClaimList().notifyListeners();
	}

	public void deleteClaim(int index) {
		getClaims().remove(index);
		getClaimList().notifyListeners();
	}

	public void GoToOneClaim(Context context, long id) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Edit Claim", Toast.LENGTH_SHORT).show();
		Intent myintent = new Intent(context, OneClaimActivity.class);
		myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		myintent.putExtra("MyClaimid", id);
		context.startActivity(myintent);
	}

	public void goToSearch(Context context) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(context, SearchActivity.class);
		context.startActivity(intent);
	}

}
