package ca.ualberta.cs.cmput301w15t04team04project.network.data;

public class SearchResponse<T> {
	String _index;
	String _type;
	String _id;
	int _version;
	boolean exists;
	T _source;
	public T getSource() {
		return _source;
	}
}
