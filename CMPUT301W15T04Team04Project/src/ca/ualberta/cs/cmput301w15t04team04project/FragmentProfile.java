package ca.ualberta.cs.cmput301w15t04team04project;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentProfile extends Fragment {
	private TextView tv;  
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_profile, container, false);
	}
    @Override  
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		tv = (TextView) getView().findViewById(R.id.titleTv); 
        tv.setText("Profile"); 
	}
}
