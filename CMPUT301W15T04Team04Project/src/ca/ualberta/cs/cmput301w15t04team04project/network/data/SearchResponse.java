//from https://github.com/rayzhangcl/ESDemo March 27 2015
package ca.ualberta.cs.cmput301w15t04team04project.network.data;
/**
 * The class is for elastic search
 * Internet environment .
 */
public class SearchResponse<T> {

	private Hits<T> hits;
	
	public SearchResponse() {}
	/**
	 * get Hits from the SearchResponse
	 * @return
	 */
	public Hits<T> getHits() {
		return hits;
	}
}