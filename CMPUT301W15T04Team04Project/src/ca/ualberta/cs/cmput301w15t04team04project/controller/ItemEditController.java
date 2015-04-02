package ca.ualberta.cs.cmput301w15t04team04project.controller;

import java.util.ArrayList;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;

public class ItemEditController{
	private Claim claim;

	
	public ItemEditController(){
		
	}
	/**
	 * @param claim
	 */
	public ItemEditController(Claim claim) {
		this.claim = claim;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param item
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-13
	 */

	public void addItem(Item item) {
		getItem().add(item);
	}
	
	public Claim getClaim() {
		if (claim == null) {
			claim = new Claim("");
		}
		return claim;
	}

	public ArrayList<Item> getItem() {
		return getClaim().getItems();
	}
}