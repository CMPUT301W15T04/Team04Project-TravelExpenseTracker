package ca.ualberta.cs.cmput301w15t04team04project.models;

import java.util.ArrayList;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
/**
* The ClaimList model is just a rough ClaimList's information
* simply store set and get all of the ClaimList
*
* @author  Weijie Sun
* @version 1.0
* @since   2015-03-08 
*/

public class ClaimList {
	protected ArrayList<Claim> claimList;
	
	public void addClaim(Claim claim) {
		this.claimList.add(claim);
		
	}

}
