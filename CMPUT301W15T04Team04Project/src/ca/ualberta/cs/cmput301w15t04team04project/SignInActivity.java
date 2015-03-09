package ca.ualberta.cs.cmput301w15t04team04project;

import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends Activity {
	private EditText userName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signin);
		getActionBar().setTitle("Sign In");
		userName = (EditText) findViewById(R.id.userNameEditText);
	}
	
	public void signIn(View v){
		String user = userName.getText().toString();
		if(user.length() == 0){
			Toast.makeText(this, "You must enter something" ,Toast.LENGTH_SHORT).show();
		}else{
			User.name = user;
			User.loginStatus = true;
			Intent intent = new Intent(SignInActivity.this,
					MainActivity.class);
			startActivity(intent);
			finish();
		}
	}
	
}
