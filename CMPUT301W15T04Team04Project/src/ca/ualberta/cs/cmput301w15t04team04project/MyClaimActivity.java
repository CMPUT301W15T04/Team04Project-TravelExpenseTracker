package ca.ualberta.cs.cmput301w15t04team04project;

import java.io.IOException;

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ClaimListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

/**
 * <ol>
 * <li type = "square"><b>The function of MyClaimActivity (class):</b> 
 * <ol>
 * <li>Creating the MyClaimActivity
 * <li>Loading the data of the user
 * <li>Loading the data of ClaimList form Manager according to the status of a user (Claimant or Approver)
 * <li>Giving different mode a corresponding view
 * </ol>
 * </ol>
 * 
 * @author youdong
 * @author Weijie Sun
 * @version 1.0
 * @since 2015-03-11
 * @author Chenrui Lei
 * @author Yufei Zhang
 * @version 1.1
 * @since 2015-03-15
 */

public class MyClaimActivity extends Activity {
	public static int mode;
	private ActionBar actionBar;
	private Menu claimMenu;
	private boolean progressing;
	private MyLocalClaimListController controller;
	private MyClaimActivity thisActivity = this;
	private User user;
	private ListView listView;
	private CLmanager onlineManager = new CLmanager();
	private ClaimListAdapter claimListAdapter = null;
	private String tag = null;
	private Runnable doFinish = new Runnable() {
		public void run() {
			claimListAdapter.notifyDataSetChanged();
		}
	};

	/**
	 * Called to do initial creation of a fragment.<br>
	 * This is called after onAttach(Activity) and before onCreateView(LayoutInflater, ViewGroup, Bundle).<br>
	 * Note that this can be called while the fragment's activity is still in the process of being created.<br>
	 * As such, you can not rely on things like the activity's content view hierarchy being initialized at this point.<br>
	 * If you want to do work once the activity itself is created, see onActivityCreated(Bundle).<br>
	 * 
	 * @param savedInstanceState	If the fragment is being re-created from a previous saved state, this is the state.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_claim);
		user = SignInManager.loadFromFile(this);
		actionBar = getActionBar();
		controller = new MyLocalClaimListController();
		if (user.getName().equals("approval")) {
			Thread search = new SearchClaimThread(null ,"submitted", null);
			search.start();
		} else {
			if (mode == 0) {
				actionBar.setTitle("Progresing Claims");
				progressing = true;
				Thread search = new SearchClaimThread(user.getName(), "Progress", null);
				search.start();
			} else if (mode == 1) {
				actionBar.setTitle("Submitted Claims");
				progressing = false;
				Thread search = new SearchClaimThread(user.getName(), "submitted", null);
				search.start();
			} else if (mode == 2) {
				actionBar.setTitle("Approved Claims");
				Thread search = new SearchClaimThread(user.getName(), "approved", null);
				search.start();
				progressing = false;
			} else if (mode == 3) {
				actionBar.setTitle("Returned Claims");
				Thread search = new SearchClaimThread(user.getName(), "returned", null);
				search.start();
				progressing = false;
			} else if (mode == 4) {
				
				Bundle bundle = getIntent().getExtras();
				tag = bundle.getString("tag");
				actionBar.setTitle("Search Results:" + tag);
				Thread search = new SearchClaimThread(user.getName(), null, tag);
				search.start();
				progressing = false;
			} 
		}
		listView = (ListView) findViewById(R.id.myClaimsListView);
		claimListAdapter = new ClaimListAdapter(thisActivity,
				R.layout.single_claim, controller.getClaims());
		listView.setAdapter(claimListAdapter);
		if (user.getName().equals("approval") || (mode == 1) || (mode == 2)) {
		} else {
			listView.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> adapterView,
						View view, int position, long id) {
					final int finalPosition = position;
					// Claim claim = list.get(finalPosition);
					AlertDialog.Builder adb = new AlertDialog.Builder(
							MyClaimActivity.this);
					// adb.setMessage(claim.getClaim()+" total cost \n"+claim.getAmount()+"\n From "+claim.getStartDate()+" to "+claim.getEndDate());
					adb.setCancelable(true);

					adb.setPositiveButton("Delete", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Thread delete = new DeleteThread(controller
									.getClaims().get(finalPosition).getClaim(),
									finalPosition);
							delete.start();
						}
					});

					adb.setNeutralButton("Edit", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// controller.deleteClaim(finalPosition);
							// MyLocalClaimListManager.saveClaimList(getApplicationContext(),
							// controller.getClaimList(),"local");
							/*
							 * Toast.makeText(MyClaimActivity.this, "Claim  " +
							 * finalPosition + " MC Act",
							 * Toast.LENGTH_SHORT).show();
							 */
							Intent myIntent = new Intent(MyClaimActivity.this,
									EditClaimActivity.class);
							myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							myIntent.putExtra("MyClaimName", controller
									.getClaims().get(finalPosition).getClaim());
							MyClaimActivity.this.startActivity(myIntent);
							finish();
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
		}
		
		
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				int itemPosition = position;
				Toast.makeText(MyClaimActivity.this, "Edit Claim" + position,
						Toast.LENGTH_SHORT).show();
				Intent myintent = new Intent(MyClaimActivity.this,
						OneClaimActivity.class);
				myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				myintent.putExtra("MyClaimName",
						controller.getClaims().get(itemPosition).getClaim());
				MyClaimActivity.this.startActivity(myintent);
				finish();
			}
		});

		/**
		 * set up claim listing adapter
		 * 
		 * @author Chenrui Lei
		 * @version 1.0
		 * @since 2015-03-13
		 */
		// set up claim listing adapter
		/*
		 * ClaimListAdapter claimListAdapter = new ClaimListAdapter(this,
		 * R.layout.single_claim, claims.getClaimArrayList());
		 * listView.setAdapter(claimListAdapter);
		 * claimListAdapter.notifyDataSetChanged();
		 */

	}
	/**
	* This method is start activity
	*/
	@Override
	protected void onStart() {
		super.onStart();

	}

	/**
	 * This boolean function is to activate the option menu.
	 * Initialize the contents of the Activity's standard options menu.<br>
	 * You should place your menu items in to menu.<br>
	 * For this method to be called, you must have first called setHasOptionsMenu(boolean).<br>
	 * See Activity.onCreateOptionsMenu for more information.
	 * 
	 * @param menu	The options menu in which you place your items.
	 * @see setHasOptionsMenu(boolean)
	 * @see onPrepareOptionsMenu(Menu)<br>
	 * @see onOptionsItemSelected(MenuItem)
	 * 
	 * @author Yufei Zhang
	 * @version 1.0
	 * @since 2015-03-13
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_claim, menu);
		menu.findItem(R.id.action_new_claim).setVisible(progressing);
		claimMenu = menu;
		return true;
	}

	/**
	 * This void function is to lead user to the page that can add or edit a claim.<br>
	 * It will use the menu item you created in the menu.<br>
	 * For this method to be called, you must called the onCreatOptionMenu(boolean)<br>
	 * 
	 * @param item The item in the option menu, which is show as a "+" on the screen leading user to adding a new claim.
	 */
	public void goToEditClaim(MenuItem item) {
		Intent intent = new Intent(MyClaimActivity.this,
				EditClaimActivity.class);
		startActivity(intent);
		finish();
	}

	/**
	 * This function is only using for testing.
	 * This function is to get the id for the menu item.
	 * 
	 * @return claimMenu The menu item for adding a claim.
	 */
	// get the menuItem for testing
	public MenuItem getMyClaimMenuItem() {
		return claimMenu.findItem(R.id.action_new_claim);
	}
	/**
	* This class is search the Claim in the thread which meet the tag 
	* @param claim This is the claim which should be add in the CLManager 
	* @exception IOException On input error.
	* @see IOException
	* @exception IllegalStateException On input error.
	* @see IllegalStateException
	*/
	class SearchClaimThread extends Thread {
		private String userName;
		private String status;
		private String tag;
		
		public SearchClaimThread(String userName, String status, String tag) {
			this.status = status;
			this.tag = tag;
			this.userName = userName;
		}

		public void run() {
			controller.clear();
			controller.addall(onlineManager.searchClaimList(userName, status, tag));
			if (user.getName().equals("approval")) {
				controller.sortClaimOldFirst();
			} else {
				controller.sortClaimNewFirst();
			}
			runOnUiThread(doFinish);
		}
	}
	/**
	* This class is delete claim thread to delete the claim that user choose the position
	* @param claim This is the claim which should be add in the CLManager 
	* @exception IOException On input error.
	* @see IOException
	* @exception IllegalStateException On input error.
	* @see IllegalStateException
	*/
	class DeleteThread extends Thread {
		private String claimName;
		private int pos;

		public DeleteThread(String claimName, int pos) {
			this.claimName = claimName;
			this.pos = pos;
		}

		public void run() {
			onlineManager.deleteClaim(claimName);
			controller.deleteClaim(pos);
			runOnUiThread(doFinish);
		}
	}
}
