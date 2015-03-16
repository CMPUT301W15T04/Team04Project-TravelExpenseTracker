package ca.ualberta.cs.cmput301w15t04team04project.controller;

import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.SearchActivity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MainController {
	
	public MainController(){
	}
	
	public void logOut(Context context){
		// change the user info as not logged in
		User user = new User(null);
		user.setName(null);
		
		// store the user info
		storeUserProfile(user, context);
	}

	
	
}
