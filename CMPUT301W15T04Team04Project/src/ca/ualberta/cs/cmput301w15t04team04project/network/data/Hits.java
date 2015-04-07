//from https://github.com/rayzhangcl/ESDemo March 27 2015
package ca.ualberta.cs.cmput301w15t04team04project.network.data;

import java.util.List;

public class Hits<T> {
	private List<SearchHit<T>> hits;

	public List<SearchHit<T>> getHits() {
		return hits;
	}

	public void setHits(List<SearchHit<T>> hits) {
		this.hits = hits;
	}

}