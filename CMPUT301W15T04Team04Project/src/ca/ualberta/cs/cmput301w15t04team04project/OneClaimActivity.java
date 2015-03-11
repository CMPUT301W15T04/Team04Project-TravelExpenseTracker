package ca.ualberta.cs.cmput301w15t04team04project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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
		
		adb.setNeutralButton("Submit", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Submit" ,Toast.LENGTH_SHORT).show();
				/**
				 * You need to add code here to do the submit stuff
				 * Once the claimant click this, the claim will be submitted
				**/
			}
		});
		
		adb.setNegativeButton("Confirm", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Confirm" ,Toast.LENGTH_SHORT).show();
				/**
				 * You need to add code here to do the confirm stuff
				 * Once the claimant click this, the claim is updated
				**/
			}
		});
		
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
		
		adb.setNegativeButton("Return", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Return" ,Toast.LENGTH_SHORT).show();
				/**
				 * You need to add code here to do the return stuff
				 * Once the approver click this, the claim will be returned
				**/
			}
		});
		
		adb.setNeutralButton("Approve", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Approve" ,Toast.LENGTH_SHORT).show();
				/**
				 * You need to add code here to do the approve stuff
				 * Once the approver click this, the claim will be approved
				**/
			}
		});
		
		adb.setPositiveButton("Comment", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Comment" ,Toast.LENGTH_SHORT).show();
				/**
				 * You need to add code here to do the comment stuff
				 * Once the approver click this, some comments will be add
				 * However, I think we don't need this button
				 * Because whether we click on Approve or Return, a comment is needed to be add 
				**/
			}
		});
		
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
		// set the Edit Button on the Dialog
		adb.setNeutralButton("Edit", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Edit" ,Toast.LENGTH_SHORT).show();
				/**
				 * You need to add code here to do the edit stuff
				 * Once the claimant click this, he or she can go to the EditItemActivity to edit the current item
				**/
			}
		});
		
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
		
		adb.setNeutralButton("Add Comment", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Add Comment" ,Toast.LENGTH_SHORT).show();
				/**
				 * You need to add code here to do the addComment stuff
				 * Once the approver click this, the comment will be add for the current claim
				**/
			}
		});
		
		
		adb.setCancelable(true);
		adb.show();
	}
}
