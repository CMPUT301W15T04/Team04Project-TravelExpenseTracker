package ca.ualberta.cs.cmput301w15t04team04project.controller;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;

public class MyLocalClaimListController2 extends MyLocalClaimListController{

	public MyLocalClaimListController2(ClaimList claimList) {
		super(claimList);
	}
	
	public void addClaim(Claim claim) {
		getClaims().add(0,claim);
		getClaimList().notifyListeners();
	}
	
}
