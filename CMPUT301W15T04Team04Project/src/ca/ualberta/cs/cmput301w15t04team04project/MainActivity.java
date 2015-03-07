package ca.ualberta.cs.cmput301w15t04team04project;

import ca.ualberta.cs.cmput301w15t04team04project.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {

	private Fragment[] fragments;
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	private RadioGroup bottom_Rg;
	private RadioButton main_Rb, add_Rb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		bottom_Rg = (RadioGroup) findViewById(R.id.bottomManu);
		main_Rb = (RadioButton) findViewById(R.id.main_menu_button);
		add_Rb = (RadioButton) findViewById(R.id.add_menu_button);
		fragments = new Fragment[2];
		fragmentManager = getSupportFragmentManager();
		fragments[0] = fragmentManager.findFragmentById(R.id.fragmentMain);
		fragments[1] = fragmentManager.findFragmentById(R.id.fragmentProfile);
		fragmentTransaction = fragmentManager.beginTransaction().hide(
				fragments[0]).hide(fragments[1]);
		fragmentTransaction.show(fragments[0]).commit();
		setFragmentIndicator();

	}

	private void setFragmentIndicator() {

		bottom_Rg = (RadioGroup) findViewById(R.id.bottomManu);
		bottom_Rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				fragmentTransaction = fragmentManager.beginTransaction()
						.hide(fragments[0]).hide(fragments[1]);
				switch (checkedId) {
				case R.id.main_menu_button:
					fragmentTransaction.show(fragments[0]).commit();
					break;

				case R.id.add_menu_button:
					main_Rb.performClick();
					add_Rb.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							Intent intent = new Intent(MainActivity.this,
									EditClaimActivity.class);
							startActivity(intent);
						}
					});
					break;

				case R.id.profile_menu_button:
					fragmentTransaction.show(fragments[1]).commit();
					break;

				default:
					break;
				}

			}
		});
	}
	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * //getMenuInflater().inflate(R.menu.main, menu); //return true;
	 * 
	 * MenuInflater inflater = getMenuInflater(); inflater.inflate(R.menu.main,
	 * menu); return super.onCreateOptionsMenu(menu); }
	 * 
	 * 
	 * public void goToSearch(MenuItem item) { Intent intent = new
	 * Intent(MainActivity.this, SearchActivity.class); startActivity(intent); }
	 * 
	 * public void goToEditClaim(MenuItem item) { Intent intent = new
	 * Intent(MainActivity.this, EditClaimActivity.class);
	 * startActivity(intent); }
	 * 
	 * public void goToOneClaim(View view) { Intent intent = new
	 * Intent(MainActivity.this, OneClaimActivity.class); startActivity(intent);
	 * }
	 */
}
