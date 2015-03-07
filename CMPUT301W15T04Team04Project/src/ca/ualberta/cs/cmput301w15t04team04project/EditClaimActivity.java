package ca.ualberta.cs.cmput301w15t04team04project;

import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.R;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class EditClaimActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_claim);
	}
	
	public void jump(View v) {
		Toast.makeText(this, "ass", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(EditClaimActivity.this, MainActivity.class);
		startActivity(intent);
	}
	
	/*
	@Override
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_claim, menu);
		return true;
	}

	public void confirm(MenuItem item) {
		finish();
	}*/
}
