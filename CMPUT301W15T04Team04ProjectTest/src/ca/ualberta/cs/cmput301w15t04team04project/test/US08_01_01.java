package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ClaimListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.ListView;

public class US08_01_01 extends ActivityInstrumentationTestCase2<MyClaimActivity>{
	
	private ClaimListAdapter claimAdapter; 

	/**
	* The Approver_02_Test method is extend the super class MainActivity
	*
	* @author  Weijie Sun
	* @version 1.0
	* @since   2015-03-08
	*/
	public US08_01_01(Class<MyClaimActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}

	
	/**
	* The sortedClaimListTest method tests if the listview equals and show by ordered
	*
	* @author  Weijie Sun
	* @version 1.0
	* @since   2015-03-08
	*/
	protected void viewAClaimTest() {
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.getClaimArrayList().add(AClaim);
		testClaimList.getClaimArrayList().add(BClaim);
		testClaimList.getClaimArrayList().add(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		AClaim.setClaim("1");

		Date Adate = new Date();
		Adate.setYear(2013);
		Date Bdate = new Date();
		Bdate.setYear(2014);
		Date Cdate = new Date();
		Cdate.setYear(2015);
		
		AClaim.setStartDate(Adate);
		BClaim.setStartDate(Bdate);
		CClaim.setStartDate(Cdate);
		ListView claimlistview = (ListView) getActivity().findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView); //listView
		//some problem here
		claimAdapter = new ClaimListAdapter(getActivity(), 0, testClaimList.getClaimArrayList());
		View view = claimAdapter.getView(0, null, null);
		ListView listview = (ListView) getActivity().findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView);  
		
		//
		assertEquals("index 0 equals", listview.getChildAt(0).equals(view));
/*		assertEquals("index 1 equals", listview.getChildAt(1).equals(BClaim));
		assertEquals("index 2 equals", listview.getChildAt(2).equals(CClaim));*/

		
/*		assertTrue("first item is true", testClaimList.getSubmittedClaimList()
				.get(1).getItemList().get(0).equals(itemB));
		assertTrue("first item is true", testClaimList.getSubmittedClaimList()
				.get(0).getItemList().get(0).equals(itemA));

		testOpenNextActivity(MainActivity, AddEditClaimActivity);
		View v = activity.getWindow().getDecorView()
				.findViewById(android.R.id.MainClaimListView);
		assertTrue("Toast is shown", v.isShown());
*/
		
		
	}

}
