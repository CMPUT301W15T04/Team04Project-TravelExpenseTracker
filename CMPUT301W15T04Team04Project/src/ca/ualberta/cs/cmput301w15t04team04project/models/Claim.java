package ca.ualberta.cs.cmput301w15t04team04project.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
/**
* The Claim model is just a rough Claim's information
* simply store set and get all of the Claim
* 
* @param String claimName is to store the name of the claim
* @author  Ji Yang
* @version 1.0
* @since   2015-03-08 
*/
public class Claim {


	protected String claimName;
	protected Date startDate;
	protected Date endDate;
	protected String statu;
	protected String description;
	protected ArrayList<Item> items;
	protected ArrayList<String> amount;
	protected transient ArrayList<Listener> itemListener;

	public Claim(String claimName) {

		this.claimName = claimName;
		items = new ArrayList<Item>();
		itemListener = new ArrayList<Listener>();
	}
	
	private ArrayList<Listener> getListeners() {
		if (itemListener == null) {
			itemListener = new ArrayList<Listener>();
		}
		return itemListener;
	}

	public Collection<Item> getItem() {
		return items;
	}

	public void addItem(Item aItem) {
		items.add(aItem);
		notifyListener();
	}

	private void notifyListener() {
		for (Listener listener : itemListener) {
			listener.update();
		}
	}

	public void removeItem(Item oldItem) {
		items.remove(oldItem);
		notifyListener();
	}

	public void addListener(Listener l) {
		getListeners().add(l);
	}

	public Item getPosition(int position) {
		return items.get(position);
	}

	public void removeListener(Listener l) {
		getListeners().remove(l);
	}

	public String getClaim() {
		return claimName;
	}

	public String toString() {
		return getClaim();
	}

	public void setClaim(String claimName) {
		this.claimName = claimName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public ArrayList<String> getAmount() {
		return amount;
	}

	public void setAmount(ArrayList<String> amount) {
		this.amount = amount;
	}

	

}