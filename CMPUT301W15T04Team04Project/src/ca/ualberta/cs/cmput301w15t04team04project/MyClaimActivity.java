package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
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

	private ArrayList<String> claims = new ArrayList<String>();

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_claim);

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
/*	
		List<Claim> claims = null;
		
		Claim AClaim = new Claim("AClaim");
		Claim BClaim = new Claim("BClaim");	
		claims.add(AClaim);
		claims.add(BClaim);*/
		
		for (int i=0;i<10;i++){
			
			claims.add("claims" + i);
		}
		
    	ListView listView = (ListView) findViewById(R.id.MyClaimslistView);

		//final ArrayList<Claim> list = new ArrayList<Claim>(claims);
		final ArrayList<String> list = new ArrayList<String>(claims);
		//final ArrayAdapter<Claim> claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1, list);
		final ArrayAdapter<String> claimAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

		listView.setAdapter(claimAdapter);
		claimAdapter.notifyDataSetChanged();
		
/*    	CLmanager.getClaimList().addListener(new Listener(){
    		@Override
    		public void update() {
    			list.clear();
    			Collection<Claim> claims = ClaimListController.getClaimList().getClaims();
    			list.addAll(claims);
    			claimAdapter.notifyDataSetChanged();
    		}
 
    	});*/
    	
    	//this is the list view to edit and delete the Claim

    	listView.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				final int finalPosition = position;
				//Claim claim = list.get(finalPosition);
				AlertDialog.Builder adb = new AlertDialog.Builder(MyClaimActivity.this);
				//adb.setMessage(claim.getClaim()+" total cost \n"+claim.getAmount()+"\n From "+claim.getStartDate()+" to "+claim.getEndDate());
				adb.setCancelable(true);

				adb.setNeutralButton("Edit", new OnClickListener(){
					public void onClick(DialogInterface dialog, int which){
						
						//taken from http://handsomeliuyang.iteye.com/blog/1315283
						Intent myintent = new Intent(MyClaimActivity.this, OneClaimActivity.class);
						myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						myintent.putExtra("MyClaimid", finalPosition);
				    	startActivity(myintent);
				}
					
				});
				
		          
    	
				adb.setPositiveButton("Delete", new OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						/*Claim claim = list.get(finalPosition);
						ClaimListController.getClaimList().removeClaim(claim);
						ClaimListController.saveClaimList();*/
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
				Toast.makeText(MyClaimActivity.this,
						"open a Claim" + itemPosition, Toast.LENGTH_SHORT)
						.show();
				Intent myintent = new Intent(MyClaimActivity.this,
						OneClaimActivity.class);
				myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				myintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				myintent.putExtra("MyClaimid", itemPosition);
				startActivity(myintent);
			}
		});
	
	}
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_claim, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
