package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class OneClaimActivity extends Activity {
	protected static boolean isClaimant = true;
	private OneClaimController controller = new OneClaimController();
	private OneClaimActivity thisActivity = this;
	//private MyLocalClaimListManager manager = new MyLocalClaimListManager(this);
	private Claim claim;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_claim);
		
		Bundle extras =getIntent().getExtras();
		final int claimid = extras.getInt("MyClaimid");
		
		claim = MyLocalClaimListManager.loadClaimList(this, "local").getClaimArrayList().get(claimid);
		
		
		ListView itemlistview = (ListView) findViewById(R.id.OneCaimItemlistView);
		//
		ArrayList<Item> items = claim.getItems();
		final ArrayAdapter<Item> itemAdapter = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, items);
		
		itemlistview.setAdapter(itemAdapter);
		itemAdapter.notifyDataSetChanged();
		itemlistview.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
				final int finalPosition = position;
				//Claim claim = list.get(finalPosition);
				AlertDialog.Builder adb = new AlertDialog.Builder(OneClaimActivity.this);
				//adb.setMessage(claim.getClaim()+" total cost \n"+claim.getAmount()+"\n From "+claim.getStartDate()+" to "+claim.getEndDate());
				adb.setCancelable(true);

				adb.setPositiveButton("Delete", new OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						controller.deleteItem(which);
						//controller.deleteClaim(which);
						//manager.saveClaimList(controller.getcClaimList());
				}
				});
				adb.setNeutralButton("Edit", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(OneClaimActivity.this, "Item"+finalPosition ,Toast.LENGTH_SHORT).show();
						Intent myintent = new Intent(OneClaimActivity.this,
								OneClaimActivity.class);
						myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						myintent.putExtra("MyItemid", finalPosition);
						OneClaimActivity.this.startActivity(myintent);	
						
					}
				});
				
				adb.setNegativeButton("Cancel", new OnClickListener(){
					@Override
						public void onClick(DialogInterface dialog, int which) {
					}
				});
				adb.show();
				return true;
			}
    		
    		}
    	
   	);

		itemlistview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				int itemPosition = position;
				Toast.makeText(OneClaimActivity.this, "Item"+id ,Toast.LENGTH_SHORT).show();
				
				
				showItemDetailC(view,position);
								
			}
		});
		
		
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
		
		adb.setNeutralButton("Submit", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Submit" ,Toast.LENGTH_SHORT).show();
				controller.submittedClaim(which);
				/**
				 * You need to add code here to do the submit stuff
				 * Once the claimant click this, the claim will be submitted
				**/
			}
		});
		
		adb.setNegativeButton("Confirm", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Confirm" ,Toast.LENGTH_SHORT).show();
				controller.confirmClaim(which);
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
		
		adb.setNegativeButton("Return", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Return" ,Toast.LENGTH_SHORT).show();
				controller.returnClaim(which);
				/**
				 * You need to add code here to do the return stuff
				 * Once the approver click this, the claim will be returned
				**/
			}
		});
		
		adb.setNeutralButton("Approve", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Approve" ,Toast.LENGTH_SHORT).show();
				controller.approveClaim(which);
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
	
	public void showItemDetailC(View view, int id) {
		isClaimant = true;
		AlertDialog.Builder adb = new AlertDialog.Builder(OneClaimActivity.this);
		
		LayoutInflater factory = LayoutInflater.from(OneClaimActivity.this);
		View claimInfoCDialogView = factory.inflate(R.layout.activity_item_detail, null);
		adb.setView(claimInfoCDialogView);
		
		// set the Edit Button on the Dialog
		adb.setNeutralButton("Edit", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Edit" ,Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(OneClaimActivity.this, EditItemActivity.class);
				startActivity(intent);
			}
		});
		
		adb.setCancelable(true);
		adb.show();
	}
	
	public void showItemDetailA(View view, int id) {
		isClaimant = false;
		AlertDialog.Builder adb = new AlertDialog.Builder(OneClaimActivity.this);
		
		LayoutInflater factory = LayoutInflater.from(OneClaimActivity.this);
		View claimInfoCDialogView = factory.inflate(R.layout.activity_item_detail_a, null);
		adb.setView(claimInfoCDialogView);
		
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
