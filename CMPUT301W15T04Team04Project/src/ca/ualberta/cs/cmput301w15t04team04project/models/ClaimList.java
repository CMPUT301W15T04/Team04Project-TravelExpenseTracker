/*
* Copyright 2015 Weijie Sun
* Copyright 2015 Youdong Ma
* Copyright 2015 Yufei Zhang
* Copyright 2015 Chenrui Lei
* Copyright 2015 Yang Zhang
* Copyright 2015 Ji Yang
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

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
	//http://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fswt%2Fwidgets%2FWidget.html
		/**
		 * 
		 *Adds the listener to the collection of listeners who will be notified when an event of the given type occurs.
		 *@param l
		 *       the new listener
		  */
	public void addListener(Listener l) {
		getListeners().add(l);
	}
	//http://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fswt%2Fwidgets%2FWidget.html
		/**
		 * Removes the listener from the collection of listeners who will be notified when an event of the given type occurs.
		 * 
		 * @param l the removed listener .
		 */
	public void removeListener(Listener l) {
		getListeners().remove(l);
	}
	//http://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fswt%2Fwidgets%2FWidget.html
		/**
		 * Notifies all of the receiver's listeners for events. 
		 */
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