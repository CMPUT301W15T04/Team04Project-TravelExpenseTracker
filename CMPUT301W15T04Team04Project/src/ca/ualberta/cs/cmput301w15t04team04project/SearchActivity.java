package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;

import ca.ualberta.cs.cmput301w15t04team04project.controller.searchController;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

/**
 * The mission of SearchActivity are: 1. The users can be both claimants and
 * approvers. 2. Users can search a claim by tag. 3. Users can search a claim by
 * some keywords.
 * 
 * @author Yufei Zhang
 * @version 1.0
 * @since 2015-03-12
 */
public class SearchActivity extends Activity {

	// An array of strings to populate drop down list */

	/**
	 * The following String[] is using for store the contact Tags.
	 * **/
/*	String[] contectTags = new String[] { "Tag", "Friend", "Classmate", "A1",
			"A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11",
			"A12", "A13", "A14", "A15", "A16", "A17", "A18", "A19", "A20",
			"A21" };*/
	private User user;
	private ArrayList<String> contectTags = new ArrayList<String> ();
	private searchController controller = new searchController();
	
	/**
	 * This boolean function is to create searchActivity and the view
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
	 * This boolean function is to activate the option menu.
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

	public void cancle(View view) {
		finish();
	}

}
