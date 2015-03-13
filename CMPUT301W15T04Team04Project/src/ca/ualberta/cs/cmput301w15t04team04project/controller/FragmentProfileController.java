package ca.ualberta.cs.cmput301w15t04team04project.controller;

import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class FragmentProfileController {
	
	public FragmentProfileController(){
	}
	
	public void GoToMyClaim(Context context){
		
		Toast.makeText(context, "My Claim" ,Toast.LENGTH_SHORT).show();
		Intent myintent = new Intent(context,
				MyClaimActivity.class);
		myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(myintent);

	}
	
	public void GoToWaitingClaim(Context context){
		Toast.makeText(context, "Waiting Claim List" ,Toast.LENGTH_SHORT).show();
		Intent myintent = new Intent(context,
				MyClaimActivity.class);
		myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(myintent);
		
	}
}
