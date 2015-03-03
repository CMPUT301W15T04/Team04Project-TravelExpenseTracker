package ca.ualberta.cs.cmput301w15t04team04project;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class SearchActivity extends Activity {
	
	// An array of strings to populate drop down list */
	String[] contextTags = new String[] {
		"Tag",
		"Friend",
		"Classmate"
		,"A1","A2","A3","A4","A5","A6","A7"
		,"A8","A9","A10","A11","A12","A13","A14"
		,"A15","A16","A17","A18","A19","A20","A21"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
        // Create an array adapter to populate drop down list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, contextTags);
        
        
        // Enabling drop down list navigation for the action bar
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        
        // Defining Navigation listener
        ActionBar.OnNavigationListener navigationListener = new OnNavigationListener() {
			
			@Override
			public boolean onNavigationItemSelected(int itemPosition, long itemId) {
				Toast.makeText(getBaseContext(), "You selected : " + contextTags[itemPosition]  , Toast.LENGTH_SHORT).show();
				return false;
			}
		};
	
		// Setting drop down items and item navigation listener for the action bar
		getActionBar().setListNavigationCallbacks(adapter, navigationListener);  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
