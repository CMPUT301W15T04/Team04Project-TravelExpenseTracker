package ca.ualberta.cs.cmput301w15t04team04project.models;

import java.util.ArrayList;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;

public class ClaimList {
	protected ArrayList<Claim> claimList;
	
	public void addClaim(Claim claim) {
		this.claimList.add(claim);
		
	}

}
