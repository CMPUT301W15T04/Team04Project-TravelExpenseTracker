package ca.ualberta.cs.cmput301w15t04team04project.models;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;

/**
 * The ClaimList model is design for store Claim objects in order to be used by
 * the view and modified by the controller.
 *
 * @author Ji Yang
 * @author Yang Zhang
 * @version 1.1
 * @since 2015-03-09
 */

public class ClaimList {

	protected ArrayList<Claim> claimList = null;
	protected transient ArrayList<Listener> listeners = null;

	/**
	 * The constructor of the class
	 * 
	 * 
	 */
	public ClaimList() {
		claimList = new ArrayList<Claim>();
		listeners = new ArrayList<Listener>();
	}

	/**
	 * get the position of the selected claim in the claim list in the view.
	 * 
	 * @return claimList.get(position) the position of the selected claim in the
	 *         claim list in the view.
	 */
	public Claim getPosition(int position) {
		return claimList.get(position);
	}

	private ArrayList<Listener> getListeners() {
		if (listeners == null) {
			listeners = new ArrayList<Listener>();
		}
		return listeners;
	}

	public void addListener(Listener l) {
		getListeners().add(l);
	}

	public void removeListener(Listener l) {
		getListeners().remove(l);
	}

	private void notifyListeners() {
		for (Listener listener : getListeners()) {
			listener.update();
		}
	}

	/**
	 * add an new claim to claimList and notify the listener in order to update
	 * the view
	 * 
	 * @param claim
	 *            the added claim.
	 */
	public void addClaim(Claim claim) {
		claimList.add(claim);
		notifyListeners();
	}

	/**
	 * remove a claim in the claimList and notify the listener in order to
	 * update the view
	 * 
	 * @param claim
	 *            the removed claim .
	 */
	public void deleteClaim(Claim claim) {
		claimList.remove(claim);
		notifyListeners();
	}

	/**
	 * get a claim list in List date type
	 * 
	 * @return claimList the claimList in the List type .
	 */
	public List<Claim> getClaimList() {
		return claimList;
	}

	/**
	 * get a claim list in ArrayList date type
	 * 
	 * @return claimList the claimList in the ArrayList type .
	 */
	public ArrayList<Claim> getClaimArrayList() {
		return claimList;
	}

}