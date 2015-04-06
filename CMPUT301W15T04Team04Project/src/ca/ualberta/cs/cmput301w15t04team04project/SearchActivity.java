package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;

import ca.ualberta.cs.cmput301w15t04team04project.controller.searchController;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * <b>This class is to help users to search their claims by tags</b> 
 * 
 * @author Yufei Zhang
 * @version 1.0
 * @since 2015-03-12
 */
public class SearchActivity extends Activity {

	// An array of strings to populate drop down list */

	/**
	 * The following String[] is using for store the contact Tags.
	 */
/*	String[] contectTags = new String[] { "Tag", "Friend", "Classmate", "A1",
			"A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11",
			"A12", "A13", "A14", "A15", "A16", "A17", "A18", "A19", "A20",
			"A21" };*/
	private User user;
	private ArrayList<String> contectTags = new ArrayList<String> ();
	private searchController controller = new searchController();
	
	/**
	 * Called to do initial creation of a fragment.<br>
	 * This is called after onAttach(Activity) and before onCreateView(LayoutInflater, ViewGroup, Bundle).<br>
	 * Note that this can be called while the fragment's activity is still in the process of being created.<br>
	 * As such, you can not rely on things like the activity's content view hierarchy being initialized at this point.<br>
	 * If you want to do work once the activity itself is created, see onActivityCreated(Bundle).<br>
	 * 
	 * @param savedInstanceState	If the fragment is being re-created from a previous saved state, this is the state.
	 * 
	 * @author Yufei Zhang
	 * @author Weijie Sun
	 * @version 2.0
	 * @since 2015-04-05
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setIcon(R.drawable.ic_action_search);
		Spinner spinner = (Spinner) findViewById(R.id.constactTagsSpinner);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getBaseContext(),
				android.R.layout.simple_spinner_dropdown_item, contectTags);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
	}
	
	/**
	 * This boolean function is to search the Activity change the mode of the my Claim Activity to 4
	 * In order to find the Claims which meet the requirement
	 * 
	 * @author Yufei Zhang
	 * @author Weijie Sun
	 * @version 2.0
	 * @since 2015-04-05
	 */
	public void search(){
		MyClaimActivity.mode = 4;
		
		Intent intent = new Intent(SearchActivity.this,
				MyClaimActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("tag", "");
		startActivity(intent);
		finish();
	}
	/**
	 * This hook is called whenever an item in your options menu is selected.<br>
	 * The default implementation simply returns false to have the normal processing happen (calling the item's Runnable or sending a message to its Handler as appropriate).<br>
	 * You can use this method for any items for which you would like to do processing without those other facilities.<br>
	 * Derived classes should call through to the base class for it to perform the default menu handling.
	 * 
	 * @param item	The menu item that was selected.
	 * @return boolean Return false to allow normal menu processing to proceed, true to consume it here.
	 * @see onCreateOptionsMenu(Menu)
	 * 
	 * @author Yufei Zhang
	 * @version 1.0
	 * @since 2015-03-12
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);

		return super.onCreateOptionsMenu(menu);
		// return true;
	}

	protected void cancle(View view) {
		finish();
	}

}
