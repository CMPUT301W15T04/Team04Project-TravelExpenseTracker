package ca.ualberta.cs.cmput301w15t04team04project.controller;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;

public class ItemEditController extends OneClaimController {

	/**
	 * ItemEditController is extend the OneClaimController
	 */
	public ItemEditController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param claim
	 */
	public ItemEditController(Claim claim) {
		super(claim);
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
}