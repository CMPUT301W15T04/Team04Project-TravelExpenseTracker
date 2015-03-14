package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;
import java.util.Collection;
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
* The MyClaim Activity is the profile my claims. which is write without Internet environment .
*
* @author  Weijie Sun
* @version 1.0
* @since   2015-03-11
*/

public class MyClaimActivity extends Activity {

	//private ArrayList<String> claims = new ArrayList<String>();
	
	protected static int mode;
	private ActionBar actionBar;

	
	private MyLocalClaimListController controller;
	private MyClaimActivity thisActivity = this;
	private ClaimList claimList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_claim);
		
		actionBar = getActionBar();
		if (mode == 0) {
			actionBar.setTitle("Progresing Claims");
		}
		else if (mode == 1) {
			actionBar.setTitle("Submitted Claims");
		}
		else if (mode == 2) {
			actionBar.setTitle("Approved Claims");
		}
		else {
			actionBar.setTitle("Saved Claims");
		}
		claimList = MyLocalClaimListManager.loadClaimList(this, "local");
/*    	CLmanager.initManager(this.getApplicationContext());
 
		ListView listView = (ListView) findViewById(R.id.claimListView);
		List<Claim> claims = ClaimListController.getClaimList().getClaims();//change the collection into list
		
		Collections.sort(claims,new Comparator<Claim>() {
	        @Override  
            public int compare(Claim b1, Claim b2) {  
                return b1.getStartDate().compareTo(b2.getStartDate());  
            }  
		});
		*/
    	// should be changed
		//List<Claim> claims = CLmanager.getClaimList().getClaimList();
		
		//old
		/*
		for (int i=0;i<10;i++){
			
			claims.add("claims" + i);
			
		}
		
		ListView listView = (ListView) findViewById(R.id.MyClaimslistView);
		final ArrayList<String> list = new ArrayList<String>(claims);
		final ArrayAdapter<String> claimAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);*/

		//new
		

    	ListView listView = (ListView) findViewById(R.id.myClaimsListView);
    	controller = new MyLocalClaimListController(claimList);
    	final ArrayList<Claim> claims = controller.getClaims();
    	final ClaimListAdapter claimListAdapter = new ClaimListAdapter(this, R.layout.single_claim,
				claims);
		listView.setAdapter(claimListAdapter);
		controller.getClaimList().addListener(new Listener() {

			@Override
			public void update() {
				// TODO Auto-generated method stub
				claims.clear();
				Collection<Claim> claims = controller.getClaims();
				claims.addAll(claims);
				claimListAdapter.notifyDataSetChanged();
			}
		});
    	listView.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
				final int finalPosition = position;
				//Claim claim = list.get(finalPosition);
				AlertDialog.Builder adb = new AlertDialog.Builder(MyClaimActivity.this);
				//adb.setMessage(claim.getClaim()+" total cost \n"+claim.getAmount()+"\n From "+claim.getStartDate()+" to "+claim.getEndDate());
				adb.setCancelable(true);

				adb.setPositiveButton("Delete", new OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						controller.deleteClaim(finalPosition);
						MyLocalClaimListManager.saveClaimList(getApplicationContext(), controller.getClaimList(),"local");
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

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				int itemPosition = position;
				Toast.makeText(MyClaimActivity.this, "Edit Claim"+position ,Toast.LENGTH_SHORT).show();
				Intent myintent = new Intent(MyClaimActivity.this,
						OneClaimActivity.class);
				myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				myintent.putExtra("MyClaimid", itemPosition);
				MyClaimActivity.this.startActivity(myintent);				
			}
		});
		
		
		
		/**
		* set up claim listing adapter
		*
		* @author  Chenrui Lei
		* @version 1.0
		* @since   2015-03-13
		*/
		// set up claim listing adapter
		/*
		ClaimListAdapter claimListAdapter = new ClaimListAdapter(this, R.layout.single_claim,
								claims.getClaimArrayList());
		listView.setAdapter(claimListAdapter);
		claimListAdapter.notifyDataSetChanged();
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
	* @author  Yufei Zhang
	* @version 1.0
	* @since   2015-03-13
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_claim, menu);
		return true;
	}

	public void goToSearch(MenuItem item) {
		Intent intent = new Intent(MyClaimActivity.this, SearchActivity.class);
		startActivity(intent);
	}

	public void goToEditClaim(MenuItem item) {
		Intent intent = new Intent(MyClaimActivity.this, EditClaimActivity.class);
		startActivity(intent);
		finish();
	}
}
