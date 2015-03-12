package ca.ualberta.cs.cmput301w15t04team04project.controller;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;

public class MyLocalClaimListController {
	private static ClaimList claimlist;

	public MyLocalClaimListController(){
		
	}

	public void GoToEditClaim(Context context, int position){
		
		
		
		Toast.makeText(context, "Edit Claim" ,Toast.LENGTH_SHORT).show();
		Intent myintent = new Intent(context,
				EditClaimActivity.class);
		myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		myintent.putExtra("MyClaimid", position);
		context.startActivity(myintent);
		

	}
}
