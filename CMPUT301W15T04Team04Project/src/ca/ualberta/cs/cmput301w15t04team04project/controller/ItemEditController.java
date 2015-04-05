package ca.ualberta.cs.cmput301w15t04team04project.controller;

import java.util.ArrayList;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;

/**
 * This controller can control the EditItemActivity
 * @author youdong
 *
 */
public class ItemEditController{
	private Claim claim;

	/**
	 * Initial the controller
	 */
	public ItemEditController(){
		
	}
	/**
	 * Initial the controller
	 */
	public ItemEditController(Claim claim) {
		this.claim = claim;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * add a item in the item list
	 */

	public void addItem(Item item) {
		getItem().add(item);
	}
	/**
	 * get claim if no claim create a new one
	 * @return claim
	 */
	public Claim getClaim() {
		if (claim == null) {
			claim = new Claim("");
		}
		return claim;
	}

	/**
	 * get ArrayList of item
	 * @return list of Item
	 */
	public ArrayList<Item> getItem() {
		return getClaim().getItems();
	}
}