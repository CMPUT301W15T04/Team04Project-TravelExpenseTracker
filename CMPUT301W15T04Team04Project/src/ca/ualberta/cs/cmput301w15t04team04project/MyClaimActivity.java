package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ClaimListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Listener;
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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

/**
 * The MyClaim Activity is the profile my claims. which is write without
 * Internet environment .
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

	// private ArrayList<String> claims = new ArrayList<String>();

	public static int mode;
	private ActionBar actionBar;
	private boolean progressing;

	private MyLocalClaimListController controller;
	private MyClaimActivity thisActivity = this;
	private ClaimList claimList;
	private ArrayList<Claim> claims;
	private ArrayList<Integer> indeies;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_claim);
		claimList = MyLocalClaimListManager.loadClaimList(this);
		controller = new MyLocalClaimListController(claimList);

		actionBar = getActionBar();
		if (mode == 0) {
			actionBar.setTitle("Progresing Claims");
			indeies = controller.getIndexList("In Progress");
			progressing = true;
		} else if (mode == 1) {
			actionBar.setTitle("Submitted Claims");
			indeies = controller.getIndexList("submitted");
			progressing = false;
		} else if (mode == 2) {
			actionBar.setTitle("Approved Claims");
			indeies = controller.getIndexList("approved");
			progressing = false;
		} else {
			actionBar.setTitle("Saved Claims");
			progressing = false;
		}

		claims = controller.getClaimsByIndex(indeies);

		ListView listView = (ListView) findViewById(R.id.myClaimsListView);
		final ClaimListAdapter claimListAdapter = new ClaimListAdapter(this,
				R.layout.single_claim, claims);
		listView.setAdapter(claimListAdapter);
		controller.getClaimList().addListener(new Listener() {

			@Override
			public void update() {
				// TODO Auto-generated method stub
				claims.clear();
				Collection<Claim> claims2 = null;
				if (mode == 0) {
					indeies = controller.getIndexList("In Progress");
					claims2 = controller.getClaimsByIndex(indeies);
				} else if (mode == 1) {
					indeies = controller.getIndexList("submitted");
					claims2 = controller.getClaimsByIndex(indeies);
				} else if (mode == 2) {
					indeies = controller.getIndexList("approved");
					claims2 = controller.getClaimsByIndex(indeies);
				} else {
					progressing = false;
				}
				claims.addAll(claims2);
				claimListAdapter.notifyDataSetChanged();
			}
		});
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
						controller.deleteClaim(indeies.get(finalPosition));
						MyLocalClaimListManager.saveClaimList(
								getApplicationContext(),
								controller.getClaimList());
					}
				});

				adb.setNeutralButton("Edit", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// controller.deleteClaim(finalPosition);
						// MyLocalClaimListManager.saveClaimList(getApplicationContext(),
						// controller.getClaimList(),"local");
						Toast.makeText(MyClaimActivity.this,
								"Claim  " + finalPosition + " MC Act",
								Toast.LENGTH_SHORT).show();
						Intent myIntent = new Intent(MyClaimActivity.this,
								EditClaimActivity.class);
						myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						myIntent.putExtra("myClaimId",
								indeies.get(finalPosition));
						MyClaimActivity.this.startActivity(myIntent);

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
				myintent.putExtra("myClaimId", indeies.get(itemPosition));
				MyClaimActivity.this.startActivity(myintent);
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
}
