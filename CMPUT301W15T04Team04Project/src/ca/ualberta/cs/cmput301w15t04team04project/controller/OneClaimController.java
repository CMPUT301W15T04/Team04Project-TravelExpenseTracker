package ca.ualberta.cs.cmput301w15t04team04project.controller;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.SearchActivity;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
/**
 * OneClaimController is the controller of the OneClaimActivity
 * 
 * @author Weijie Sun
 * @version 1.0
 * @since 2015-03-13
 */
public class OneClaimController {
	private Claim claim 
	;
	public OneClaimController(Claim claim){
		
		this.claim = claim;
	}
	
	public Claim getClaim(){
		
		return claim;
	}
	
	public ArrayList<Item> getItem(){
		
		return getClaim().getItems();
	}
	
	public void addItem(Item item){
		getItem().add(item);
		
	}
	
	public void deleteItem1(int index){
		getItem().remove(index);
	}
	
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



	public void deleteItem(int which) {
		// TODO Auto-generated method stub
		//claim.getItems().remove(which);
		
	}
	

	
}
