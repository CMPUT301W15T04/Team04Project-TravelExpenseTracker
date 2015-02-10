package com.example.draft;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setTitle("Log In");
		Button buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
		Button buttonLogIn  = (Button) findViewById(R.id.buttonLogIn);
		buttonSignUp.setBackgroundResource(0);
		buttonLogIn.setBackgroundResource(0);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
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
	
	public void createAccount(View v) {
		//Toast.makeText(this, "Add a New Claim", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this, Login.class);
		startActivity(intent);
	}
}
