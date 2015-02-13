package ca.ualberta.cs.cmput301w15t04team04project;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AddEditClaimActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_edit_claim);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_edit_claim, menu);
		return true;
	}

}
