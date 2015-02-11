package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;
import java.util.List;

public class ClaimList {

	protected ArrayList<Claim> claimList = null;
	protected transient ArrayList<Listener> listeners = null;

	public ClaimList() {
		claimList = new ArrayList<Claim>();
		listeners = new ArrayList<Listener>();
	}

	public void sortClaimList() {

	}

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

	public void addClaim(Claim claim) {
		claimList.add(claim);
		notifyListeners();
	}

	public void deleteClaim(Claim claim) {
		claimList.remove(claim);
		notifyListeners();
	}

	public List<Claim> getClaim() {
		return claimList;
	}

	public ArrayList<Claim> getClaimList() {
		return claimList;
	}

}
