package ca.ualberta.cs.cmput301w15t04team04project.controller;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.SearchActivity;
/**
 * OneClaimController is the controller of the OneClaimActivity
 * 
 * @author Weijie Sun
 * @version 1.0
 * @since 2015-03-13
 */
public class OneClaimController {
	
	/**
	 * OneClaimController is initial
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public OneClaimController() {
		// TODO Auto-generated constructor stub
	
	}
	
	/**
	 * OneClaimController is initial
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public void goToSearch(Context context) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Search" ,Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(context, SearchActivity.class);
		context.startActivity(intent);
	}
	/**
	 * OneClaimController is initial
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public void goToEditClaim(Context context){
		
		Toast.makeText(context, "Add Claim" ,Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(context, EditClaimActivity.class);
		context.startActivity(intent);
	}

	/**
	 * submittedClaim is submitted Claim
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public void submittedClaim(int which) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * confirmClaim is confirm Claim
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public void confirmClaim(int which) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * returnClaim is return Claim
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public void returnClaim(int which) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * approveClaim is approve Claim
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */
	public void approveClaim(int which) {
		// TODO Auto-generated method stub
		
	}
	
}
