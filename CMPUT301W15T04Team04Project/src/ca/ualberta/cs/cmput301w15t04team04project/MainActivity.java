package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.List;
import java.util.Vector;

import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.PagerAdapter;
import android.app.ActionBar;
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
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {
	private RadioGroup bottom_Rg;
	private PagerAdapter mpageAdapter;
	private ViewPager pager;
	private int num;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		initialisePaging();
	}

	private void initialisePaging() {
		// TODO Auto-generated method stub
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, FragmentMain.class.getName()));
		fragments.add(Fragment.instantiate(this,
				EditClaimActivity.class.getName()));
		fragments.add(Fragment.instantiate(this,
				FragmentProfile.class.getName()));
		mpageAdapter = new PagerAdapter(this.getSupportFragmentManager(),
				fragments);

		pager = (ViewPager) findViewById(R.id.viewpager);
		pager.setAdapter(mpageAdapter);
		setFragmentIndicator();
		num = pager.getCurrentItem();
	}

	private void setFragmentIndicator() {

		bottom_Rg = (RadioGroup) findViewById(R.id.bottomManu);
		bottom_Rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.main_menu_button:
					pager.setCurrentItem(0);
					num = pager.getCurrentItem();
					break;

				case R.id.add_menu_button:
					pager.setCurrentItem(1);
					num = pager.getCurrentItem();
					break;

				case R.id.profile_menu_button:
					pager.setCurrentItem(2);
					num = pager.getCurrentItem();
					break;

				default:
					break;
				}

			}
		});
	}

	/*
	 * @Override public boolean onPrepareOptionsMenu(Menu menu) {
	 * 
	 * if (pager.getCurrentItem() == 0) {
	 * menu.findItem(R.id.action_search).setVisible(false); } return
	 * super.onPrepareOptionsMenu(menu); }
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (num == 0){
			getMenuInflater().inflate(R.menu.main, menu);
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.main, menu);
		}
		return true;
	}

	public void goToSearch(MenuItem item) {
		Intent intent = new Intent(MainActivity.this, SearchActivity.class);
		startActivity(intent);
	}

	public void goToEditClaim(MenuItem item) {
		Intent intent = new Intent(MainActivity.this, EditClaimActivity.class);
		startActivity(intent);
	}

}
