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
import java.util.Collection;
import java.util.Date;

import android.location.Location;

/**
 * The Claim model is just a rough Claim's information simply store set and get
 * all of the Claim
 * 
 * @param String
 *            claimName is to store the name of the claim
 * @author Ji Yang
 * @author Yang Zhang
 * @author Weijie Sun
 * @version 1.2
 * @since 2015-03-12
 */
public class Claim {

	protected String claimName;
	protected String status;
	protected String description;
	protected ArrayList<String> Comments;
	protected Date startDate;
	protected Date endDate;
	protected ArrayList<Destination> destination = new ArrayList<Destination>();
	protected ArrayList<Item> items;
	protected ArrayList<String> tags;
	protected transient ArrayList<Listener> itemListener;
	protected String Approver;
	protected String Claimiant;
	protected ArrayList<Currency> totalCurrency ;
	protected String claimLocation;
	protected Location clLocation;
	
	protected transient ArrayList<Listener> listeners = null;

	public String getClaimLocation() {
		return claimLocation;
	}



	public Location getClLocation() {
		return clLocation;
	}



	public void setClLocation(Location clLocation) {
		this.claimLocation = clLocation.getLatitude()+""+clLocation.getLongitude();
		this.clLocation = clLocation;
	}



	/**
	 * The constructor of the class
	 * 
	 * @param claimName
	 *            The name of the claim.
	 */
	public Claim(String claimName) {

		this.claimName = claimName;
		items = new ArrayList<Item>();
		itemListener = new ArrayList<Listener>();
		destination = new ArrayList<Destination>();
		tags = new ArrayList<String>();
		status = "In Progress";
		startDate = new Date(System.currentTimeMillis()); // only for test.
															// 2015-03-14
		Comments = new ArrayList<String>();													// Chenrui

	}
	
	public void setDestination(ArrayList<Destination> destination) {
		this.destination = destination;
	}
	/*
	/**
	 * Returns the string representation of the destination list. The
	 * presentation has a specific format. Elements are separated by '\n' (new
	 * line).
	 * 
	 * @return the string representation of this.destination.
	 * 
	 * @author Chenrui Lei
	 * @since 2015-03-14
	 */
	public String DestinationListToString() {
		String out = "";
/*		if (destination.size() != 0) {
			out += destination.get(0).toString();

			for (int i = 1; i < destination.size(); i++) {
				out += "\n" + destination.get(i).toString();
			}
		} else {
			out = "N/A";
		}*/
		return out;
	}

	/**
	 * Returns the string representation of the totalCurrency list. The
	 * presentation has a specific format. Elements are separated by '\n' (new
	 * line).
	 * 
	 * @return the string representation of this.totalCurrency.
	 * 
	 * @author Chenrui Lei
	 * @since 2015-03-14
	 */
	public String TagListToString() {
		String out = "";
		if (tags.size() != 0) {
			out += tags.get(0).toString();

			for (int i = 1; i < tags.size(); i++) {
				out += "\n" + tags.get(i).toString();
			}
		} else {
			out = "N/A";
		}
		return out;
	}

	/**
<<<<<<< HEAD
=======
	 * Returns the string representation of the totalCurrency list. The
	 * presentation has a specific format. Elements are separated by '\n' (new
	 * line).
	 * 
	 * @return the string representation of this.totalCurrency.
	 * 
	 * @author Chenrui Lei
	 * @since 2015-03-14
	 */
	public String TotalCurrencyListToString() {
		String out = "";
/*		if (totalCurrency.size() != 0) {
			out += totalCurrency.get(0).toString();

			for (int i = 1; i < totalCurrency.size(); i++) {
				out += "\n" + totalCurrency.get(i).toString();
			}
		} else {
			out = "N/A";
		}*/
		return out;
	}

	public ArrayList<Currency> getTotalCurrency() {
		return this.totalCurrency;
	}

	public void setTotalCurrency(ArrayList<Currency> totalCurrency) {
		this.totalCurrency = totalCurrency;
	}

	/**
>>>>>>> ce8114d26388fc9dec9fc17c358159d50dde398a
	 * add new destination of this claim
	 * 
	 * @param newdestination
	 *            the newdestination of this claim
	 */
	public void addDestionation(Destination newdestination) {
		destination.add(newdestination);

	}

	/**
	 * removeDestination of this claim
	 * 
	 * @param olddestination
	 *            the old destination need to be removed of this claim
	 */
	public void removeDestination(Destination olddestination) {
		destination.remove(olddestination);

	}

	/**
	 * get the Comment of this claim
	 * 
	 * @param Comment
	 *            the Comment of this claim
	 */
	public ArrayList<String> getComment() {
		return Comments;
	}

	/**
	 * get the Comment of this claim
	 * 
	 * @param Comment
	 *            the Comment of this claim
	 */
	public void setComment(ArrayList<String> comments) {
		this.Comments = comments;
	}

	/**
	 * get the ClaimiantName of this claim
	 * 
	 * @param ClaimiantName
	 *            the ClaimiantName of this claim
	 */
	public String getClaimiant() {
		return Claimiant;
	}

	/**
	 * set the ClaimiantName of this claim
	 * 
	 * @param ClaimiantName
	 *            the ClaimiantName of this claim
	 */
	public void setClaimiant(String claimiant) {
		this.Claimiant = claimiant;
	}

	/**
	 * get the ApproverName of this claim
	 * 
	 * @param ApproverName
	 *            the ApproverName of this claim
	 */
	public String getApprover() {
		return Approver;
	}

	/**
	 * set the ApproverName of this claim
	 * 
	 * @param ApproverName
	 *            the ApproverName of this claim
	 */
	public void setApproverName(String approver) {
		this.Approver = approver;
	}

	/**
	 * get an arraylist of listeners to do the notification things
	 * 
	 * @return itemListener
	 */
	private ArrayList<Listener> getListeners() {
		if (itemListener == null) {
			itemListener = new ArrayList<Listener>();
		}
		return itemListener;
	}

	/**
	 * get a collection of items which are contained in this claim by convert
	 * the arraylist of items to a collection.
	 * 
	 * @return items
	 */
	public Collection<Item> getItem() {
		return items;
	}

	/**
	 * add an new item to this claim and notify the listener in order to update
	 * the view
	 * 
	 * @param aItem
	 *            the added item .
	 */
	public void addItem(Item aItem) {
		items.add(0, aItem);
		notifyListener();
	}

	/**
	 * remove an item in this claim and notify the listener in order to update
	 * the view
	 * 
	 * @param oldItem
	 *            the removed item .
	 */
	public void removeItem(Item oldItem) {
		items.remove(oldItem);
		notifyListener();
	}

	// http://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fswt%2Fwidgets%2FWidget.html
	/**
	 * Notifies all of the receiver's listeners for events.
	 */
	public void notifyListener() {
		for (Listener listener : getListeners()) {
			listener.update();
		}
	}

	// http://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fswt%2Fwidgets%2FWidget.html
	/**
	 * 
	 * Adds the listener to the collection of listeners who will be notified
	 * when an event of the given type occurs.
	 * 
	 * @param l
	 *            the new listener
	 */

	public void addListener(Listener l) {
		getListeners().add(l);
	}

	// http://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Freference%2Fapi%2Forg%2Feclipse%2Fswt%2Fwidgets%2FWidget.html
	/**
	 * Removes the listener from the collection of listeners who will be
	 * notified when an event of the given type occurs.
	 * 
	 * @param l
	 *            the removed listener .
	 */
	public void removeListener(Listener l) {
		getListeners().remove(l);
	}

	/**
	 * get the position of the selected item in the item list of this claim.
	 * 
	 * @return items.get(position)
	 */
	public Item getPosition(int position) {
		return items.get(position);
	}

	/**
	 * get the claim name of this claim
	 * 
	 * @return claimName
	 */
	public String getClaim() {
		return claimName;
	}

	/**
	 * set the claim name of this claim
	 * 
	 * @param claimName
	 *            the claim name of this claim
	 */
	public void setClaim(String claimName) {
		this.claimName = claimName;
	}

	public String toString() {
		return getClaim();
	}

	/**
	 * get the StartDate of this claim
	 * 
	 * @return startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * set the StartDate of this claim
	 * 
	 * @param startDate
	 *            the startDate of this claim
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * get the EndDate of this claim
	 * 
	 * @return EndDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * set the EndDate of this claim
	 * 
	 * @param EndDate
	 *            the EndDate of this claim
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * get the status of this claim
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * set the status of this claim
	 * 
	 * @param status
	 *            the status of this claim
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * get the description of this claim
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * set the description of this claim
	 * 
	 * @param description
	 *            the description of this claim
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * get the item list of this claim
	 * 
	 * @return items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * set the item list of this claim
	 * 
	 * @param items
	 *            the item list of this claim
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	/**
	 * get the tag of this claim s
	 * 
	 * @return tags
	 */
	public ArrayList<String> getTag() {
		return tags;
	}

	/**
	 * set the tag of this claim
	 * 
	 * @param tag
	 *            a new tag of this claim
	 */
	public void setTag(ArrayList<String> tagList) {
		this.tags = tagList;
	}

	/**
	 * get the destinations of this claim
	 * 
	 * @return destination
	 */
	public ArrayList<Destination> getDestination() {
		return destination;
	}

	public String currencySummary(){
		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		for (int i = 0; i < getItems().size(); i++){
			for (int j = 0; j < currencyList.size(); j++){
				if (getItems().get(i).getItemCurrency().getType() == currencyList.get(j).getType()){
					int c = currencyList.get(j).getAmount();
					currencyList.get(j).setAmount(c + getItems().get(i).getItemCurrency().getAmount());
					break;
				}
			}
			currencyList.add(getItems().get(i).getItemCurrency());
		}
		String summary = "";
		for (int j = 0; j < currencyList.size(); j++){
			summary += currencyList.get(j).getType() + currencyList.get(j).getAmount()+"\n";
		}
		return summary;
	}

}