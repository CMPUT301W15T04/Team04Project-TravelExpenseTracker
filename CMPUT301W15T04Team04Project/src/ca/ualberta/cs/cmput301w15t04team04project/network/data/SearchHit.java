//from https://github.com/rayzhangcl/ESDemo March 27 2015
package ca.ualberta.cs.cmput301w15t04team04project.network.data;

public class SearchHit<T> {
	private T _source;

	public SearchHit() {
	}

	public T getSource() {
		return _source;
	}

	public void setSource(T source) {
		this._source = source;
	}

}
