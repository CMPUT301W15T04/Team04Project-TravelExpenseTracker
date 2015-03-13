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

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
/**
* The MyLocalClaimList Controller is a controller of the MyClaimActivity
* simply Change the Thing that Activity related
*
* @param	claimlist is the ClaimList get from Manager
* @author  Weijie Sun
* @version 1.0
* @since   2015-03-12 
* 
*/
public class MyLocalClaimListController {
	private ClaimList claimlist = new ClaimList();;

	/**
	 * MyLocalClaimListController is initial this class
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-12
	 */
	public MyLocalClaimListController(){
		//claimlist = MyLocalClaimListManager.getMyLocalClaimListManager().loadClaimList();
	}
	/**
	 * GoToEditClaim is go to EditClaimActivity
	 * 
	 * @author Weijie Sun
	 * @version 1.0
	 * @since 2015-03-12
	 */
	public void GoToEditClaim(Context context, int position){
		
		Toast.makeText(context, "Edit Claim" ,Toast.LENGTH_SHORT).show();
		Intent myintent = new Intent(context,
				EditClaimActivity.class);
		myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		myintent.putExtra("MyClaimid", position);
		context.startActivity(myintent);
		

	}
	/**
	 * deleteClaim is delete the claim which the position of which
	 * 
	 * @author Weijie Sun
	 * @version 1.0
	 * @since 2015-03-12
	 */
	public void deleteClaim(int which) {
		// TODO Auto-generated method stub
		claimlist.deleteClaim(which);
	}
	/**
	 * getClaimList is get the claim list in the Manager
	 * 
	 * @author Weijie Sun
	 * @version 1.0
	 * @since 2015-03-12
	 */	
	public ClaimList getClaimList(){

		return claimlist;
	}
}
