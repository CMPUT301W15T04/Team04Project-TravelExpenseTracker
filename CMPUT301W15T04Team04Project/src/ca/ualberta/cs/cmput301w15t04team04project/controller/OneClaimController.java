package ca.ualberta.cs.cmput301w15t04team04project.controller;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.SearchActivity;

public class OneClaimController {
	

	public OneClaimController() {
		// TODO Auto-generated constructor stub
	
	}
	
	
	public void goToSearch(Context context) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Search" ,Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(context, SearchActivity.class);
		context.startActivity(intent);
	}
	
	public void goToEditClaim(Context context){
		
		Toast.makeText(context, "Add Claim" ,Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(context, EditClaimActivity.class);
		context.startActivity(intent);
	}


	public void submittedClaim(int which) {
		// TODO Auto-generated method stub
		
	}


	public void confirmClaim(int which) {
		// TODO Auto-generated method stub
		
	}


	public void returnClaim(int which) {
		// TODO Auto-generated method stub
		
	}


	public void approveClaim(int which) {
		// TODO Auto-generated method stub
		
	}
	
}
