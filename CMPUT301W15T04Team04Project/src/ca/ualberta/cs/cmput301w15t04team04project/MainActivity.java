package ca.ualberta.cs.cmput301w15t04team04project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setTitle("Claims");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		//return true;
		
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	
	public void goToSearch(MenuItem item) {
		Intent intent = new Intent(MainActivity.this, SearchActivity.class);
		startActivity(intent);
	}
	
	public void goToEditClaim(MenuItem item) {
		Intent intent = new Intent(MainActivity.this, EditClaimActivity.class);
		startActivity(intent);
	}
	
	public void goToOneClaim(View view) {
		Intent intent = new Intent(MainActivity.this, OneClaimActivity.class);
		startActivity(intent);
	}
}
