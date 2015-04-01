package ca.ualberta.cs.cmput301w15t04team04project;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ItemListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.OneClaimController2;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.Listener;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import ca.ualberta.cs.cmput301w15t04team04project.network.InternetChecker;
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

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
/**
 * The one Activity is to see the detail and the items of a certain claim
 * @author youdong
 * @author Weijie Sun
 * @version 1.0
 * @since 2015-03-11
 * @author Chenrui Lei
 * @author Yufei Zhang
 * @version 1.1
 * @since 2015-03-15
 */
public class OneClaimActivity extends Activity {
	private TextView itemName;
	private TextView amount;
	private TextView itemDate;
	private TextView category;
	private TextView descript;
	private OneClaimController2 controller;
	private TextView approverView;
	private TextView claimName;
	private TextView claimantView;
	static boolean isClaimant;
	private OneClaimActivity thisActivity = this;
	private InternetChecker iC;
	private Claim claim;
	private ClaimList claimList;
	private String ClaimName;
	private int itemId;
	private CLmanager onlineManager = new CLmanager();
	private ItemListAdapter itemAdapter;
	private User user;
	private Menu itemMenu;
	/**
	 * This method will be called when the user finishes asking a question to
	 * stop the the current thread.
	 */
	private Runnable doFinishAddItem = new Runnable() {
		public void run() {
			itemAdapter.notifyDataSetChanged();
		}
	};
	
	private Runnable doFinishUpdate = new Runnable() {
		public void run() {
			finish();
		}
	};
	
	private Runnable doFinishLoad = new Runnable() {
		public void run() {
			
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		user = SignInManager.loadFromFile(this);
		if(user.getName().equals("approval")){
			isClaimant = false;
		}else{
			isClaimant = true;
		}
		setContentView(R.layout.activity_one_claim);
		approverView = (TextView) findViewById(R.id.testApproverTextView);
		Bundle extras = getIntent().getExtras();
		onlineManager = new CLmanager();
		controller = new OneClaimController2();
		ClaimName = extras.getString("MyClaimName");
		Toast.makeText(this, ClaimName,	Toast.LENGTH_SHORT).show();
		getClaimThread getClaim = new getClaimThread(ClaimName);
		// set content of view to dispaly
		getClaim.start();
		ListView itemlistview = (ListView) findViewById(R.id.OneCaimItemListView);
		itemAdapter = new ItemListAdapter(this,
				android.R.layout.simple_list_item_1, controller.getItem());
		itemlistview.setAdapter(itemAdapter);
		checkUserType();
		controller.getClaim().addListener(new Listener() {
			@Override
			public void update() {
				// TODO Auto-generated method stub
				controller.clear();
				Collection<Item> items = controller.getItem();
				items.addAll(items);
				itemAdapter.notifyDataSetChanged();
			}
		});

		itemlistview.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView,
					View view, int position, long id) {
				// final int finalPosition = position;
				itemId = position;
				// Claim claim = list.get(finalPosition);
				AlertDialog.Builder adb = new AlertDialog.Builder(
						OneClaimActivity.this);
				// adb.setMessage(claim.getClaim()+" total cost \n"+claim.getAmount()+"\n From "+claim.getStartDate()+" to "+claim.getEndDate());
				adb.setCancelable(true);

				adb.setPositiveButton("Delete", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int position) {
						controller.deleteItem(itemId);
						MyLocalClaimListManager.saveClaimList(
								getApplicationContext(),
								claimList);
					}
				});

				adb.setNeutralButton("Edit", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stsub
						Toast.makeText(OneClaimActivity.this,
								"OCA ItemID = " + itemId, Toast.LENGTH_SHORT)
								.show();
						Intent myIntent = new Intent(OneClaimActivity.this,
								EditItemActivity.class);
						myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						myIntent.putExtra("myItemId", itemId);
						//myIntent.putExtra("myClaimId", claimId);
						OneClaimActivity.this.startActivity(myIntent);

					}
				});

				adb.setNegativeButton("Cancel", new OnClickListener() {
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
				Toast.makeText(OneClaimActivity.this, "Item " + id,
						Toast.LENGTH_SHORT).show();
				showItemDetailC(view, position);
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.one_claim, menu);
		itemMenu=menu;
		return true;
	}

	/**
	 * @param item
	 */
	public void goToSearch(MenuItem item) {
		Intent intent = new Intent(OneClaimActivity.this, SearchActivity.class);
		startActivity(intent);
	}

	/**
	 * @param item
	 */
	public void goToEditItem(MenuItem item) {
		Intent intent = new Intent(OneClaimActivity.this,
				EditItemActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("MyClaimName", ClaimName);
		startActivity(intent);
	}
	
	//get the menuItem for testing
	public MenuItem getItemMenuItem(){
		
		return itemMenu.findItem(R.id.action_new_item);
	}

	/**
	 * @param view
	 */
	public void showClaimDetailC(View view) {
		AlertDialog.Builder adb = new AlertDialog.Builder(OneClaimActivity.this);

		LayoutInflater factory = LayoutInflater.from(OneClaimActivity.this);
		View claimInfoCDialogView = factory.inflate(
				R.layout.activity_claim_detail, null);
		adb.setView(claimInfoCDialogView);


		claimName = (TextView) claimInfoCDialogView
				.findViewById(R.id.currentClaimNameCTextView);
		//claimName.setText(claims.get(claimId).getClaim());
		
		
		adb.setNeutralButton("Submit", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Submit",
							Toast.LENGTH_SHORT).show();
				iC = new InternetChecker(thisActivity);
				if (iC.isNetworkAvailable()){
					controller.submittedClaim();
					Thread UpdateClaimThread = new UpdateThread(controller.getClaim());
					UpdateClaimThread.start();
				}
				Intent intent = new Intent(OneClaimActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
				/**
				 * You need to add code here to do the submit stuff Once the
				 * claimant click this, the claim will be submitted
				 **/
			}
		});

		adb.setNegativeButton("Cancel", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Confirm",
						Toast.LENGTH_SHORT).show();
				controller.confirmClaim();
				/**
				 * You need to add code here to do the confirm stuff Once the
				 * claimant click this, the claim is updated
				 **/
			}
		});

		adb.setCancelable(true);
		adb.show();
	}

	/**
	 * @param view
	 */
	public void showClaimDetailA(View view) {
		AlertDialog.Builder adb = new AlertDialog.Builder(OneClaimActivity.this);

		LayoutInflater factory = LayoutInflater.from(OneClaimActivity.this);
		View claimInfoCDialogView = factory.inflate(
				R.layout.activity_claim_detail_a, null);
		adb.setView(claimInfoCDialogView);

		adb.setNegativeButton("Return", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Return",
						Toast.LENGTH_SHORT).show();
				iC = new InternetChecker(thisActivity);
				if (iC.isNetworkAvailable()){
					controller.returnClaim();
					Thread UpdateClaimThread = new UpdateThread(controller.getClaim());
					UpdateClaimThread.start();
				}
				Intent intent = new Intent(OneClaimActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
			}
		});

		adb.setNeutralButton("Approve", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Approve",
						Toast.LENGTH_SHORT).show();
				iC = new InternetChecker(thisActivity);
				if (iC.isNetworkAvailable()){
					controller.approveClaim();
					Thread UpdateClaimThread = new UpdateThread(controller.getClaim());
					UpdateClaimThread.start();
				}
				Intent intent = new Intent(OneClaimActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
			}
		});

		adb.setPositiveButton("Comment", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Comment",
						Toast.LENGTH_SHORT).show();
				/**
				 * You need to add code here to do the comment stuff Once the
				 * approver click this, some comments will be add However, I
				 * think we don't need this button Because whether we click on
				 * Approve or Return, a comment is needed to be add
				 **/
			}
		});

		adb.setCancelable(true);
		adb.show();
	}

	/**
	 * @param view
	 * @param id
	 */
	public void showItemDetailC(View view, int id) {
		AlertDialog.Builder adb = new AlertDialog.Builder(OneClaimActivity.this);
		LayoutInflater factory = LayoutInflater.from(OneClaimActivity.this);
		View itemInfoCDialogView = factory.inflate(
				R.layout.activity_item_detail, null);
		adb.setView(itemInfoCDialogView);

		itemName = (TextView) itemInfoCDialogView
				.findViewById(R.id.currentItemNameTextView);
		amount = (TextView) itemInfoCDialogView
				.findViewById(R.id.currentItemAmountTextView);
		itemDate = (TextView) itemInfoCDialogView
				.findViewById(R.id.currentItemDateTextView);
		category = (TextView) itemInfoCDialogView
				.findViewById(R.id.currentItemCateTextView);
		descript = (TextView) itemInfoCDialogView
				.findViewById(R.id.currentDescripTextView);

		descript.setText(claim.getItems().get(id).getItemName());

		// amount.setText(claim.getItems().get(id).getCurrency().getType()+String.valueOf(claim.getItems().get(id).getCurrency().getAmount()));
		amount.setText(claim.getItems().get(id).getItemCurrency().toString());

		// Toast.makeText(this,
		// claim.getItems().get(id).getCurrency().getType(),
		// Toast.LENGTH_LONG).show();
		// amount.setText(claim.getItems().get(id).getCurrency().getType());
		// +String.valueOf(claim.getItems().get(id).getCurrency().getAmount())
		// amount.setText(String.valueOf(claim.getItems().get(id).getCurrency().getAmount()));

		Date idate = claim.getItems().get(id).getItemDate();
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String dateOutput = df.format(idate);
		itemDate.setText(dateOutput);
		itemName.setText(claim.getItems().get(id).getItemName());
		category.setText(claim.getItems().get(id).getItemCategory());
		descript.setText(claim.getItems().get(id).getItemDescription());

		// set the Edit Button on the Dialog
		/*
		 * adb.setNeutralButton("Edit", new OnClickListener() { public void
		 * onClick(DialogInterface dialog, int which) {
		 * Toast.makeText(OneClaimActivity.this,
		 * "Clicked On Edit",Toast.LENGTH_SHORT).show(); Intent intent = new
		 * Intent(OneClaimActivity.this, EditItemActivity.class);
		 * startActivity(intent); } });
		 */

		adb.setCancelable(true);
		adb.show();
	}

	/**
	 * @param view
	 * @param id
	 */
	public void showItemDetailA(View view, int id) {
		AlertDialog.Builder adb = new AlertDialog.Builder(OneClaimActivity.this);

		LayoutInflater factory = LayoutInflater.from(OneClaimActivity.this);
		View itemInfoCDialogView = factory.inflate(
				R.layout.activity_item_detail_a, null);
		adb.setView(itemInfoCDialogView);

		itemName = (TextView) itemInfoCDialogView
				.findViewById(R.id.currentItemNameTextView);
		amount = (TextView) itemInfoCDialogView
				.findViewById(R.id.currentItemAmountTextView);
		itemDate = (TextView) itemInfoCDialogView
				.findViewById(R.id.currentItemDateTextView);
		category = (TextView) itemInfoCDialogView
				.findViewById(R.id.currentItemCateTextView);
		descript = (TextView) itemInfoCDialogView
				.findViewById(R.id.currentDescripTextView);
		claimantView = (TextView) itemInfoCDialogView
		.findViewById(R.id.testClaimantTextView);
		itemName.setText(claim.getItems().get(id).getItemName());

		amount.setText(claim.getItems().get(id).getItemCurrency().getType()
				+ String.valueOf(claim.getItems().get(id).getItemCurrency()
						.getAmount()));

		Date idate = claim.getItems().get(id).getItemDate();
		DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
		String dateOutput = df.format(idate);
		itemDate.setText(dateOutput);

		category.setText(claim.getItems().get(id).getItemCategory());
		descript.setText(claim.getItems().get(id).getItemDescription());

		adb.setNeutralButton("Add Comment", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(OneClaimActivity.this, "Clicked On Add Comment",
						Toast.LENGTH_SHORT).show();
				/**
				 * You need to add code here to do the addComment stuff Once the
				 * approver click this, the comment will be add for the current
				 * claim
				 **/
			}
		});

		adb.setCancelable(true);
		adb.show();
	}

	/**
	 * 
	 */
	public void checkUserType() {
		if (isClaimant) {
			approverView.setVisibility(View.GONE);
		}else{
			claimantView.setVisibility(View.GONE);
		}

	}
	class UpdateThread extends Thread {
		private Claim claim;

		public UpdateThread(Claim claim) {
			this.claim = claim;
		}

		@Override
		public void run() {
			try {
				onlineManager.updateClaim(claim);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			runOnUiThread(doFinishUpdate);
		}
	}
	
	class getClaimThread extends Thread{
		private String claimName;
		
		public getClaimThread(String claimName){
			this.claimName = claimName;
		}
		
		public void run(){
			controller = new OneClaimController2(onlineManager.getClaim(claimName));
			runOnUiThread(doFinishLoad);
		}
		
	}
	
}
