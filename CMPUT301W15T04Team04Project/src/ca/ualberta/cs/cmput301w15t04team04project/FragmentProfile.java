package ca.ualberta.cs.cmput301w15t04team04project;

import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class FragmentProfile extends Fragment {
	private TextView tv;
	private TextView userName;
	private RadioGroup settingOption;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_profile, container, false);
	}
    @Override  
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
        userName = (TextView) getView().findViewById(R.id.userNameDisplay);
        userName.setText(User.name);
        settingOption = (RadioGroup)getView().findViewById(R.id.settingGroup);
        settingOption.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.MyClaims:
					Intent intent1 = new Intent(getActivity(),
							MyClaimActivity.class);
					startActivity(intent1);
					break;

				case R.id.waitingList:
					Intent intent2 = new Intent(getActivity(),
							MyClaimActivity.class);
					startActivity(intent2);
					break;

				case R.id.logOut:
					User.loginStatus = false;
					User.name = null;
					Intent intent3 = new Intent(getActivity(),
							SignInActivity.class);
					startActivity(intent3);
					break;

				default:
					break;
				}

			}
		});
	}
}
