package ca.ualberta.cs.cmput301w15t04team04project;

import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class SignInActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signin);
		getActionBar().setTitle("Sign In");
		
		Button signInButton  = (Button) findViewById(R.id.signInButton);
		signInButton.setBackgroundResource(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.signin, menu);
		return true;
	}

	
	public void signIn(View view) {
		Intent intent = new Intent(SignInActivity.this, MainActivity.class);
		startActivity(intent);
	}
}
