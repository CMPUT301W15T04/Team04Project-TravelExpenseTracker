package ca.ualberta.cs.cmput301w15t04team04project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class OneClaimActivity extends Activity {
	protected static boolean isClaimant = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_claim);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.one_claim, menu);
		return true;
	}

	public void goToSearch(MenuItem item) {
		Intent intent = new Intent(OneClaimActivity.this, SearchActivity.class);
		startActivity(intent);
	}
	
	public void goToEditItem(MenuItem item) {
		Intent intent = new Intent(OneClaimActivity.this, EditItemActivity.class);
		startActivity(intent);
	}
	
	public void showClaimDetailC(View view) {
		isClaimant = true;
		
		AlertDialog.Builder adb = new AlertDialog.Builder(OneClaimActivity.this);
		
		LayoutInflater factory = LayoutInflater.from(OneClaimActivity.this);
		View claimInfoCDialogView = factory.inflate(R.layout.activity_claim_detail, null);
		adb.setView(claimInfoCDialogView);
		
		adb.setMessage("          Claim Details");  // set title
		adb.setCancelable(true);
		adb.show();
	}
	
	public void showClaimDetailA(View view) {
		isClaimant = false;
		AlertDialog.Builder adb = new AlertDialog.Builder(OneClaimActivity.this);
		
		LayoutInflater factory = LayoutInflater.from(OneClaimActivity.this);
		View claimInfoCDialogView = factory.inflate(R.layout.activity_claim_detail_a, null);
		adb.setView(claimInfoCDialogView);
		
		adb.setMessage("          Claim Details");  // set title
		adb.setCancelable(true);
		adb.show();
	}
	
	public void showItemDetailC(View view) {
		isClaimant = true;
		AlertDialog.Builder adb = new AlertDialog.Builder(OneClaimActivity.this);
		
		LayoutInflater factory = LayoutInflater.from(OneClaimActivity.this);
		View claimInfoCDialogView = factory.inflate(R.layout.activity_item_detail, null);
		adb.setView(claimInfoCDialogView);
		
		adb.setMessage("          Item Details");  // set title
		adb.setCancelable(true);
		adb.show();
	}
	
	public void showItemDetailA(View view) {
		isClaimant = false;
		AlertDialog.Builder adb = new AlertDialog.Builder(OneClaimActivity.this);
		
		LayoutInflater factory = LayoutInflater.from(OneClaimActivity.this);
		View claimInfoCDialogView = factory.inflate(R.layout.activity_item_detail_a, null);
		adb.setView(claimInfoCDialogView);
		
		adb.setMessage("          Item Details");  // set title
		adb.setCancelable(true);
		adb.show();
	}
}
