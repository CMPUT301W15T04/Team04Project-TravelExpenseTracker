package ca.ualberta.cs.cmput301w15t04team04project;

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
 * The MyClaim Activity is the profile my claims. which is write without
 * Internet environment .
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
			} else if (mode == 4) {
				actionBar.setTitle("Search Results");
				Bundle bundle = getIntent().getExtras();
				tag = bundle.getString("tag");
				Thread search = new SearchClaimThread(user.getName(), null, tag);
				search.start();
				progressing = false;
			} else {
				actionBar.setTitle("Saved Claims");
				progressing = false;
			}
		}
		listView = (ListView) findViewById(R.id.myClaimsListView);
		claimListAdapter = new ClaimListAdapter(thisActivity,
				R.layout.single_claim, controller.getClaims());
		listView.setAdapter(claimListAdapter);
		/*
		 * controller.getClaimList().addListener(new Listener() {
		 * 
		 * @Override public void update() { // TODO Auto-generated method stub
		 * claims.clear(); Collection<Claim> claims2 = null; if (mode == 0) {
		 * indeies = controller.getIndexList("In Progress"); claims2 =
		 * controller.getClaimsByIndex(indeies); } else if (mode == 1) { indeies
		 * = controller.getIndexList("submitted"); claims2 =
		 * controller.getClaimsByIndex(indeies); } else if (mode == 2) { indeies
		 * = controller.getIndexList("approved"); claims2 =
		 * controller.getClaimsByIndex(indeies); } else { progressing = false; }
		 * claims.addAll(claims2); claimListAdapter.notifyDataSetChanged(); }
		 * });
		 */
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

	@Override
	protected void onStart() {
		super.onStart();

	}

	/**
	 * The MyClaimActivity relates to "My Claim" in "profile" of MainActivity.
	 * But it needs some button on the title bar to add claim
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
		menu.findItem(R.id.action_search).setVisible(progressing);
		claimMenu = menu;
		return true;
	}

	public void goToSearch(MenuItem item) {
		Intent intent = new Intent(MyClaimActivity.this, SearchActivity.class);
		startActivity(intent);
	}

	public void goToEditClaim(MenuItem item) {
		Intent intent = new Intent(MyClaimActivity.this,
				EditClaimActivity.class);
		startActivity(intent);
		finish();
	}

	// get the menuItem for testing
	public MenuItem getMyClaimMenuItem() {
		return claimMenu.findItem(R.id.action_new_claim);
	}

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
